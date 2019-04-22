package com.conexia.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.conexia.dao.ClienteDAO;
import com.conexia.dao.FacturaDAO;
import com.conexia.modelo.Camarero;
import com.conexia.modelo.Cliente;
import com.conexia.modelo.Cocinero;
import com.conexia.modelo.Detallefactura;
import com.conexia.modelo.Factura;
import com.conexia.modelo.Mesa;

@ManagedBean
@RequestScoped
public class FacturaBean {
	
	private Factura factura=new Factura();
	
	private Cliente cliente=new Cliente();
	
	
	private String[] platos; 
	
	private List<Detallefactura> det=new ArrayList <Detallefactura>();
	
	
	public Factura getFactura() {
		factura.setCliente(new Cliente());
		factura.setCamarero(new Camarero());
		factura.setMesa(new Mesa());
		factura.setFechafactura(Calendar.getInstance().getTime());
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String[] getPlatos() {
		return platos;
	}

	public void setPlatos(String[] platos) {
		this.platos = platos;
	}
	

	public List<Detallefactura> getDet() {
		return det;
	}

	public void setDet(List<Detallefactura> det) {
		this.det = det;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteporId() {
	    	ClienteDAO dao = new ClienteDAO();
	    	Cliente cliente=dao.obtener(this.factura.getCliente().getIdcliente());
			return cliente;
	}
	 
	public void setClienteFactura() { 	
    	this.factura.setCliente(this.getClienteporId());
}

    public List<Factura> getListaFacturas() {
    	FacturaDAO dao = new FacturaDAO();
    	List<Factura> listFacturas=new ArrayList<>();
		System.out.println("antes:::::::::::::::::");
		listFacturas = dao.obtenerLista();
		System.out.println("despues lista de Facturas:::::::::::::::::"+listFacturas.size());
		return listFacturas;
    }
	
    public String insertar() {
    	ClienteDAO daoc = new ClienteDAO();
    	daoc.insertar(this.cliente);
    	System.out.println("inserto correctamente cliente");
    	factura.setCliente(cliente);
    	factura.setDetallefacturas(this.det);
    	FacturaDAO dao = new FacturaDAO();
    	dao.insertar(this.factura);
    	System.out.println("inserto correctamente");
    	return "OK";
    }
	
    
    public void setDetalleFacturaList() {
    	Random r = new Random();
    	for(int i=0;i<platos.length-1;i++) {
    		String[] opc=platos[i].split("-");
    		int id = r.nextInt(60000)+1;  
    		Detallefactura detalle=new Detallefactura();
    		detalle.setFactura(factura);
    		detalle.setIddetallefactura(id);
    		detalle.setCocinero(new Cocinero(552525));
    		detalle.setPlato(opc[0]);
    		detalle.setImporte(Integer.parseInt(opc[1].replace(" $", "").replace(".", "")));
    		this.det.add(detalle);
    	}
    }


}
