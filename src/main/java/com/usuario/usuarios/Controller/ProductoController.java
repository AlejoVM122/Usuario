package com.usuario.usuarios.Controller;

import com.usuario.usuarios.Entities.Productos;
import com.usuario.usuarios.Services.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductosServices services;

    @GetMapping("/get")
    public ResponseEntity<List<Productos>> getProducto(){
        return new ResponseEntity<>(services.getProductos(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Productos> create (@RequestBody Productos producto){
        return new ResponseEntity<>(services.create(producto),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Optional<Productos>> update (@PathVariable int idProducto,
                                            @RequestBody Productos produycto){
        return new ResponseEntity<>(services.update(idProducto,produycto.getNombre(),produycto.getPrecio(),
                produycto.getCategoria()),HttpStatus.ACCEPTED);
    }


}
