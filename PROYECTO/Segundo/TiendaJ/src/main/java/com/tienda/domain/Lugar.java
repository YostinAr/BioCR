package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="lugar")
public class Lugar implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_lugar")
    private Long idLugar;
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private Double precio;
    private int existencias;
    private boolean activo;
    
  
    public Lugar() {
    }

    public Lugar(Long idCategoria, String descripcion, String detalle, Double precio, int existencias, boolean activo, String ruta_imagen) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
      
}
