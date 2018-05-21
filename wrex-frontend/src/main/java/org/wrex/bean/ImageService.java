package org.wrex.bean;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Service;
import org.wrex.utils.Scalr;
import org.wrex.utils.Scalr.Method;

/**
 * Service for storing uploaded images on the disk. If running on tomcat images are stored at
 * webapps/wrexImages 
 * 
 * Change function getRoot if you want to uses this.
 * @author ggefaell
 *
 */
@Service("imageService")
public class ImageService {

	private static final String thumb_pre = "thumb_";
	private static final int MAX_SIZE = 1400;

	/**
	 * Downloads from an url and store the image.
	 * @param idImage
	 * @param url
	 */
	public void storeImage(String idImage, String url) {
		try {
			URL website = new URL(url);
			Path pathToFile = Paths.get(getRoot());
			ReadableByteChannel rbc;
			rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(pathToFile.resolve(
					idImage).toFile());
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.flush();
			fos.close();
			rbc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates or updates and image.  Creates a 150x150 thumbnail called thumb_idImage.
	 * @param file Uploaded file 
	 * @param idImage name of the file to write.
	 * @param oldIdImage Delete this image and its thumbnail
	 */
	public void creatOrUpdateImage(UploadedFile file, String idImage,
			String oldIdImage) {
		creatOrUpdateImage(file, idImage, oldIdImage, 150);
	}

	/**
	 * Creates or updates and image.  Creates a thumbSizexthumbSize thumbnail called thumb_idImage.
	 * @param file Uploaded file 
	 * @param idImage name of the file to write.
	 * @param oldIdImage Delete this image and its thumbnail
	 */
	public void creatOrUpdateImage(UploadedFile file, String idImage,
			String oldIdImage, Integer thumbSize) {
		if (file != null) {
			try {
				storeImage(idImage, IOUtils.toByteArray(file.getInputstream()));
				resizeImage(idImage);
				createThumbnail(idImage, thumbSize, thumb_pre);
				deleteOld(oldIdImage);
			} catch (IOException e) {
				System.out.println(">>>>> idImage = " + idImage);
			}
		}
	}

	private void resizeImage(String idImage) {
		createThumbnail(idImage, MAX_SIZE, "");
	}

	private void createThumbnail(String idImage, Integer size, String prefix) {
		File image = Paths.get(getRoot()).resolve(idImage).toFile();
		BufferedImage i = null;
		try {
			i = ImageIO.read(image);
			BufferedImage thumbnail = i;
			if (i.getWidth() > size || i.getHeight() > size) { //dont resize if image is smaller that max_size
				thumbnail = Scalr.resize(i, Method.QUALITY, size, size);
			}
			File outputfile = Paths.get(getRoot())
					.resolve(prefix.concat(idImage)).toFile();
			ImageIO.write(thumbnail,
					StringUtils.substringAfterLast(idImage, "."), outputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteOld(String fileName) throws IOException {
		if (fileName == null || fileName.isEmpty())
			return;
		Path pathToFile = Paths.get(getRoot());
		if (Files.exists(pathToFile.resolve(fileName))) {
			Files.delete(pathToFile.resolve(fileName));
		}
		if (Files.exists(pathToFile.resolve(thumb_pre.concat(fileName)))) {
			Files.delete(pathToFile.resolve(thumb_pre.concat(fileName)));
		}
	}

	private void storeImage(String fileName, byte[] file) throws IOException {
		Path pathToFile = Paths.get(getRoot());
		if (Files.createDirectories(pathToFile) != null) {
			Files.write(pathToFile.resolve(fileName), file,
					StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		}
	}

	// TODO: To Configuration.Dev only.
	private String getRoot() {
		if (System.getProperty("testingImageFolder") != null) //this is for running the project with jetty
			return System.getProperty("testingImageFolder");
		else {
			String catalina = System.getProperty("catalina.base");
			return catalina.concat("/webapps/wrexImages");
		}
	}
}
