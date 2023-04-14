package com.tienda.dao;

import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CreditoDao extends CrudRepository<Credito,Long> {
}
