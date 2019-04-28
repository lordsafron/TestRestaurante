/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.dao.impl;

import com.hm.restaurante.dominio.Factura;
import com.hm.restaurante.fachada.dao.FacturaDAO;
import com.hm.restaurante.pojo.MessageResponse;
import com.hm.restaurante.pojo.ReporteCamarero;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class FacturaDAOImpl implements FacturaDAO {

    private static final Logger LOGGER = Logger.getLogger(FacturaDAOImpl.class);

    @PersistenceContext(name = "restauranteUnit")
    private EntityManager em;

    @Override
    public MessageResponse insertFactura(Factura factura) {
        MessageResponse messageResponse;
        try {
            em.persist(factura);
            messageResponse = new MessageResponse();
            messageResponse.setRc("0");
        } catch (Exception ex) {
            LOGGER.fatal("Error: " + ex);
            messageResponse = new MessageResponse();
            messageResponse.setRc("-1");
        }
        return messageResponse;
    }

    @Override
    public List<Object[]> reporteCamareros() {


        Query consultaReporte = em.createNativeQuery("select sum(df.importe) as importe_total, c.nombre, c.primer_apellido, c.id_camarero\n"
                + "FROM TEST_DETALLE_FACTURA df\n"
                + "inner join TEST_FACTURAS f on f.id_factura = df.id_factura\n"
                + "right join TEST_CAMAREROS c on f.ID_CAMARERO = c.id_camarero\n"
                + "group by c.nombre, c.primer_apellido,  c.id_camarero order by sum(df.importe) desc");

        List<Object[]> list =  consultaReporte.getResultList();

        for (Object[] objects : list) {
            System.out.println("objects: " + objects);
        }
        return list;
    }

    @Override
    public List<Object[]> reporteClientes() {
        Query consultaReporte = em.createNativeQuery("select sum(df.importe) as importe_total, c.nombre, c.primer_apellido, c.id_cliente\n" +
"FROM TEST_DETALLE_FACTURA df\n" +
"inner join TEST_FACTURAS f on f.id_factura = df.id_factura\n" +
"right join TEST_CLIENTES  c on f.id_cliente = c.id_cliente\n" +
"group by c.nombre, c.primer_apellido,  c.id_cliente order by sum(df.importe) desc");

        List<Object[]> list =  consultaReporte.getResultList();

        for (Object[] objects : list) {
            System.out.println("objects: " + objects);
        }
        return list;
    }

}
