/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.fachada.dao;

import com.hm.restaurante.dominio.Mesa;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HugoM
 */
@Remote
public interface MesaDAO {
    
    public List<Mesa> findAllMesas();
    
    public Mesa findMesaByIdMesa(Long idMesa);
    
}
