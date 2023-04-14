package com.tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
//Este metodo funciona para hacer la autentificación de usuarios

@Override
protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests()
    .antMatchers("/articulo/nuevo", "/articulo/guardar",
                 "/articulo/modificar/**", "/articulo/eliminar",
                 "/categoria/nuevo**", "/categoria/guardar",
                 "/categoria/modificar/**", "/categoria/eliminar/**",
                 "/cliente/nuevo**", "/cliente/guardar",
                 "/cliente/modificar/**", "/cliente/eliminar/**",
                 "/usuario/nuevo**", "/usuario/guardar",
                 "/usuario/modificar/**", "/usuario/eliminar/**")
                 
    .hasRole("ADMIN")
    .antMatchers("/articulo/listado",
                 "/categoria/listado",
                 "/cliente/listado")
    .hasAnyRole("ADMIN", "VENDEDOR")
    .antMatchers("/","/carrito/**")
                 .permitAll()
                 .antMatchers("/facturar","/carrito")
                 .authenticated()
                
                 .and().formLogin().loginPage("/login")
                 .and().exceptionHandling().accessDeniedPage("/errores/403");
}

}