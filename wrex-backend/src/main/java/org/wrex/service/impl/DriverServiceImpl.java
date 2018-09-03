package org.wrex.service.impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wrex.dao.DriverRepository;
import org.wrex.dto.DriverDTO;
import org.wrex.mappers.DriverMapper;
import org.wrex.service.DriverService;

@Service
@Transactional
public class DriverServiceImpl implements DriverService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(DriverServiceImpl.class.getName());

	@Autowired
	private DriverRepository repo;
	
	@Override
	public List<DriverDTO> getAllDrivers() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAllDrivers() - start"); //$NON-NLS-1$
		}

		List<DriverDTO> returnList = DriverMapper.INSTANCE.listToDTOList(IterableUtils.toList(repo.findAll()));
		if (logger.isDebugEnabled()) {
			logger.debug("getAllDrivers() - end"); //$NON-NLS-1$
		}
		return returnList;
	}

	@Override
	public DriverDTO getDriverByRut(String rut) {
		if (logger.isDebugEnabled()) {
			logger.debug("getDriverByRut(String) - start"); //$NON-NLS-1$
		}

		DriverDTO returnDriverDTO = DriverMapper.INSTANCE.entityToDTO(repo.findById(rut).get());
		if (logger.isDebugEnabled()) {
			logger.debug("getDriverByRut(String) - end"); //$NON-NLS-1$
		}
		return returnDriverDTO;
	}

	@Override
	public void saveDriver(DriverDTO driver) {
		if (logger.isDebugEnabled()) {
			logger.debug("saveDriver(DriverDTO) - start"); //$NON-NLS-1$
		}

		repo.save(DriverMapper.INSTANCE.dtoToEntity(driver));

		if (logger.isDebugEnabled()) {
			logger.debug("saveDriver(DriverDTO) - end"); //$NON-NLS-1$
		}
	}

	@Override
	public void deleteDriverByRut(String rut) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteDriverByRut(String) - start"); //$NON-NLS-1$
		}

		repo.deleteById(rut);

		if (logger.isDebugEnabled()) {
			logger.debug("deleteDriverByRut(String) - end"); //$NON-NLS-1$
		}
	}

	
}
