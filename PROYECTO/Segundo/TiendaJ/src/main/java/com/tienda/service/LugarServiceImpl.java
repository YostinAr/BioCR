package com.tienda.service;

import com.tienda.domain.Lugar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tienda.dao.LugarDao;

@Service
public class LugarServiceImpl implements LugarService {
    @Autowired
    private LugarDao clienteDao;
    
    @Override
    @Transactional(readOnly = true)
   public List<Lugar> getLugares(boolean activos) {
        var lista = (List<Lugar>)clienteDao.findAll();
        
        if (activos) {   lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
  
    @Override
    @Transactional(readOnly = true)
    public Lugar getLugar(Lugar cliente) {
        return clienteDao.findById(cliente.getIdLugar()).orElse(null);
    }
    
  
    @Override
    @Transactional
    public void save(Lugar cliente){
        clienteDao.save(cliente);
    }
    
    
    @Override
    @Transactional
    public void delete(Lugar cliente){
        clienteDao.delete(cliente);
    }
}
