package com.app.productos.repositorio;

import com.app.productos.entidades.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {

    //Se ingresa para buscar algun producto por su nombre
    public Producto findByNombre(String nombre);


}
