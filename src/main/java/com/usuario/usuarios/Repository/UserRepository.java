package com.usuario.usuarios.Repository;

import com.usuario.usuarios.Entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT * FROM Usuario WHERE user_id = :userId", nativeQuery = true)
    Optional<Usuario> findByUserId(@Param("userId") String userId);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuario WHERE user_id = :userId", nativeQuery = true)
    void deleteByUserId(@Param("userId") String userId);


}