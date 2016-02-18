package org.wrex.bean.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.wrex.service.UserService;

@ManagedBean(name = "activateUserController")
@RequestScoped
//Activation is not implemented by default on wrex, but this code can give you a hint
public class ActivateUserController {

	private String key;
	private String id;

	@ManagedProperty("#{userService}")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void check() {
//		User param = new User();
//		try {
//			param.setIduser(Integer.parseInt(id));
//			List<User> results = userService.findAll(param);
//			if (results.isEmpty()) {
//				JsfUtils.errorMessageLocale("user_activateError");
//			} else {
//				User user = results.get(0);
//				if (user.getActivationKey().isEmpty()) {
//					JsfUtils.errorMessageLocale("user_activateAlready");
//				} else if (user.getActivationKey().equals(key)) {
//					user.setStatus(User.ACTIVE);
//					user.setActivationKey("");
//					userService.update(user);
//					JsfUtils.succesMessageLocale("user_activateSuccess");
//				}else{
//					JsfUtils.errorMessageLocale("user_activateError");
//				}
//			}
//		} catch (NumberFormatException nfe) {
//			JsfUtils.errorMessageLocale("user_activateError");
//		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
