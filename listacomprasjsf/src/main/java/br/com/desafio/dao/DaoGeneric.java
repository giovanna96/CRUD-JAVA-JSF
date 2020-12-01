package br.com.desafio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.desafio.util.HibernateUtil;

public class DaoGeneric<E> {
	EntityManager entityManager = HibernateUtil.getEntityManager();
	

	public void salvar(E entidade) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.persist(entidade);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		
	}
	
	public void editar(E entidade) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.merge(entidade);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		
	}
	
	public void delete(E entidade) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.remove(entidade);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		
	}
	
	public void deleteById(E entidade) {
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			Object id = HibernateUtil.getPrimaryKey(entidade);
			entityManager.createQuery("DELETE FROM "+entidade.getClass().getCanonicalName() + " WHERE id = "+id).executeUpdate();
			
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch(Exception e){
			
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<E> findAll(Class<E> entidade) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> list = entityManager.createQuery("FROM " + entidade.getName()).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return list;
	}
	
	public E findById(Class<E> entidade, Long id) {
		return entityManager.find(entidade, id);
	}
	
}
