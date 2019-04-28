package com.hm.restaurante.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TEST_FACTURAS")
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTestFactura")
	@SequenceGenerator(name="seqTestFactura",sequenceName="SEQ_TEST_FACTURA",initialValue=1,allocationSize=1)
	@Column(name = "ID_FACTURA")
	private Long idFactura;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_FACTURA")
	private Date fechaFactura;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_CAMARERO")
	private Camarero camarero;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_MESA")
	private Mesa mesa;
        @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @JoinColumn(name = "ID_FACTURA")
        private List<DetalleFactura> detalleFactura;
	
	
	public Factura() {
		
	}
	
	@PrePersist
	public void prePersist() {
		fechaFactura = new Date();
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

	

	
	
}
