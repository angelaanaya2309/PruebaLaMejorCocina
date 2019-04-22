package com.conexia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.conexia.daointerface.ICamareroDAO;
import com.conexia.modelo.Camarero;
import com.conexia.modelo.CamareroFacturacion;
import com.conexia.modelo.Cliente;
import com.conexia.dao.JPAUtil;

public class CamareroDAO implements ICamareroDAO{

	@Override
	public void insertar(Camarero obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Camarero obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Camarero obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Camarero> obtenerLista() {
		EntityManager  gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
		Query q=gbd.createQuery("SELECT c FROM Camarero c");
		List<Camarero> listCamarero= q.getResultList();
		return listCamarero;
	}

	@Override
	public Camarero obtener(Integer id) {
		Camarero c=new Camarero();
		//c=(Camarero) JPAUtil.buscarPorID(Cliente.class, id);
		return c;
	}
	public List<CamareroFacturacion> obtenerFacturacion() {
		EntityManager gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
         JPAUtil.iniciar(gbd); 
         StoredProcedureQuery cq =gbd.createStoredProcedureQuery("proc_factcamarero", CamareroFacturacion.class);
         cq.execute();
         List result = cq.getResultList();
         List<CamareroFacturacion> lista=new ArrayList<CamareroFacturacion>();
         for(int i=0; i<result.size(); i++){
        	 CamareroFacturacion cf = (CamareroFacturacion)result.get(i);
         	lista.add(cf);
         }
         JPAUtil.finalizar(gbd); 
		return lista;
	}

	
}
