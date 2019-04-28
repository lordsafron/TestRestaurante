package com.hm.restaurante.restauranteapp.util;


import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HugoM
 */
public class Utilidades {
    
    public static Object getEJBRemote(String nameEJB, String iface) throws Exception {
        Context context;
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        props.put(Context.PROVIDER_URL, "http://localhost:4848");
        try {
            context = new InitialContext(props);
            String lookup = "java:global/RestauranteEAR-ear/RestauranteEAR-ejb-1.0/"+nameEJB+"!"+iface;
            System.out.println("Lookup: "+lookup);
            return context.lookup(lookup);
        } catch(Exception ex) {
            throw new Exception("No se encontro el EJB: '"+nameEJB+"'.");
        }
    }
    
}
