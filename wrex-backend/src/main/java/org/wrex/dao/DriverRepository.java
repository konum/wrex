package org.wrex.dao;


import org.springframework.data.repository.CrudRepository;
import org.wrex.entities.Driver;


/**
 *
 * <p>Title: UserDao</p>
 *
 * <p>Description: Interface of a Data access object dealing with UserDao
 * persistence. It offers a set of methods which allow for saving,
 * deleting and searching user objects</p>
 *
 */
public interface DriverRepository extends CrudRepository<Driver,String>{

}
