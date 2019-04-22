package com.conexia.dao;

import java.util.List;

import com.conexia.daointerface.IFacturaDAO;
import com.conexia.modelo.Factura;

public class FacturaDAO implements IFacturaDAO{

	@Override
	public void insertar(Factura obj) {
		jpa.insertar(obj);	
		
	}

	@Override
	public void modificar(Factura obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Factura obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Factura> obtenerLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
