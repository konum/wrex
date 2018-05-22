package org.wrex.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;
import org.wrex.api.domain.PostDTO;
/**
 *
 * <p>Title: PostDTOConverter</p>
 *
 * <p>Description: JSF converter PostDTOConverter </p>
 *
 */
@FacesConverter(value="postConverter")
@Component ("postConverter")
public class PostConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent ui, String value) {
        PostDTO post = new PostDTO();
	    post.setIdpost(java.lang.Integer.valueOf(value));
    	return post;
    }

	@Override
    public String getAsString(FacesContext context, UIComponent ui, Object object) {
		if (object==null)
            return "";
		return ((PostDTO) object).getIdpost().toString();
    }
	

}