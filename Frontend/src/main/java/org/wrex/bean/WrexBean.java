package org.wrex.bean;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.wrex.domain.User;
import org.wrex.i18n.i18nBean;
import org.wrex.security.LoginBean;
import org.wrex.service.UserService;

public abstract class WrexBean {

	@ManagedProperty("#{loginBean}")
	private LoginBean login;

	@ManagedProperty("#{i18nBean}")
	private i18nBean i18n;

	@ManagedProperty("#{userService}")
	protected UserService userService;

	/**
	 * Return a localized string
	 * @param code
	 * @return
	 */
	protected String i18n(String code) {
		return i18n.get(code);
	}
	
	/**
	 * Update an id in the request context. For refreshing JSF componentes from the backinb bean.
	 * @param id
	 */
	public void update(String id) {
		RequestContext.getCurrentInstance().update(id);
	}

	/**
	 * Execute a JS in the requesContext
	 * @param command
	 */
	public void execute(String command) {
		RequestContext.getCurrentInstance().execute(command);
	}

	/**
	 * Adds a success mesage using the locale of the session
	 * @param code Code at the i18n.wrex bundle
	 */
	public void succesMessageLocale(String code) {
		addSuccessMessage(ResourceBundle.getBundle("i18n.wrex",
				FacesContext.getCurrentInstance().getViewRoot().getLocale())
				.getString(code));
	}
	
	/**
	 * Adds a success mesage using the locale of the session
	 * @param code Code at the i18n.wrex bundle
	 */
	public void errorMessageLocale(String code) {
		addErrorMessage(ResourceBundle.getBundle("i18n.wrex",
				FacesContext.getCurrentInstance().getViewRoot().getLocale())
				.getString(code));
	}

	/**
	 * Add errors to jsf messages
	 * 
	 * @param messages
	 */
	public void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(message);
		}
	}

	/**
	 * Add error to jsf messages
	 * 
	 * @param messages
	 */
	public void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	/**
	 * Add errors to jsf messages
	 * 
	 * @param messages
	 */
	public void addErrorMessage(String title, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				title, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	public void addSuccessMessage(String title, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				title, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	public void addInfoMessage(String title, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				title, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	public void addSuccessMessage(String msg) {
		addSuccessMessage(msg, msg);
	}

	public LoginBean getLogin() {
		return login;
	}

	public i18nBean getI18n() {
		return i18n;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public void setI18n(i18nBean i18n) {
		this.i18n = i18n;
	}

	protected User loggedUser() {
		return login.getUser();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
