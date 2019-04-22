package com.conexia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.conexia.dao.CamareroDAO;
import com.conexia.modelo.Camarero;
import com.conexia.modelo.CamareroFacturacion;

@ManagedBean
@RequestScoped
public class camareroBean {
	


	
    public List<Camarero> getListaCamareros() {
    	CamareroDAO dao = new CamareroDAO();
    	List<Camarero> listc=new ArrayList<>();
		System.out.println("antes:::::::::::::::::");
		listc = dao.obtenerLista();
		System.out.println("camarero:::::::::::::::::"+listc.size());
		return listc;
    }
    
    public List<CamareroFacturacion> getFacturacionCamarero() {
    	CamareroDAO dao = new CamareroDAO();
    	List<CamareroFacturacion> listc=new ArrayList<>();
		System.out.println("antes:::::::::::::::::");
		listc = dao.obtenerFacturacion();
		return listc;
    }
	
	
	

}
