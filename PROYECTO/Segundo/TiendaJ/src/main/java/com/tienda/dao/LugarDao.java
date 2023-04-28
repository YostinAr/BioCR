package com.tienda.dao;

import com.tienda.domain.Lugar;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LugarDao extends CrudRepository<Lugar,Long> {
}
