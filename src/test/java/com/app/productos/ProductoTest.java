package com.app.productos;

//Importar de manera manual el assertNotNull

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.app.productos.entidades.Producto;
import com.app.productos.repositorio.ProductoRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


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


}