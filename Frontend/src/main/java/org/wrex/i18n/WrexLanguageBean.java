/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9
	* - name      : JSFBeanManagerLanguage
	* - file name : JSFPrimefacesLanguageBean.vm
	* - time      : 2015/04/27 AD at 09:42:36 CLT
*/
// inspired by http://www.mkyong.com/jsf2/jsf-2-internationalization-example/
package org.wrex.i18n;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
 
@ManagedBean(name="wrexLanguageBean")
@SessionScoped
public class WrexLanguageBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
 
	private String localeCode;
 
	private static Map<String,Object> languages;

	static{
		languages = new LinkedHashMap<String,Object>();
		languages.put("English", Locale.ENGLISH);
		languages.put("Espa\u00F1ol", new Locale ("es"));
	}
 
	public Map<String, Object> getLanguagesInMap() {
		return languages;
	}
 
	public String getLocaleCode() {
        if (localeCode==null)
            localeCode = "es";
		return localeCode;
	}
 
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
 

	public void localeCodeChanged(AjaxBehaviorEvent e){
        SelectOneMenu selectOneMenu = (SelectOneMenu) e.getSource();
        String newLocaleValue = (String) selectOneMenu.getValue();
        for (Map.Entry<String, Object> entry : languages.entrySet()) {
        	if(entry.getValue().toString().equals(newLocaleValue)){
                Locale thisLocale = (Locale)entry.getValue();
        		FacesContext.getCurrentInstance().getViewRoot().setLocale(thisLocale);
                setLocaleCode(newLocaleValue);
        	}
        }
	}
 
}