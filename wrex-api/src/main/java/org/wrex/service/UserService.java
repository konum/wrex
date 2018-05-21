package org.wrex.service;

import java.util.List;

import org.wrex.api.domain.UserDTO;

/**
 *
 * <p>
 * Title: UserDTOService
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
	 * Creates a new user. UserDTO.id must be null
	 * 
	 * @param user
	 * 
	 */
	void save(UserDTO user);

	/**
	 * Return the number of active users.
	 * @return
	 */
	long countUsers();
	
	List<UserDTO> getAll();

	UserDTO getByEmail(String email); 
	
	/**
	 * Return an user with all its fields initialized.
	 * @param iduser
	 * @return
	 */
	UserDTO load(Integer iduser);

	/**
	 * Returns user by his facebook id
	 * @param id
	 * @return Null if not found
	 */
	UserDTO getByIdFb(String id);
	
}
