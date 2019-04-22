package com.conexia.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mesa database table.
 * 
 */
@Entity
@NamedQuery(name="Mesa.findAll", query="SELECT m FROM Mesa m")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmesa;

	private int numeromaxcomensales;

	private String ubicacion;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="mesa")
	private List<Factura> facturas;

	public Mesa() {
	}

	public int getIdmesa() {
		return this.idmesa;
	}

	public void setIdmesa(int idmesa) {
		this.idmesa = idmesa;
	}

	public int getNumeromaxcomensales() {
		return this.numeromaxcomensales;
	}

	public void setNumeromaxcomensales(int numeromaxcomensales) {
		this.numeromaxcomensales = numeromaxcomensales;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setMesa(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setMesa(null);

		return factura;
	}

}