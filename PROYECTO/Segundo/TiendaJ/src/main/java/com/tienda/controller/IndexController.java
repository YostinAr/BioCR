package com.tienda.controller;

import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.service.LugarService;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private LugarService lugarService;
    
    @GetMapping("/")
    public String inicio(Model model) {  
       var lugares = lugarService.getLugares(true);
       model.addAttribute("lugares", lugares);
        return "index";
    }    
}