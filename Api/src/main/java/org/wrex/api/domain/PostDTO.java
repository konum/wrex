package org.wrex.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * <p>Title: Post</p>
 *
 * <p>Description: Domain Object describing a Post </p>
 *
 */
public class PostDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer idpost;

    private String title; 
    private String post; 
    private Date postdate; 
    private UserDTO user;

    /**
    * Default constructor
    */
    public PostDTO() {
    }


    public Integer getIdpost() {
        return idpost;
    }
	
    public void setIdpost (Integer idpost) {
        this.idpost =  idpost;
    }
    
    public String getTitle() {
        return title;
    }
	
    public void setTitle (String title) {
        this.title =  title;
    }
	
    public String getPost() {
        return post;
    }
	
    public void setPost (String post) {
        this.post =  post;
    }
	
    public java.util.Date getPostdate() {
        return postdate;
    }
	
    public void setPostdate (Date postdate) {
        this.postdate =  postdate;
    }

    public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}
}
