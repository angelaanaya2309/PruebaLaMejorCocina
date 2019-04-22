package com.conexia.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallefactura database table.
 * 
 */
@Entity
@NamedQuery(name="Detallefactura.findAll", query="SELECT d FROM Detallefactura d")
public class Detallefactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddetallefactura;

	private int importe;

	private String plato;

	//bi-directional many-to-one association to Cocinero
	@ManyToOne
	@JoinColumn(name="IDCOCINERO")
	private Cocinero cocinero;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="IDFACTURA")
	private Factura factura;

	public Detallefactura() {
	}

	public int getIddetallefactura() {
		return this.iddetallefactura;
	}

	public void setIddetallefactura(int iddetallefactura) {
		this.iddetallefactura = iddetallefactura;
	}

	public int getImporte() {
		return this.importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getPlato() {
		return this.plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	public Cocinero getCocinero() {
		return this.cocinero;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}