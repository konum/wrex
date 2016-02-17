package org.wrex.utils;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfUtils {

	public static Object getManagedBean(String beanName) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Object bean = ctx.getApplication().getELResolver().getValue(ctx.getELContext(), null, beanName);
		return bean;
	}

	public static void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(message);
		}
	}

	public static void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
	
    public static void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    public static void addInfoMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    public static void addSuccessMessage(String msg) {
        addSuccessMessage (msg, msg);
    }
    
    public static void succesMessageLocale(String code){
    	JsfUtils.addSuccessMessage(ResourceBundle.getBundle("i18n.wrex",FacesContext.getCurrentInstance().getViewRoot().getLocale()).getString(code));
    }
    
    public static void errorMessageLocale(String code){
    	JsfUtils.addErrorMessage(ResourceBundle.getBundle("i18n.wrex",FacesContext.getCurrentInstance().getViewRoot().getLocale()).getString(code));
    }

}