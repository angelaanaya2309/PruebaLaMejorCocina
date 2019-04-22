package com.conexia.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocinero database table.
 * 
 */
@Entity
@NamedQuery(name="Cocinero.findAll", query="SELECT c FROM Cocinero c")
public class Cocinero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcocinero;

	private String apellido1;

	private String apellido2;

	private String nombre;

	//bi-directional many-to-one association to Detallefactura
	@OneToMany(mappedBy="cocinero")
	private List<Detallefactura> detallefacturas;

	public Cocinero() {
	}

	public Cocinero(int idcocinero) {
		this.idcocinero=idcocinero;
	}
	
	public int getIdcocinero() {
		return this.idcocinero;
	}

	public void setIdcocinero(int idcocinero) {
		this.idcocinero = idcocinero;
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

	public List<Detallefactura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detallefactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detallefactura addDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setCocinero(this);

		return detallefactura;
	}

	public Detallefactura removeDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setCocinero(null);

		return detallefactura;
	}

}