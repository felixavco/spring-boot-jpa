package com.xilews.springboot.app.models.dao;

import java.util.List;

import com.xilews.springboot.app.models.entity.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
    
    //Opcion 1 using a custom query
    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findByNombre(String term);

    //Opcion 2 using a query from JPA
    public List<Producto> findByNombreLikeIgnoreCase(String term);
}