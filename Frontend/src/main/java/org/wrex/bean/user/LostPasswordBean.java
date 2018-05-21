package org.wrex.bean.user;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.RandomStringUtils;
import org.primefaces.context.RequestContext;
import org.wrex.api.domain.UserDTO;
import org.wrex.bean.WrexBean;
import org.wrex.i18n.i18nBean;
import org.wrex.service.UserService;
import org.wrex.utils.JsfUtils;
import org.wrex.utils.PasswordUtil;
import org.wrex.utils.SendMail;

@ManagedBean(name="lostPasswordBean")
@RequestScoped
public class LostPasswordBean extends WrexBean{

	
	private String password;
	
	public void forgot(){
        UserDTO user = userService.getByEmail(password);
        if (user == null)
			JsfUtils.errorMessageLocale("user_noUserEmail");
        else{
        	String newPassword = RandomStringUtils.randomAlphanumeric(7);
        	user.setPassword(PasswordUtil.encrypPassword(newPassword));
        	userService.save(user);
        	List<String> mail = new ArrayList<String>();
        	mail.add(i18n("user_newPasswordText"));
        	mail.add(newPassword);
        	SendMail.send(user.getEmail(),i18n("user_newPasswordSubject"),mail);
        	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, i18n("user_passwordChanged"), i18n("user_mailSent"));
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            RequestContext.getCurrentInstance().execute("PF('forgotPasswordDialog').hide()");
        }
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
