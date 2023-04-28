package com.tienda.service;

import com.tienda.domain.Lugar;
import java.util.List;

public interface LugarService {
    public List<Lugar> getLugares(boolean activos);
    
    public void save(Lugar cliente);
    
    public void delete(Lugar cliente);
    
    public Lugar getLugar(Lugar cliente);
}
