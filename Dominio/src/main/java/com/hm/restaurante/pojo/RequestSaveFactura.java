/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.pojo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HugoM
 */
@XmlRootElement
public class RequestSaveFactura implements Serializable {
    
    private String camarero;
    private String[] cocinero;
    private String mesa;
    
    public RequestSaveFactura() {
        
    }

    public String getCamarero() {
        return camarero;
    }

    public void setCamarero(String camarero) {
        this.camarero = camarero;
    }

    public String[] getCocinero() {
        return cocinero;
    }

    public void setCocinero(String[] cocinero) {
        this.cocinero = cocinero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
    
    
    
}
