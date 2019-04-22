package com.conexia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.conexia.daointerface.IClienteDAO;
import com.conexia.modelo.CamareroFacturacion;
import com.conexia.modelo.Cliente;
import com.conexia.modelo.ClienteGastos;
import com.conexia.dao.JPAUtil;

public class ClienteDAO implements IClienteDAO {
	
	private static ClienteDAO instancia;
	public static ClienteDAO getInstance() {
		return instancia;
	}

	public ClienteDAO() {
		instancia = this;
	}

	@Override
	public void insertar(Cliente obj) {
		jpa.insertar(obj);		
	}

	@Override
	public void modificar(Cliente obj) {
		jpa.modificar(obj);
		
	}

	@Override
	public void eliminar(Cliente obj) {
		jpa.eliminar(obj);
		
	}

	@Override
	public List<Cliente> obtenerLista() {
		EntityManager  gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
		Query q=gbd.createQuery("SELECT c FROM Cliente c");
		List<Cliente> listclientes= q.getResultList();
		return listclientes;
	}

	@Override
	public Cliente obtener(Integer id) {
		Cliente c=new Cliente();
		c=(Cliente) jpa.buscarPorID(Cliente.class, id);
		return c;
	}
	
	public List<ClienteGastos> obtenerGastos() {
		EntityManager gbd = JPAUtil.getEntityManagerFactory().createEntityManager(); 
         JPAUtil.iniciar(gbd); 
         StoredProcedureQuery cq =gbd.createStoredProcedureQuery("proc_gastoscliente", ClienteGastos.class);
         cq.execute();
         List result = cq.getResultList();
         List<ClienteGastos> lista=new ArrayList<ClienteGastos>();
         for(int i=0; i<result.size(); i++){
        	 ClienteGastos cf = (ClienteGastos)result.get(i);
         	lista.add(cf);
         }
         JPAUtil.finalizar(gbd); 
		return lista;
	}

	
}
