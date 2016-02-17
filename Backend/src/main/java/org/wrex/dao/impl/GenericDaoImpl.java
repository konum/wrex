package org.wrex.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.wrex.dao.GenericDao;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * Generic CRUD operations for DAOs
 * @author ggefaell
 *
 * @param <T> 
 * @param <ID>
 */
public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {

	@PersistenceContext(unitName = "wrexPersistence")
	protected EntityManager entityManager;
	protected Class<T> entityClass;
	
	
	public EntityManager getEm() {
		return entityManager;
	}

	public void setEm(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T insert(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public void insert(Collection<T> entity) {
		for (T t : entity) {
			insert(t);
		}
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Override
	public T findById(ID key) {
		return entityManager.find(entityClass, key);
	}

	protected int countAll(EntityPathBase<T> entity) {
		JPAQuery<T> query = new JPAQuery<T>(getEm());
		return new Long(query.from(entity).fetchCount()).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<T> getAll() {
		javax.persistence.Query qry = entityManager.createQuery("SELECT a FROM "+ entityClass.getSimpleName() +" a");
		return qry.getResultList();
	}

	/**
	 * Gets a new JPAQuery for querydsl  
	 * @return
	 */
	protected JPAQuery<T> newJPA(){
		return new JPAQuery<T>(entityManager);
	}
}
