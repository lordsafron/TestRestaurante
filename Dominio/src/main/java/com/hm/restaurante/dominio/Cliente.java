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
@Table(name = "TEST_CLIENTES")
@XmlRootElement
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTestClient")
	@SequenceGenerator(name="seqTestClient",sequenceName="SEQ_TEST_CLIENTE",initialValue=1,allocationSize=1)
	@Column(name="ID_CLIENTE")
	private Long idCliente;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="PRIMER_APELLIDO")
	private String apellido1;
	@Column(name="SEGUNDO_APELLIDO")
	private String apellido2;
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	public Cliente() {
		
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	

}
