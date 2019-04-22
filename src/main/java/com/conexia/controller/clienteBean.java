package com.conexia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.conexia.dao.ClienteDAO;
import com.conexia.modelo.Cliente;
import com.conexia.modelo.ClienteGastos;
import com.conexia.modelo.Factura;

@ManagedBean
@RequestScoped
public class clienteBean {
	
 
    public List<Cliente> getListaClientes() {
    	ClienteDAO dao = new ClienteDAO();
    	List<Cliente> listclientes=new ArrayList<>();
		System.out.println("antes:::::::::::::::::");
		listclientes = dao.obtenerLista();
		System.out.println("despues lista de clientes:::::::::::::::::"+listclientes.size());
		return listclientes;
    }
	
    public List<ClienteGastos> getGastosCliente() {
    	ClienteDAO dao = new ClienteDAO();
    	List<ClienteGastos> listc=new ArrayList<>();
		System.out.println("antes:::::::::::::::::");
		listc = dao.obtenerGastos();
		return listc;
    }
	

}
