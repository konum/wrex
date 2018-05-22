package org.wrex.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(PasswordUtil.class);;

	private static MessageDigest md;

	public static String encrypPassword(String password) {
		if (logger.isDebugEnabled()) {
			logger.debug("encrypPassword(String) - start"); //$NON-NLS-1$
		}

		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = password.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			String returnString = sb.toString();
			if (logger.isDebugEnabled()) {
				logger.debug("encrypPassword(String) - end"); //$NON-NLS-1$
			}
			return returnString;
		} catch (NoSuchAlgorithmException ex) {
			logger.warn("encrypPassword(String) - exception ignored", ex); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("encrypPassword(String) - end"); //$NON-NLS-1$
		}
		return null;
	}
}
