package org.wrex.service;

import java.util.List;

import org.wrex.domain.User;

/**
 *
 * <p>
 * Title: UserService
 * </p>
 *
 * <p>
 * Description: Service layer Interface It offers coarse grain methods over the
 * fine grain DAO layer: It performs input and business validation.
 * </p>
 *
 */
public interface UserService {

	/**
	 * Creates a new user. User.id must be null
	 * 
	 * @param user
	 * 
	 */
	void create(User user);

	/**
	 * Return the number of active users.
	 * @return
	 */
	int countUsers();
	
	List<User> getAll();

	User getByEmail(String email); 
	
	User getByIdFb(String idFb);

	void update(User user);

	/**
	 * Return an user with all its fields initialized.
	 * @param iduser
	 * @return
	 */
	User load(Integer iduser);
	
}
