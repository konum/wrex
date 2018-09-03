package org.wrex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wrex.dto.DriverDTO;
import org.wrex.service.DriverService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
	
	@Autowired
	private DriverService service;

	@RequestMapping("/driver/detail/{rut}")
	public DriverDTO getByPlate(@PathVariable("rut") String plate) {
		return service.getDriverByRut(plate);
	}
   
   
  	@RequestMapping("/driver/listAll")
  	public List<DriverDTO> getAll() {
  		return service.getAllDrivers();
  	}
   
	@RequestMapping("/driver/save")
	public void save(@RequestBody DriverDTO driver) {
		service.saveDriver(driver);
	}
}
