package org.wrex.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The persistent class for the event database table. This class is created
 * using liquibase. see src/main/resoures/db-changelog.xml
 * 
 */

@Entity
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String plate;
	@Column
	private String gas;
	@Column
	private String vehicleType;
	@Column
	private String details;
	@Column
	private String year;
	@Column
	private String brand;
	@Column
	private String model;

	@ManyToOne
	@JoinColumn(name = "chofer")
	private Driver chofer;

	@Column
	private Date soapDate;
	@Column
	private String tyres;
	@Column
	private Date lastMaintenance;
	@Column
	private Date nextInspection;

//	@OneToMany
//	@JoinColumn(name="plate")
//	private List<Entry> history;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [plate=");
		builder.append(plate);
		builder.append(", gas=");
		builder.append(gas);
		builder.append(", vehicleType=");
		builder.append(vehicleType);
		builder.append(", details=");
		builder.append(details);
		builder.append(", year=");
		builder.append(year);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", model=");
		builder.append(model);
		builder.append(", chofer=");
		builder.append(chofer);
		builder.append(", soapDate=");
		builder.append(soapDate);
		builder.append(", tyres=");
		builder.append(tyres);
		builder.append(", lastMaintenance=");
		builder.append(lastMaintenance);
		builder.append(", nextInspection=");
		builder.append(nextInspection);
		builder.append("]");
		return builder.toString();
	}

	public Vehicle() {
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getSoapDate() {
		return soapDate;
	}

	public void setSoapDate(Date soapDate) {
		this.soapDate = soapDate;
	}

	public String getTyres() {
		return tyres;
	}

	public void setTyres(String tyres) {
		this.tyres = tyres;
	}

	public Date getLastMaintenance() {
		return lastMaintenance;
	}

	public void setLastMaintenance(Date lastMaintenance) {
		this.lastMaintenance = lastMaintenance;
	}

	public Date getNextInspection() {
		return nextInspection;
	}

	public void setNextInspection(Date nextInspection) {
		this.nextInspection = nextInspection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Driver getChofer() {
		return chofer;
	}

	public void setChofer(Driver chofer) {
		this.chofer = chofer;
	}

//	public List<Entry> getHistory() {
//		return history;
//	}
//
//	public void setHistory(List<Entry> history) {
//		this.history = history;
//	}

}