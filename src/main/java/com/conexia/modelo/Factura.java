package com.conexia.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfactura;

	@Temporal(TemporalType.DATE)
	private Date fechafactura;

	//bi-directional many-to-one association to Detallefactura
	@OneToMany(mappedBy="factura")
	private List<Detallefactura> detallefacturas;

	//bi-directional many-to-one association to Camarero
	@ManyToOne
	@JoinColumn(name="IDCAMARERO")
	private Camarero camarero;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Mesa
	@ManyToOne
	@JoinColumn(name="IDMESA")
	private Mesa mesa;

	public Factura() {
	}

	public int getIdfactura() {
		return this.idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public Date getFechafactura() {
		return this.fechafactura;
	}

	public void setFechafactura(Date fechafactura) {
		this.fechafactura = fechafactura;
	}

	public List<Detallefactura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detallefactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detallefactura addDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setFactura(this);

		return detallefactura;
	}

	public Detallefactura removeDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setFactura(null);

		return detallefactura;
	}

	public Camarero getCamarero() {
		return this.camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}