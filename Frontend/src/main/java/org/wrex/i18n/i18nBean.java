package org.wrex.i18n;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="i18nBean")
@SessionScoped
/**
 * Class for getting localized text from database. For example you have a EventType table with field desc with values "PARTY", "BIRTHDAY"
 * With this bean you can do #{i18n.get(event.typo.desc)} in your view to get PARTY and BIRTHDAY in the user locale.
 * @author ggefaell
 *
 */
public class i18nBean implements Serializable{


	private Locale locale; 
	
	@PostConstruct
	void initialiseSession() {
	    FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	    locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}
	
	public String getLocale(){
		return  FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
	}
	
	public String get(String code){
	    locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		if (ResourceBundle.getBundle("i18n.wrex",locale).containsKey(code))
			return ResourceBundle.getBundle("i18n.wrex",locale).getString(code);
		return code;
	}
	
	public static String getCode(String code){
		Locale local = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		if (ResourceBundle.getBundle("i18n.wiklimb",local).containsKey(code))
			return ResourceBundle.getBundle("i18n.wrex",local).getString(code);
		return code;
	}
}
