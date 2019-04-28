/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.restauranteapp.service.impl;

import com.hm.restaurante.dominio.Camarero;
import com.hm.restaurante.dominio.Cliente;
import com.hm.restaurante.dominio.Cocinero;
import com.hm.restaurante.dominio.Factura;
import com.hm.restaurante.dominio.Mesa;
import com.hm.restaurante.fachada.dao.CamareroDAO;
import com.hm.restaurante.fachada.dao.ClienteDAO;
import com.hm.restaurante.fachada.dao.CocineroDAO;
import com.hm.restaurante.fachada.dao.FacturaDAO;
import com.hm.restaurante.fachada.dao.MesaDAO;
import com.hm.restaurante.pojo.MessageResponse;
import com.hm.restaurante.restauranteapp.util.Utilidades;
import java.util.List;
import org.springframework.stereotype.Service;
import com.hm.restaurante.restauranteapp.service.FachadaService;
import java.util.Map;

/**
 *
 * @author HugoM
 */
@Service
public class FachadaServiceImpl implements FachadaService{
    
    private ClienteDAO clienteDAO;
    private MesaDAO mesaDAO;
    private CamareroDAO camareroDAO;
    private CocineroDAO cocineroDAO;
    private FacturaDAO facturaDAO;

    @Override
    public List<Cliente> findAllClients() throws Exception{
        
        clienteDAO = (ClienteDAO) Utilidades.getEJBRemote("ClienteDAOImpl", ClienteDAO.class.getName());
        return clienteDAO.findAllClients();
    }

    @Override
    public Cliente findByIdCliente(Long idCliente) throws Exception {
        clienteDAO = (ClienteDAO) Utilidades.getEJBRemote("ClienteDAOImpl", ClienteDAO.class.getName());
        Cliente cliente = clienteDAO.findByIdCliente(idCliente);
        return cliente;
    }

    @Override
    public List<Mesa> findAllMesas() throws Exception {
        mesaDAO = (MesaDAO) Utilidades.getEJBRemote("MesaDAOImpl", MesaDAO.class.getName());
        return mesaDAO.findAllMesas();
    }

    @Override
    public List<Camarero> findAllCamareros() throws Exception {
        camareroDAO = (CamareroDAO) Utilidades.getEJBRemote("CamareroDAOImpl", CamareroDAO.class.getName());
        return camareroDAO.findAllCamareros();
    }

    @Override
    public MessageResponse insertCliente(Cliente cliente) throws Exception {
        clienteDAO = (ClienteDAO) Utilidades.getEJBRemote("ClienteDAOImpl", ClienteDAO.class.getName());
        return clienteDAO.insertCliente(cliente);
    }

    @Override
    public List<Cocinero> findAllCocineros() throws Exception {
        cocineroDAO = (CocineroDAO) Utilidades.getEJBRemote("CocineroDAOImpl", CocineroDAO.class.getName());
        return cocineroDAO.findAllCocineros();
    }

    @Override
    public MessageResponse insertFactura(Factura factura) throws Exception {
        facturaDAO = (FacturaDAO) Utilidades.getEJBRemote("FacturaDAOImpl", FacturaDAO.class.getName());
        return facturaDAO.insertFactura(factura);
    }

    @Override
    public Cocinero findCocineroByIdCocinero(Long idCocinero) throws Exception {
        cocineroDAO = (CocineroDAO) Utilidades.getEJBRemote("CocineroDAOImpl", CocineroDAO.class.getName());
        return cocineroDAO.findCocineroByIdCocinero(idCocinero);
    }

    @Override
    public Camarero findCamareroByIdCamarero(Long idCamarero) throws Exception {
        camareroDAO = (CamareroDAO) Utilidades.getEJBRemote("CamareroDAOImpl", CamareroDAO.class.getName());
        return camareroDAO.findCamareroByIdCamarero(idCamarero);
    }

    @Override
    public Mesa findMesaByIdMesa(Long idMesa) throws Exception {
        mesaDAO = (MesaDAO) Utilidades.getEJBRemote("MesaDAOImpl", MesaDAO.class.getName());
        return mesaDAO.findMesaByIdMesa(idMesa);
    }

    @Override
    public List<Object[]> reporteCamareros() throws Exception {
        facturaDAO = (FacturaDAO) Utilidades.getEJBRemote("FacturaDAOImpl", FacturaDAO.class.getName());
        return facturaDAO.reporteCamareros();
    }

    @Override
    public List<Object[]> reporteClientes() throws Exception {
        facturaDAO = (FacturaDAO) Utilidades.getEJBRemote("FacturaDAOImpl", FacturaDAO.class.getName());
        return facturaDAO.reporteClientes();
    }
    
}
