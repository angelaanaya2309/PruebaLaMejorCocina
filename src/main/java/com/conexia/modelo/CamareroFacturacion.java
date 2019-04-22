package com.conexia.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@NamedStoredProcedureQuery(
	name = "proc_factcamarero",
	procedureName= "prueba.proc_factcamarero",
	resultClasses  = {CamareroFacturacion.class}
)

@Entity
public class CamareroFacturacion implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcamarero;

	private String apellido1;

	private String apellido2;

	private String nombre;
	
	private String mes;
	
	private String total;

	public CamareroFacturacion() {
	}

	public int getIdcamarero() {
		return idcamarero;
	}

	public void setIdcamarero(int idcamarero) {
		this.idcamarero = idcamarero;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}



	public String getApellido2() {
		return apellido2;
	}



	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



		public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	

}