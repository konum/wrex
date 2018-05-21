package org.wrex.service;

import java.util.List;

import org.wrex.api.domain.PostDTO;


/**
 *
 * <p>Title: Post Service</p>
 *
 * <p>Description: Service layer Interface 
 * It offers coarse grain methods over the fine grain DAO layer:
 * It performs input and business validation.
 * </p>
 *
 */
public interface PostService{

	/**
	 * Creates a new Warning
	 * @param warn
	 */
	void save(PostDTO warn);
	
	List<PostDTO> getAllPost();

}
