package org.wrex.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.wrex.generic.AbstractDomainObject;

@Entity (name="User")
@Table (name="User")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends AbstractDomainObject {
	
	public static Integer ACTIVE = 1;
	public static Integer INACTIVE = 0;
	
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_ROLE = 0;
	
    @Id @Column(name="idUser" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iduser;

    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 

    @Column(name="email"  , length=65 , nullable=true , unique=false)
    private String email; 

    @Column(name="password"  , length=45 , nullable=false , unique=false)
    private String password; 

    @Column(name="role"   , nullable=false , unique=false)
    private Integer role; 

    @Column(name="idPicture"  , length=10 , nullable=true , unique=false)
    private String idpicture; 

    @Column(name="status"   , nullable=true , unique=false)
    private Integer status; 
    
    
    private String idUserFB;


    @OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
    @OrderBy("date ASC")
    private List<Post> posts;
    
    @Override
    public String toString(){
    	return this.name;
    }
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iduser == null) ? 0 : iduser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (iduser == null) {
			if (other.iduser != null)
				return false;
		} else if (!iduser.equals(other.iduser))
			return false;
		return true;
	}

	public User() {
    }

    public Integer getIduser() {
        return iduser;
    }
	
    public void setIduser (Integer iduser) {
        this.iduser =  iduser;
    }
    
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
    public String getPassword() {
        return password;
    }
	
    public void setPassword (String password) {
        this.password =  password;
    }
	
    public Integer getRole() {
        return role;
    }
	
    public void setRole (Integer role) {
        this.role =  role;
    }

    public String getIdpicture() {
        return idpicture;
    }
	
    public void setIdpicture (String idpicture) {
        this.idpicture =  idpicture;
    }

    public Integer getStatus() {
        return status;
    }
	
    public void setStatus (Integer status) {
        this.status =  status;
    }

	
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (role==null) role=__DEFAULT_ROLE;
    }
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (role==null) role=__DEFAULT_ROLE;
    }

	public String getIdUserFB() {
		return idUserFB;
	}

	public void setIdUserFB(String idUserFB) {
		this.idUserFB = idUserFB;
	}
}
