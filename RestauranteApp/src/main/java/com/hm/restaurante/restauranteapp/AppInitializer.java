/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.restauranteapp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author HugoM
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
        protected Class<?>[] getRootConfigClasses() {
             return null;
        }
 
        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[] { AppConfig.class };
        }
 
        @Override
        protected String[] getServletMappings() {
             return new String[] { "/" };
        }
    
}
