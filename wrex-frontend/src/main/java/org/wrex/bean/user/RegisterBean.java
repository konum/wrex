package org.wrex.bean.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;
import org.wrex.api.domain.UserDTO;
import org.wrex.entities.User;
import org.wrex.service.UserService;
import org.wrex.utils.JsfUtils;
import org.wrex.utils.PasswordUtil;

@RequestScoped
@ManagedBean(name="registerBean")
public class RegisterBean {

	@ManagedProperty("#{userService}")
	UserService userService;
	
	
	private UserDTO register = new UserDTO();
	private String repeteadPassword;
	private boolean tosAccepted;
	

	public void register(){
		if (!register.getPassword().equals(repeteadPassword)){
			JsfUtils.succesMessageLocale("user_errorPassword");
		}else if (!emailExist()){
			register.setRole(User.__DEFAULT_ROLE);
			register.setPassword(PasswordUtil.encrypPassword(register.getPassword()));
			register.setStatus(User.ACTIVE); //you cand implement some kind of mail activation
			register.setIdpicture("nouser.jpg");
			//Example code of activation email
//			List<String> mail = new ArrayList<String>();
//        	mail.add(i18nBean.getCode("user_registerMail"));
//        	mail.add("http://www.wiklimb.com/wiklimb/user/activateAccount.xhtml?id="+register.getIduser()+"&key="+register.getActivationKey());
//        	mail.add(i18nBean.getCode("user_registerMail2"));
//        	SendMail.send(register.getEmail(),i18nBean.getCode("user_registerMailSubject"),mail);
			userService.save(register);
			RequestContext.getCurrentInstance().execute("PF('registerBar').show()");
			RequestContext.getCurrentInstance().execute("PF('registerDialog').hide()");
		}
	}

	private boolean emailExist() {
		UserDTO user = userService.getByEmail(register.getEmail());
		if (user != null){
			JsfUtils.succesMessageLocale("user_emailExist");
			return true;
		}
		return false;
	}
	
	public UserDTO getRegister() {
		return register;
	}

	public void setRegister(UserDTO register) {
		this.register = register;
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

	public boolean isTosAccepted() {
		return tosAccepted;
	}

	public void setTosAccepted(boolean tosAccepted) {
		this.tosAccepted = tosAccepted;
	}
}
