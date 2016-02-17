package org.wrex.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;
import org.wrex.domain.User;
/**
 *
 * <p>Title: UserConverter</p>
 *
 * <p>Description: JSF converter UserConverter </p>
 *
 */
@FacesConverter(value="userConverter")
@Component ("userConverter")
public class UserConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent ui, String value) {
        User user = new User();
        
	    user.setIduser(java.lang.Integer.valueOf(value.split(";")[0]));
	    user.setName(value.split(";")[1]);
    	return user;
    }

	@Override
    public String getAsString(FacesContext context, UIComponent ui, Object object) {
		if (object==null)
            return "";
		User user = ((User) object);
		return user.getIduser().toString().concat(";").concat(user.getName());
    }
	

}