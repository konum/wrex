package org.wrex.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the event database table. This class is created
 * using liquibase. see src/main/resoures/db-changelog.xml
 * 
 */

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String plate;
	private String gas;
	 @JsonProperty("vehicle_type")
	private String vehicleType;
	private String details;
	private String year;
	private String brand;
	private String model;
	private DriverDTO chofer;
	@JsonProperty("soap_date")
	private String soapDate;
	private String tyres;
	@JsonProperty("last_maintenance")
	private String lastMaintenance;
	 @JsonProperty("next_inspection")
	private String nextInspection;

	private List<EntryDTO> history;
	
	public VehicleDTO() {
	}

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
		VehicleDTO other = (VehicleDTO) obj;
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
		builder.append(", soapString=");
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

	public DriverDTO getChofer() {
		return chofer;
	}

	public void setChofer(DriverDTO chofer) {
		this.chofer = chofer;
	}

	public String getSoapDate() {
		return soapDate;
	}

	public void setSoapDate(String soapDate) {
		this.soapDate = soapDate;
	}

	public String getTyres() {
		return tyres;
	}

	public void setTyres(String tyres) {
		this.tyres = tyres;
	}

	public String getLastMaintenance() {
		return lastMaintenance;
	}

	public void setLastMaintenance(String lastMaintenance) {
		this.lastMaintenance = lastMaintenance;
	}

	public String getNextInspection() {
		return nextInspection;
	}

	public void setNextInspection(String nextInspection) {
		this.nextInspection = nextInspection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<EntryDTO> getHistory() {
		return history;
	}

	public void setHistory(List<EntryDTO> history) {
		this.history = history;
	}

}