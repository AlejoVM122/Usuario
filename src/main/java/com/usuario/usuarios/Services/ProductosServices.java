package com.usuario.usuarios.Services;
import com.usuario.usuarios.Entities.Productos;
import com.usuario.usuarios.Repository.ProductoRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServices {
    @Autowired
    private ProductoRepository repository;

    public List<Productos> getProductos(){
        return repository.findAll();
    }

    public Productos create (Productos productos){
        Productos producto1 = new Productos(productos.getIdProductos(), productos.getNombre(),
                productos.getPrecio(), productos.getCategoria());
        if (repository.findById(producto1.getIdProductos()).isPresent()){
            throw new RuntimeException("Your user already exist");
        }else {
        return repository.save(producto1);}
        }
    public Optional<Productos> getProducto (int idProducto){
        if (repository.findById(idProducto).isPresent()){
            return repository.findById(idProducto);
        }else {
            throw new RuntimeException("Your product can be get, cause its not present");
        }
    }
    public Optional<Productos> update (int idProducto,String name,double precio,String categoria){
        if (repository.findById(idProducto).isPresent()){
            repository.findById(idProducto).get().setNombre(name);
            repository.findById(idProducto).get().setPrecio(precio);
            repository.findById(idProducto).get().setCategoria(categoria);
            return repository.findById(idProducto);
        }else {
            throw new RuntimeException("Your product can be get, cause its not present");
        }
    }
}
