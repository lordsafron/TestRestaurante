/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.restauranteapp.service;

import com.hm.restaurante.dominio.Camarero;
import com.hm.restaurante.dominio.Cliente;
import com.hm.restaurante.dominio.Cocinero;
import com.hm.restaurante.dominio.Factura;
import com.hm.restaurante.dominio.Mesa;
import com.hm.restaurante.pojo.MessageResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HugoM
 */

public interface FachadaService { 

    public List<Cliente> findAllClients() throws Exception;
    
    public Cliente findByIdCliente(Long idCliente) throws Exception;
    
    public List<Mesa> findAllMesas() throws Exception;
    
    public List<Camarero> findAllCamareros() throws Exception;
    
    public MessageResponse insertCliente(Cliente cliente) throws Exception;
    
    public List<Cocinero> findAllCocineros() throws Exception;
    
    public MessageResponse insertFactura(Factura factura) throws Exception;
    
    public Cocinero findCocineroByIdCocinero(Long idCocinero) throws Exception;
    
    public Camarero findCamareroByIdCamarero(Long IdCamarero) throws Exception;
    
    public Mesa findMesaByIdMesa(Long idMesa) throws Exception;
    
    public List<Object[]> reporteCamareros() throws Exception;
    
    public List<Object[]> reporteClientes() throws Exception;

}
