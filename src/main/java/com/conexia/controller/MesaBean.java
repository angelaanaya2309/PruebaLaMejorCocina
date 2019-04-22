package com.conexia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.conexia.dao.MesaDAO;
import com.conexia.modelo.Mesa;

@ManagedBean
@RequestScoped
public class MesaBean {
	

    public List<Mesa> getListaMesas() {
    	MesaDAO dao = new MesaDAO();
    	List<Mesa> listMesas= dao.obtenerLista();
		return listMesas;
    }
	
	

}
