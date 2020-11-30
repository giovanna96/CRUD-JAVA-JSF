package br.com.desafio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.desafio.util.HibernateUtil;

public class DaoGeneric<E> {

	public void salvar(E entidade) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		entityManager.close();	
	}
	
}
