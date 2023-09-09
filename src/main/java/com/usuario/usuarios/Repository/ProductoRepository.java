package com.usuario.usuarios.Repository;

import com.usuario.usuarios.Entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos,Integer> {

}
