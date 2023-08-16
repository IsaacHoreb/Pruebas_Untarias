package com.app.productos.repositorio;

import com.app.productos.entidades.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {


}
