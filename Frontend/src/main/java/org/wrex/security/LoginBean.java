package org.wrex.security;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.RandomStringUtils;
import org.primefaces.context.RequestContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.wrex.api.domain.UserDTO;
import org.wrex.bean.ImageService;
import org.wrex.entities.User;
import org.wrex.service.UserService;
import org.wrex.utils.JsfUtils;
import org.wrex.utils.PasswordUtil;

/**
 * Use this mb to know if users is logged or get the current logged user. WrexBean, abstract class thath all MB can extend, already has this as a managedproperty, so you cang
 * get the logged user on every mb.
 * @author ggefaell
 *
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager = null;

	@ManagedProperty("#{userService}")
	private UserService userService;
	
	@ManagedProperty("#{imageService}")
	private ImageService imageService;

	private UserDTO user;

	private String userName = null;
	private String password = null;

	public boolean isLogged() {
		return user != null;
	}
	
	public void loginFB() throws Exception{
		
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("url");
		String name = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("name");
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		String mail = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mail");
		UserDTO user =userExist(id); 
		if (user==null){
			String idPicture = "user"+id.substring(0,2)+RandomStringUtils.randomAlphanumeric(3)+".jpg";
			user = new UserDTO();
			user.setName(name);
			if (mail == null || mail.isEmpty() || mail.equals("undefined"))
				user.setEmail(name);
			else
				user.setEmail(mail);
			user.setRole(0);
			user.setPassword(PasswordUtil.encrypPassword(id));
			user.setStatus(1);
			user.setIdpicture(idPicture);
			user.setIdUserFB(id);
			userService.save(user);
			imageService.storeImage(idPicture,url);
		}
		this.userName = user.getEmail();
		this.password = id;
		login();
	}
	
	private UserDTO userExist(String id) {
		UserDTO param = new UserDTO();
		param.setIdUserFB(id);;
		UserDTO user = userService.getByIdFb(id);
		if (user !=null){
			JsfUtils.succesMessageLocale("user_emailExist");
			return user;
		}
		return null;
	}

	/**
	 * Do login and reload current page. Useful for popup login dialogs.
	 */
	public void login() {
		doLogin(true,"");
	}
	
	/**
	 * Do login and go to default page using location.assign(). It's hardcoded, but you can refactor thism right? 
	 */
	public void loginRedirect(String url) {
		doLogin(false,url);
	}
	
	
	private void doLogin(boolean reload, String url){
		if (userName==null)
			JsfUtils.errorMessageLocale("user_loginError");
		UserDTO user = userService.getByEmail(userName);
		if (user == null)
			JsfUtils.errorMessageLocale("user_loginError");
		else {
			try {
				Authentication request = new UsernamePasswordAuthenticationToken(
						this.getUserName(), PasswordUtil.encrypPassword(this
								.getPassword()));
				Authentication result = authenticationManager
						.authenticate(request);
				SecurityContextHolder.getContext().setAuthentication(result);
				if (result.isAuthenticated()) {
					this.user = user;
					if (reload)
						RequestContext.getCurrentInstance().execute(
							"location.reload(true)");
					else{
						RequestContext.getCurrentInstance().execute("location.assign('"+url+"')");
					}
				}
			} catch (AuthenticationException e) {
				JsfUtils.errorMessageLocale("user_loginError");
			}
		}
		
	}
	public boolean isRole(String role) {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			for (GrantedAuthority grant : SecurityContextHolder.getContext()
					.getAuthentication().getAuthorities()) {
				if (grant.getAuthority().equalsIgnoreCase(role))
					return true;
			}
		}
		return false;
	}

	public String cancel() {
		return null;
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		return "loggedout";
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

}
