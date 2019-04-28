package com.hm.restaurante.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_COCINEROS")
public class Cocinero implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTestCocinero")
	@SequenceGenerator(name="seqTestCocinero",sequenceName="SEQ_TEST_COCINERO",initialValue=1,allocationSize=1)
	@Column(name = "ID_COCINERO")
	private Long idCocinero;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "PRIMER_APELLIDO")
	private String apellido1;
	@Column(name = "SEGUNDO_APELLIDO")
	private String apellido2;
	
	public Cocinero() {
		
	}

	public Long getIdCocinero() {
		return idCocinero;
	}

	public void setIdCocinero(Long idCocinero) {
		this.idCocinero = idCocinero;
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
	
	

}
