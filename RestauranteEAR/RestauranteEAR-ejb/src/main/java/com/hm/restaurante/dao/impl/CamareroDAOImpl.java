/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.dao.impl;

import com.hm.restaurante.dominio.Camarero;
import com.hm.restaurante.fachada.dao.CamareroDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HugoM
 */
@Stateless
public class CamareroDAOImpl implements CamareroDAO {
    
    @PersistenceContext(name = "restauranteUnit")
    private EntityManager em;

    @Override
    public List<Camarero> findAllCamareros() {
        return em.createQuery("SELECT c FROM Camarero c").getResultList();
    }

    @Override
    public Camarero findCamareroByIdCamarero(Long idCamarero) {
        return em.find(Camarero.class, idCamarero);
    }
    
}
