package org.wrex.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wrex.dao.UserDao;
import org.wrex.domain.User;
import org.wrex.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	/**
	 * Creates a new user. User.id must be null
	 * 
	 * @param user
	 * 
	 */
	public void create(User user) {
		userDao.insert(user);
	}

	/**
	 * Return the number of active users.
	 * @return
	 */
	public int countUsers() {
		return userDao.countAll();
	}

	/**
	 * Return all Users that match the filter fields that are not null.
	 * @param param
	 * @return
	 */
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}
	
	public User getByIdFb(String idFb) {
		return userDao.getByIdFb(idFb);
	}

	public void update(User user) {
		userDao.update(user);
	}


	/**
	 * Loads the user with all routes climbed and weight info.
	 * @param iduser
	 * @return
	 */
	public User load(Integer iduser) {
		User load = userDao.findById(iduser);
		return load;
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<User>(userDao.getAll());
	}

}
