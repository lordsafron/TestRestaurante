package com.hm.restaurante.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_DETALLE_FACTURA")
public class DetalleFactura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTestDetalleFactura")
	@SequenceGenerator(name="seqTestDetalleFactura",sequenceName="SEQ_TEST_DETALLE_FACTURA",initialValue=1,allocationSize=1)
	@Column(name = "ID_DETALLE_FACTURA")
	private Long idDetalleFactura;
	@Column(name = "PLATO")
	private String plato;
	@Column(name = "IMPORTE")
	private BigDecimal importe;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_COCINERO")
	private Cocinero cocinero;
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_FACTURA")
	private Factura factura;*/
	
	public DetalleFactura() {
		
	}

	public Long getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(Long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Cocinero getCocinero() {
		return cocinero;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	/*public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}*/

	
	
	

}
