package org.wrex.bean.user;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;
import org.wrex.api.domain.UserDTO;
import org.wrex.bean.ImageService;
import org.wrex.bean.WrexBean;
import org.wrex.entities.User;
import org.wrex.service.UserService;
import org.wrex.utils.JsfUtils;
import org.wrex.utils.PasswordUtil;

@ViewScoped
@ManagedBean(name = "userPanelController")
public class UserPanelController extends WrexBean {

	@ManagedProperty("#{imageService}")
	ImageService imageService;

	private UserDTO user;
	private String password;
	private String repeteadPassword;

	

	@PostConstruct
	public void init() {
		user = loggedUser();
	}

	public void save() {
		boolean valid = true;
		if (password != null && !password.equals(repeteadPassword)) {
			JsfUtils.errorMessageLocale("user_errorPassword");
			valid = false;
		}

		if (valid) {
			if (user.getPassword() != null && !password.isEmpty())
				user.setPassword(PasswordUtil.encrypPassword(password));
			userService.save(user);
			JsfUtils.succesMessageLocale("entityUpdated");
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
	        event.getFile();
	        String extension = StringUtils.substringAfterLast(
	        		event.getFile().getFileName(), ".").toLowerCase();
			String idImage = "user" + user.getIduser() + "-"
					+ RandomStringUtils.randomAlphanumeric(3) + "."
					+ extension;
			UserDTO loaded = userService.getByEmail(user.getEmail());
			loaded.setIdpicture(idImage);
			imageService.creatOrUpdateImage(event.getFile(), idImage,
					user.getIdpicture(), 40);
			userService.save(loaded);
			loggedUser().setIdpicture(idImage);
			JsfUtils.succesMessageLocale("picSaved");
	}

	public UserDTO getRegister() {
		return user;
	}

	public void setRegister(UserDTO register) {
		this.user = register;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getRepeteadPassword() {
		return repeteadPassword;
	}

	public void setRepeteadPassword(String repeteadPassword) {
		this.repeteadPassword = repeteadPassword;
	}


	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}


	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
