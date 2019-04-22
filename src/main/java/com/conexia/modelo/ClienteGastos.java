package com.conexia.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
public class ClienteGastos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcliente;

	private String apellido1;

	private String apellido2;

	private String nombre;

	private int gastos;

	
	public ClienteGastos() {
	}

	
	public ClienteGastos(int idcliente, String nombre, String apellido1, String apellido2,int gastos) {
		super();
		this.idcliente = idcliente;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.gastos = gastos;
	}
	
	public ClienteGastos(int idcliente, String nombre,String apellido1, String apellido2, String observaciones,int gastos) {
		super();
		this.idcliente = idcliente;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.gastos = gastos;
	}


	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getGastos() {
		return this.gastos;
	}

	public void setGastos(int gastos) {
		this.gastos = gastos;
	}

	

}