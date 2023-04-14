
package com.tienda;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

public class MvcConfig extends WebConfig{
    
    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/")
                .setViewName("index");
        registry.addViewController("/index")
                .setViewName("index");
        registry.addViewController("/login")
                .setViewName("login");
        registry.addViewController("/registro")
                .setViewName("registro");
        registry.addViewController("/errores/403")
                .setViewName("/errores/403");
    }
}
