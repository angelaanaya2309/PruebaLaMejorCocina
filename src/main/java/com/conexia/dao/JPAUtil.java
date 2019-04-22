package com.conexia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;

public class JPAUtil {

	private static JPAUtil instancia;
	private static EntityManagerFactory fabrica;
	private static final String NOMBRE_PERSISTENCIA = "pruebadb";

	

	public static JPAUtil getInstance() {
		return instancia;
	}

	public JPAUtil() {
		instancia = this;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		try {
			if (fabrica == null)
				fabrica = Persistence.createEntityManagerFactory(NOMBRE_PERSISTENCIA);
			
			System.out.println("No hay eerror");
		} catch (Throwable ex) {
			System.out.println("Error creando la persistencia");
			throw new ExceptionInInitializerError(ex);
		}
		return fabrica;
	}
	
	public static void iniciar(EntityManager gbd) { 
       gbd.getTransaction().begin(); 
    } 
 
    public static void finalizar(EntityManager gbd) { 
        if (gbd.isOpen()) { 
            EntityTransaction tx =gbd.getTransaction(); 
            if (tx.isActive()) { 
               gbd.getTransaction().commit(); 
            } 
           gbd.close(); 
        } 
    } 
 
    public static void falloTransacion(EntityManager gbd) { 
        if (gbd.isOpen()) { 
            EntityTransaction tx =gbd.getTransaction(); 
 
            if (tx != null && tx.isActive()) { 
                tx.rollback(); 
            } 
        } 
    } 
 
    public  void insertar(Object o) { 
        EntityManager gbd = null; 
 
        try { 
            gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
            JPAUtil.iniciar(gbd); 
           gbd.persist(o); 
            JPAUtil.finalizar(gbd); 
 
        } catch (PersistenceException e) { 
            JPAUtil.falloTransacion(gbd); 
            throw e; 
        } 
    } 
 
    public  Object modificar(Object o) { 
        EntityManager gbd = null; 
 
        try { 
            gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
            JPAUtil.iniciar(gbd); 
            o =gbd.merge(o); 
            JPAUtil.finalizar(gbd); 
            return o; 
 
        } catch (PersistenceException e) { 
            JPAUtil.falloTransacion(gbd); 
            throw e; 
        } 
    } 
 
    public  void eliminar(Object o) { 
        EntityManager gbd = null; 
 
        try { 
            gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
            JPAUtil.iniciar(gbd); 
            gbd.remove(o);
            JPAUtil.finalizar(gbd); 
 
        } catch (PersistenceException e) { 
            JPAUtil.falloTransacion(gbd); 
            throw e; 
        } 
    } 
 
    public  Object buscarPorID(Class<?> type, Integer id) { 
        EntityManager gbd = null; 
 
        try { 
            gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
            JPAUtil.iniciar(gbd); 
            Object o =gbd.find(type, id); 
            JPAUtil.finalizar(gbd); 
 
            return o; 
 
        } catch (PersistenceException e) { 
            JPAUtil.falloTransacion(gbd); 
            throw e; 
        } 
    }
    
    public  List<Object> Listar(Class<?> type) { 
        EntityManager gbd = null; 
 
        try { 
            gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
            JPAUtil.iniciar(gbd); 
            CriteriaQuery cq =gbd.getCriteriaBuilder().createQuery();
            cq.select(cq.from(type));
            List<Object> list= gbd.createQuery(cq).getResultList();
            JPAUtil.finalizar(gbd); 
 
            return list; 
 
        } catch (PersistenceException e) { 
            JPAUtil.falloTransacion(gbd); 
            throw e; 
        } 
    }
    
    public  void procedure(Class<?> type,String procedureName,List<?> list) { 
        EntityManager gbd = null; 
 
        try { 
            gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
            JPAUtil.iniciar(gbd); 
            StoredProcedureQuery cq =gbd.createStoredProcedureQuery(procedureName, type);
            list= cq.getResultList();
            JPAUtil.finalizar(gbd); 
 
        } catch (PersistenceException e) { 
            JPAUtil.falloTransacion(gbd); 
            throw e; 
        } 
    }
    
    
}
