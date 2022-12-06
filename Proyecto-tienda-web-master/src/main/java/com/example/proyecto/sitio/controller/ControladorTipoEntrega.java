package com.example.proyecto.sitio.controller;


import com.example.proyecto.sitio.interfaceService.ICiudadService;
import com.example.proyecto.sitio.interfaceService.IRegionService;
import com.example.proyecto.sitio.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.proyecto.sitio.controller.ControladorProducto.carrito;

@Controller
@RequestMapping

/**
 * Esta clase contiene todos los metodos necesarios para el funcionamiento del tipo de entrega
 * @version 23/11/2021
 */

public class ControladorTipoEntrega {

    @Autowired
    private IRegionService service_region;

    @Autowired
    private ICiudadService service_ciudad;


    //****************************************************
    //******************* TIPO ENTREGA *******************
    //****************************************************

    /**
     * Esta funcion redirecciona a la vista tipo entrega
     * y muestra informmacion que se agregara a la orden de compra
     *
     * @param model Es un contenedor de Spring Boot que tiene informacion del programa
     * @return Redirecciona a la vista tipo entrega
     */

    @GetMapping("/tipo_entrega")
    public String tipo_entrega(Model model){


        if( carrito.getProductos().isEmpty() ){
            System.err.println("CARRITO VACIO");

            return "redirect:/carrito";
        }

        List<PCantidad> p_cantidad = carrito.getProductos();
        List<Region> regiones = service_region.listar();
        List<Ciudad> ciudades = service_ciudad.listar();

        model.addAttribute("regiones", regiones);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("orden_compra", new OrdenCompra());

        model.addAttribute("p_cantidades", p_cantidad);
        model.addAttribute("precio_total", carrito.getTotal() );

        return "tipo_entrega";
    }// cierra funcion


}
