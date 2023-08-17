package com.app.productos;


import com.app.productos.entidades.Producto;
import com.app.productos.repositorio.ProductoRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull; //Importar de manera manual el assertNotNull
import static org.assertj.core.api.Assertions.assertThat; //Importar de manera manual el assertThat
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Decirle que quiero trabajar con la BD real
public class ProductoTest {

    @Autowired
    private ProductoRepositorio repositorio;

    @Test
    @Rollback(value = false) //Para que guarde y no haga rollback, ya que quiero insertar los datos en mi BD
    public void testGuardarProducto() {
        Producto producto = new Producto("Phone 15 Pro", 15000);
        Producto productoGuardado = repositorio.save(producto);

        //Confirmar que quiero guardar
        assertNotNull(productoGuardado);
    }

    @Test
    public void testBuscarProductosPorNombre() {
        String nombre = "Phone 15 Pro";
        Producto producto = repositorio.findByNombre(nombre);

        //Confirma
        assertThat(producto.getNombre()).isEqualTo(nombre);

    }

    @Test
    public void testBuscarProductosPorNombreNoExistente() {
        String nombre = "Acatel 15 Pro";
        Producto producto = repositorio.findByNombre(nombre);

        //Confirma
        assertNull(producto); //Para buscar por nombre no existente
    }


}
