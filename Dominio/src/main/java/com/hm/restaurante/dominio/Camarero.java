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
@Table(name = "TEST_CAMAREROS")
@XmlRootElement
public class Camarero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTestCamarero")
	@SequenceGenerator(name="seqTestCamarero",sequenceName="SEQ_TEST_CAMARERO",initialValue=1,allocationSize=1)
	@Column(name = "ID_CAMARERO")
	private Long idCamarero;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "PRIMER_APELLIDO")
	private String apellido1;
	@Column(name = "SEGUNDO_APELLIDO")
	private String apellido2;
	
	public Camarero() {
		
	}

	public Long getIdCamarero() {
		return idCamarero;
	}

	public void setIdCamarero(Long idCamarero) {
		this.idCamarero = idCamarero;
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
