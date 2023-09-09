package com.usuario.usuarios.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
@Data
@Table
@Entity
public class Productos {
    @Id
    @NonNull
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idProductos;
    @Column(name = "Nombre Producto")
    @NonNull
    private String nombre;
    @Column(name = "Precios")
    @NonNull
    private double precio;
    @Column(name = "Categoria")
    private String categoria;

    public Productos(@NonNull int idProductos, @NonNull String nombre, @NonNull double precio, String categoria) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Productos (){
    }
}

