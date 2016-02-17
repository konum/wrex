package org.wrex.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.wrex.generic.AbstractDomainObject;

/**
 * The persistent class for the event database table. This class is created using liquibase. see  src/main/resoures/db-changelog.xml
 * 
 */
@Entity
public class Event extends AbstractDomainObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEvent;

	private Date eventDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = true, unique = true, insertable = true, updatable = false)
	private User user;

	private String text;


	public Event() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime * ((idEvent == null) ? 0 : idEvent.hashCode());
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
		Event other = (Event) obj;
		if (idEvent == null) {
			if (other.idEvent != null)
				return false;
		} else if (!idEvent.equals(other.idEvent))
			return false;
		return true;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public User getUser() {
		return user;
	}

	public String getText() {
		return text;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public void setText(String text) {
		this.text = text;
	}


	
}