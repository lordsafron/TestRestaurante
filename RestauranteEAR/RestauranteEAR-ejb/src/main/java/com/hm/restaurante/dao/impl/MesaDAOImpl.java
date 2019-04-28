/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.dao.impl;

import com.hm.restaurante.dominio.Mesa;
import com.hm.restaurante.fachada.dao.MesaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HugoM
 */
@Stateless
public class MesaDAOImpl implements MesaDAO {
    
    @PersistenceContext(name = "restauranteUnit")
    private EntityManager em;

    @Override
    public List<Mesa> findAllMesas() {
        return em.createQuery("SELECT m FROM Mesa m").getResultList();
    }  

    @Override
    public Mesa findMesaByIdMesa(Long idMesa) {
        return em.find(Mesa.class, idMesa);
    }
    
}
