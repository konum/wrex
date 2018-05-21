package org.wrex.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.api.domain.UserDTO;
import org.wrex.dao.UserRepository;
import org.wrex.entities.User;
import org.wrex.generic.ListMapper;
import org.wrex.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userDao;
	
	static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private Mapper mapper = new DozerBeanMapper();
	
	/**
	 * Creates a new user. UserDTO.id must be null
	 * 
	 * @param user
	 * 
	 */
	public void save(UserDTO user) {
		userDao.save(mapper.map(user, User.class));
	}

	/**
	 * Return the number of active users.
	 * @return
	 */
	public long countUsers() {
		return userDao.count();
	}

	/**
	 * Return all UserDTOs that match the filter fields that are not null.
	 * @param param
	 * @return
	 */
	public UserDTO getByEmail(String email) {
		LOG.info("getByEmail "  + email);
		User user = userDao.findOneByEmail(email);
		if (user != null)
			return mapper.map(user, UserDTO.class);
		return null;
	}


	/**
	 * Loads the user with all routes climbed and weight info.
	 * @param iduser
	 * @return
	 */
	public UserDTO load(Integer iduser) {
		User user = userDao.findById(iduser).get();
		if (user != null)
			return mapper.map(user, UserDTO.class);
		return null;
	}

	@Override
	public List<UserDTO> getAll() {
		return ListMapper.mapList(mapper, userDao.findAll(), UserDTO.class); 
	}

	@Override
	public UserDTO getByIdFb(String id) {
		return mapper.map(userDao.findOneByIdUserFB(id), UserDTO.class);
	}

}
