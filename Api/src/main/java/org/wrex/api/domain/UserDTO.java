package org.wrex.api.domain;

import java.io.Serializable;

public class UserDTO implements Serializable {

	public static final Integer ACTIVE = 1;
	public static final Integer INACTIVE = 0;

	private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_ROLE = 0;

	private Integer iduser;
	private String name;
	private String email;
	private String password;
	private Integer role;
	private String idpicture;
	private Integer status;
	private String idUserFB;

	public String toString() {
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
		UserDTO other = (UserDTO) obj;
		if (iduser == null) {
			if (other.iduser != null)
				return false;
		} else if (!iduser.equals(other.iduser))
			return false;
		return true;
	}

	public UserDTO() {
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getIdpicture() {
		return idpicture;
	}

	public void setIdpicture(String idpicture) {
		this.idpicture = idpicture;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIdUserFB() {
		return idUserFB;
	}

	public void setIdUserFB(String idUserFB) {
		this.idUserFB = idUserFB;
	}

}
