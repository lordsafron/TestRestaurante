/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.fachada.dao;

import com.hm.restaurante.dominio.Camarero;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HugoM
 */
@Remote
public interface CamareroDAO {
    
    public List<Camarero> findAllCamareros();
    
    public Camarero findCamareroByIdCamarero(Long idCamarero);
    
}
