package org.wrex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wrex.dto.EntryDTO;
import org.wrex.dto.VehicleDTO;
import org.wrex.service.VehicleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {
	
	@Autowired
	private VehicleService service;

	@RequestMapping(value="/vehicle/{plate}",method=RequestMethod.GET)
	public VehicleDTO getByPlate(@PathVariable("plate") String plate) {
		return service.load(plate);
	}
	
	@RequestMapping(value="/vehicle/{plate}", method=RequestMethod.DELETE)
	public void deleteByPlate(@PathVariable("plate") String plate) {
		service.delete(plate);
	}
   
   
  	@RequestMapping("/vehicle/listAll")
  	public List<VehicleDTO> getAll() {
  		return service.getAll();
  	}
   
  	@RequestMapping(value="/vehicle",method=RequestMethod.POST)
	public void save(@RequestBody VehicleDTO vehicle) {
		service.save(vehicle);
	}
  	
  	@RequestMapping(value="/vehicle/entry",method=RequestMethod.POST)
	public void addEntry(@RequestBody EntryDTO entry) {
		service.addEntry(entry);
	}
  	
  	@RequestMapping(value="/vehicle/entry/{id}",method=RequestMethod.DELETE)
	public void deleteEntry(@PathVariable("id") int entryId) {
		service.deleteEntry(entryId);
	}
  	
  	@RequestMapping(value="/vehicle/entry/{plate}",method=RequestMethod.GET)
	public List<EntryDTO> getEntries(@PathVariable("plate") String plate) {
  		return service.getEntries(plate);
  	}
}
