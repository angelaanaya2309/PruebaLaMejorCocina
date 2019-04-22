package com.conexia.daointerface;

import java.util.List;

import com.conexia.dao.JPAUtil;

public interface DAO<T,K> {
	JPAUtil jpa =JPAUtil.getInstance();
	
	void insertar(T obj);
	void modificar(T obj);
	void eliminar(T obj);
	
	List<T> obtenerLista();
	
	T obtener(K id);

}
