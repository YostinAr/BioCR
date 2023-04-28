package com.tienda.controller;

import com.tienda.domain.Lugar;
import com.tienda.service.LugarService;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LugarController {

    @Autowired
    private LugarService lugarService;
    @Autowired
    private CategoriaService categoriaService;

        
    @GetMapping("/lugar/listado")
    public String inicio(Model model) {       
       var lugares = lugarService.getLugares(false);
        model.addAttribute("lugares", lugares);
        return "/lugar/listado";
    } 
    
    @GetMapping("/lugar/nuevo")
    public String nuevoLugar(Lugar lugar, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/lugar/modificar";
    }

    @PostMapping("/lugar/guardar")
    public String guardarLugar(Lugar lugar, Model model) {
        lugarService.save(lugar);
         return "redirect:/lugar/listado";
     
    }
   @GetMapping("/lugar/modificar/{idLugar}")
    public String modificarLugar(Lugar lugar, Model model) {
        lugar = lugarService.getLugar(lugar);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        model.addAttribute("lugar", lugar);
           return "lugar/modificar";
    }

    @GetMapping("/lugar/eliminar/{idLugar}")
    public String eliminarLugar(Lugar lugar) {        
        lugarService.delete(lugar);        
        return "redirect:/lugar/listado";
    }    
}
