/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.pojo;

import com.hm.restaurante.dominio.Camarero;
import com.hm.restaurante.dominio.Cocinero;
import com.hm.restaurante.dominio.Mesa;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HugoM
 */
@XmlRootElement
public class FacturaPojo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Mesa mesa;
    private Camarero camarero;
    private Cocinero cocinero;
    
    public FacturaPojo() {
        
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }

    
    
}
