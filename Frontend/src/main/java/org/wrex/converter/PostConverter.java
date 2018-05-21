package org.wrex.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.stereotype.Component;
import org.wrex.entities.Post;
/**
 *
 * <p>Title: PostConverter</p>
 *
 * <p>Description: JSF converter PostConverter </p>
 *
 */
@FacesConverter(value="postConverter")
@Component ("postConverter")
public class PostConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent ui, String value) {
        Post post = new Post();
	    post.setIdpost(java.lang.Integer.valueOf(value));
    	return post;
    }

	@Override
    public String getAsString(FacesContext context, UIComponent ui, Object object) {
		if (object==null)
            return "";
		return ((Post) object).getIdpost().toString();
    }
	

}