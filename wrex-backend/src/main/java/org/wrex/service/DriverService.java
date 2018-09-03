package org.wrex.service;

import java.util.List;

import org.wrex.dto.DriverDTO;

public interface DriverService {

	public List<DriverDTO> getAllDrivers();
	
	public DriverDTO getDriverByRut(String rut);
	
	public void saveDriver(DriverDTO driver);
	
	public void deleteDriverByRut(String rut);
}
