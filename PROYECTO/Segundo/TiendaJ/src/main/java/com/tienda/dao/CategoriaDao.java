package com.tienda.dao;

import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria,Long> {
}
