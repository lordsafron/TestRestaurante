/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.dao.impl;

import com.hm.restaurante.dominio.Cocinero;
import com.hm.restaurante.fachada.dao.CocineroDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HugoM
 */
@Stateless
public class CocineroDAOImpl implements CocineroDAO {
    
    @PersistenceContext(name = "restauranteUnit")
    private EntityManager em;

    @Override
    public List<Cocinero> findAllCocineros() {
        return em.createQuery("SELECT c FROM Cocinero c").getResultList();
    }

    @Override
    public Cocinero findCocineroByIdCocinero(Long idCocinero) {
        return em.find(Cocinero.class, idCocinero);
    }
    
}
