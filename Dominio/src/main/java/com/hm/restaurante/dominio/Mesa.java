package com.hm.restaurante.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TEST_MESAS")
@XmlRootElement
public class Mesa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTestMesa")
	@SequenceGenerator(name="seqTestMesa",sequenceName="SEQ_TEST_MESA",initialValue=1,allocationSize=1)
	@Column(name = "ID_MESA")
	private Long idMesa;
	@Column(name = "NUM_MAX_COMENSALES")
	private String numMaxComensales;
	@Column(name = "UBICACION")
	private String ubicacion;
	
	public Mesa() {
		
	}

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public String getNumMaxComensales() {
		return numMaxComensales;
	}

	public void setNumMaxComensales(String numMaxComensales) {
		this.numMaxComensales = numMaxComensales;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
