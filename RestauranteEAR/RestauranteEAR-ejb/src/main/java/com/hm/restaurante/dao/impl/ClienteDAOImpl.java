/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.dao.impl;

import com.hm.restaurante.dominio.Cliente;
import com.hm.restaurante.fachada.dao.ClienteDAO;
import com.hm.restaurante.pojo.MessageResponse;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author HugoM
 */
@Stateless
public class ClienteDAOImpl implements ClienteDAO {
    
    private static final Logger LOGGER = Logger.getLogger(ClienteDAOImpl.class);

    @PersistenceContext(name = "restauranteUnit")
    private EntityManager em;

    @Override
    public List<Cliente> findAllClients() {

        Query consulta = em.createQuery("SELECT c FROM Cliente c");
        List<Cliente> lCliente = consulta.getResultList();
        return lCliente;
    }

    @Override
    public Cliente findByIdCliente(Long idCliente) {
        Query consulta = em.createQuery("SELECT c FROM Cliente c WHERE c.idCliente=?1");
        consulta.setParameter(1, idCliente);
        List<Cliente> lCliente = consulta.getResultList();
        return lCliente.get(0);
    }

    @Override
    public MessageResponse insertCliente(Cliente cliente) {
        MessageResponse messageResponse;
        try {
            em.persist(cliente);
            em.flush();
            messageResponse = new MessageResponse();
            messageResponse.setMsg(String.valueOf(cliente.getIdCliente()));
            messageResponse.setRc("0");
        } catch (Exception ex) {
            LOGGER.info("No se pudo insertar el cliente: " + ex);
            messageResponse = new MessageResponse();
            messageResponse.setRc("-1");
        }
        return messageResponse;
    }

}
