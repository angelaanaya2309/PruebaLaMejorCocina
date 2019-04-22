
package com.conexia.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.conexia.daointerface.IMesaDAO;
import com.conexia.modelo.Mesa;
import com.conexia.dao.JPAUtil;
import com.conexia.modelo.Mesa;

public class MesaDAO implements IMesaDAO{

	@Override
	public void insertar(Mesa obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Mesa obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Mesa obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Mesa> obtenerLista() {
		EntityManager  gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
		Query q=gbd.createQuery("SELECT c FROM Mesa c");
		List<Mesa> listMesa= q.getResultList();
		return listMesa;
	}

	@Override
	public Mesa obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
