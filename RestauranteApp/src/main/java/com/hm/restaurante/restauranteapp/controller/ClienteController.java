/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.restaurante.restauranteapp.controller;

import com.hm.restaurante.dominio.Cliente;
import com.hm.restaurante.dominio.DetalleFactura;
import com.hm.restaurante.dominio.Factura;
import com.hm.restaurante.fachada.dao.CocineroDAO;
import com.hm.restaurante.pojo.FacturaPojo;
import com.hm.restaurante.pojo.MessageResponse;
import com.hm.restaurante.pojo.RequestSaveFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hm.restaurante.restauranteapp.service.FachadaService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HugoM
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private FachadaService fachadaService;

    @GetMapping("/showForm")
    public String showForm(Model model) throws Exception {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("titulo", "Registro Cliente");
        return "index";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute("cliente") Cliente cliente, Model model) throws Exception {
        MessageResponse messageResponse = fachadaService.insertCliente(cliente);
        System.out.println("idCliente: " + messageResponse.getMsg());
        cliente.setIdCliente(Long.valueOf(messageResponse.getMsg()));
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Crear Factura");
        model.addAttribute("mesas", fachadaService.findAllMesas());
        model.addAttribute("factura", new Factura());
        model.addAttribute("detalleFactura", new DetalleFactura());
        model.addAttribute("formulario", new FacturaPojo());
        model.addAttribute("camareros", fachadaService.findAllCamareros());
        model.addAttribute("cocineros", fachadaService.findAllCocineros());
        return "factura";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/factura")
    public String showPage(Model model) throws Exception {
        model.addAttribute("titulo", "Restaurante");
        model.addAttribute("mesas", fachadaService.findAllMesas());
        model.addAttribute("formulario", new FacturaPojo());
        //model.addAttribute("detalleFactura", new DetalleFactura());
        model.addAttribute("camareros", fachadaService.findAllCamareros());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facturaPojo") RequestSaveFactura facturaPojo,
            @RequestParam(name = "plato[]") String[] plato,
            @RequestParam(name = "precio[]") String[] precio,
            @RequestParam(name = "cantidad[]") String[] cantidad,
            @RequestParam(name = "cocinero") Long[] idCocinero,
            @RequestParam(name = "idCliente") String idCliente
    ) throws Exception {
        System.out.println("Recibido");
        List<DetalleFactura> lDetalleFactura = new ArrayList<>();
        Factura factura = new Factura();
        for (int i = 1; i < plato.length; i++) {
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setCocinero(fachadaService.findCocineroByIdCocinero(idCocinero[i]));
            detalleFactura.setPlato(plato[i]);
            detalleFactura.setImporte(new BigDecimal(cantidad[i]).multiply(new BigDecimal(precio[i])));

            lDetalleFactura.add(detalleFactura);
            //System.out.println("plato: " + plato[i]);
            //System.out.println("cantidad: " + cantidad[i]);
            //System.out.println("precio: " + precio[i]);
        }

        factura.setDetalleFactura(lDetalleFactura);
        factura.setCamarero(fachadaService.findCamareroByIdCamarero(Long.valueOf(facturaPojo.getCamarero())));
        factura.setMesa(fachadaService.findMesaByIdMesa(Long.valueOf(facturaPojo.getMesa())));
        factura.setCliente(fachadaService.findByIdCliente(Long.valueOf(idCliente)));

        MessageResponse messageResponse = fachadaService.insertFactura(factura);

        if (messageResponse.getRc().equals("0")) {
            return "redirect:success";
        } else {
            return "form";
        }
    }
    
    @GetMapping("/reporteCamarero")
    public String getReporteCamarero(Model model) throws Exception {
        model.addAttribute("reporte", fachadaService.reporteCamareros());
        model.addAttribute("titulo", "Reporte Camareros");
        return "reportecamarero";
    }
    
    @GetMapping("/reporteCliente")
    public String getReporteCliente(Model model) throws Exception {
        model.addAttribute("reporte", fachadaService.reporteClientes());
        model.addAttribute("titulo", "Reporte Clientes");
        return "reportecliente";
    }

}
