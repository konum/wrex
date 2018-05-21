package org.wrex.service.impl;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.api.domain.UserDTO;
import org.wrex.dao.UserRepository;
import org.wrex.entities.User;
import org.wrex.mappers.UserMapper;
import org.wrex.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userDao;
	
	static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/**
	 * Creates a new user. UserDTO.id must be null
	 * 
	 * @param user
	 * 
	 */
	public void save(UserDTO user) {
		userDao.save(UserMapper.INSTANCE.userDtoToUser(user));
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
			return UserMapper.INSTANCE.userToUserDTO(user);
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
			return UserMapper.INSTANCE.userToUserDTO(user);
		return null;
	}

	@Override
	public List<UserDTO> getAll() {
		return UserMapper.INSTANCE.listToDTOList(IterableUtils.toList(userDao.findAll())); 
	}

	@Override
	public UserDTO getByIdFb(String id) {
		return UserMapper.INSTANCE.userToUserDTO(userDao.findOneByIdUserFB(id));
	}

}
