/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.fachada.dao;

import com.hm.restaurante.dominio.Factura;
import com.hm.restaurante.pojo.MessageResponse;
import com.hm.restaurante.pojo.ReporteCamarero;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author HugoM
 */
@Remote
public interface FacturaDAO {
    
    public MessageResponse insertFactura(Factura factura);
    
    public List<Object[]> reporteCamareros();
    
    public List<Object[]> reporteClientes();
    
}
