package com.usuario.usuarios.Services;

import com.usuario.usuarios.Entities.Productos;
import com.usuario.usuarios.Entities.Usuario;
import com.usuario.usuarios.Repository.ProductoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class ProductosServicesTest {
    @Mock
    private ProductoRepository repository;
    @InjectMocks
    private ProductosServices services;

    @Test
    void create() {
        Productos esperado = new Productos(1,"tea",10.2,"consumibles");
        Mockito.when(repository.save(eq(esperado))).thenReturn(esperado);
        Productos resultado = services.create(esperado);
        Assertions.assertEquals(esperado, resultado);}

    @Test
    void getProductos() {
        Productos esperado = new Productos(1,"tea",10.2,"consumibles");
        Productos esperado1 = new Productos(1,"tea",10.2,"consumibles");
        Productos esperado2 = new Productos(1,"tea",10.2,"consumibles");
        List<Productos> productos = new ArrayList<>();
        productos.add(esperado);
        productos.add(esperado1);
        productos.add(esperado2);
        Mockito.when(services.getProductos()).thenReturn(productos);

        final List<Productos> resultado = repository.findAll();
        Assertions.assertEquals(productos,resultado);
    }
}
