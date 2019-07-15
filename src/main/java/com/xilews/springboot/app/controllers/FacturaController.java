package com.xilews.springboot.app.controllers;

import java.util.List;

import com.xilews.springboot.app.models.entity.Client;
import com.xilews.springboot.app.models.entity.Factura;
import com.xilews.springboot.app.models.entity.Producto;


import com.xilews.springboot.app.models.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping({"/factura", "/facturas"})
@SessionAttributes("factura")
public class FacturaController {

    @Autowired
    private IClientService clientService;
    
    @GetMapping("/form/{clientId}")
    public String create(
        @PathVariable Long clientId, 
        Model model, 
        RedirectAttributes flash
    ) {

        Client client = clientService.findOne(clientId);

        if(client == null) {
            flash.addFlashAttribute("error", "Client does not exist");
            return "redirect:/";
        }

        Factura factura = new Factura();

        factura.setClient(client);

        model.addAttribute("factura", factura);
        model.addAttribute("title", "Create Bill");

        return "factura/form";
    }

    @GetMapping(value="/cargar-productos/{term}", produces = {"application/json"})
    public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {

        return clientService.findByNombre("%"+term+"%");
    }
    
}