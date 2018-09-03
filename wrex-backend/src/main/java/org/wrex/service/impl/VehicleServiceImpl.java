package org.wrex.service.impl;


import java.util.List;
import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.EntryRepository;
import org.wrex.dao.VehicleRepository;
import org.wrex.dto.EntryDTO;
import org.wrex.dto.VehicleDTO;
import org.wrex.entities.Vehicle;
import org.wrex.mappers.EntryMapper;
import org.wrex.mappers.VehicleMapper;
import org.wrex.service.VehicleService;

@Service("vehicleService") 
@Transactional
public class VehicleServiceImpl implements VehicleService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

	@Autowired
	VehicleRepository vehicleDao;
	
	@Autowired
	EntryRepository entryDao;
	
	
	/**
	 * Creates a new user. UserDTO.id must be null
	 * 
	 * @param ve
	 * 
	 */
	@Override
	public void save(VehicleDTO ve) {
		if (logger.isDebugEnabled()) {
			logger.debug("save(VehicleDTO ve={}) - start", ve);
		}

		vehicleDao.save(VehicleMapper.INSTANCE.dtoToEntity(ve));

		if (logger.isDebugEnabled()) {
			logger.debug("save() - end");
		}
	}

	/**
	 * Return the number of active users.
	 * @return
	 */
	@Override
	public long countAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("countAll() - start");
		}

		long returnlong = vehicleDao.count();
		if (logger.isDebugEnabled()) {
			logger.debug("countAll() - end - return value={}", returnlong);
		}
		return returnlong;
	}



	/**
	 * Loads the user with all routes climbed and weight info.
	 * @param iduser
	 * @return
	 */
	@Override
	public VehicleDTO load(String plate) {
		if (logger.isDebugEnabled()) {
			logger.debug("load(String plate={}) - start", plate);
		}

		Vehicle ve = vehicleDao.findById(plate).get();
		if (ve != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("load() - end - return value={}",ve);
			}
			return VehicleMapper.INSTANCE.entityToDTO(ve);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("load() - end - return value={null}");
		}
		return null;
	}

	@Override
	public List<VehicleDTO> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - start");
		}

		List<VehicleDTO> returnList = VehicleMapper.INSTANCE.listToDTOList(IterableUtils.toList(vehicleDao.findAll()));
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - end - return value={}", returnList);
		}
		return returnList; 
	}

	@Override
	public void delete(String plate) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String plate={}) - start", plate);
		}

		vehicleDao.deleteById(plate);

		if (logger.isDebugEnabled()) {
			logger.debug("delete() - end");
		}
	}

	@Override
	public void addEntry(EntryDTO entry) {
		if (logger.isDebugEnabled()) {
			logger.debug("addEntry(EntryDTO entry={}) - start", entry);
		}

		entryDao.save(EntryMapper.INSTANCE.dtoToEntity(entry));

		if (logger.isDebugEnabled()) {
			logger.debug("addEntry() - end");
		}
	}

	@Override
	public void deleteEntry(int entryId) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteEntry(EntryDTO entry={}) - start", entryId);
		}

		entryDao.deleteById(entryId);

		if (logger.isDebugEnabled()) {
			logger.debug("deleteEntry() - end");
		}
	}

	@Override
	public List<EntryDTO> getEntries(String plate) {
		if (logger.isDebugEnabled()) {
			logger.debug("getEntries(plate={}) - start", plate);
		}

		return EntryMapper.INSTANCE.listToDTOList(entryDao.findByPlateOrderByDateDesc(plate));

	}

}
