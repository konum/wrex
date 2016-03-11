package org.wrex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wrex.generic.AbstractDomainObject;

/**
 *
 * <p>Title: Post</p>
 *
 * <p>Description: Domain Object describing a Post entity</p>
 *
 */
@Entity (name="Post")
@Table (name="Post")
public class Post extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;

    @Id @Column(name="idPost" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idpost;

    @Column(name="title"  , length=100 , nullable=true , unique=false)
    private String title; 

    @Column(name="post"  , length=2000 , nullable=true , unique=false)
    private String post; 

    @Column(name="postDate"   , nullable=false , unique=false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date postdate; 
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User user;

	/**
    * Default constructor
    */
    public Post() {
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
	
    public void setPostdate (java.util.Date postdate) {
        this.postdate =  postdate;
    }

    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
