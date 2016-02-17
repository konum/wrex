package org.wrex.dao;

import java.util.Collection;

/**
 * Generic DAO for all daos
 * @author ggefaell
 *
 * @param <T> Class of domain entity
 * @param <ID> Class of the Id of the entity
 */
public interface GenericDao<T, ID> {

	T insert(T entity);
	
	void insert(Collection<T> entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	T findById(ID key);
	
	Collection<T> getAll();
	
}
