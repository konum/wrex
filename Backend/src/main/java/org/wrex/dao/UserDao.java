package org.wrex.dao;


import org.wrex.domain.User;


/**
 *
 * <p>Title: UserDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with UserDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching user objects</p>
 *
 */
public interface UserDao extends GenericDao<User,Integer>{

	int countAll();

	User getByEmail(String email);

	User getByIdFb(String idFb);
}
