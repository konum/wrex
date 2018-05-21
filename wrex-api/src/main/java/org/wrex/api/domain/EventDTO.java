package org.wrex.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * The domain class for the event. 
 * 
 */
public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idEvent;
	private Date eventDate;
	private UserDTO user;
	private String text;

	public EventDTO() {
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
		EventDTO other = (EventDTO) obj;
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

	public UserDTO getUser() {
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

	public void setUser(UserDTO user) {
		this.user = user;
	}


	public void setText(String text) {
		this.text = text;
	}

}