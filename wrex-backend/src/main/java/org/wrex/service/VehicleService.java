package org.wrex.service;

import java.util.List;

import org.wrex.dto.EntryDTO;
import org.wrex.dto.VehicleDTO;

public interface VehicleService {

	List<VehicleDTO> getAll();

	VehicleDTO load(String plate);

	void save(VehicleDTO ve);

	long countAll();

	void delete(String plate);

	void addEntry(EntryDTO entry);
	
	void deleteEntry(int entryId);
	
	List<EntryDTO> getEntries(String plate);
}
