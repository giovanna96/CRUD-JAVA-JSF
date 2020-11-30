package br.com.desafio.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static EntityManagerFactory factory = null;
	
	static {
		if(factory ==  null) {
			factory = Persistence.createEntityManagerFactory("listacomprasjsf");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
