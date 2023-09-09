package com.usuario.usuarios.Controller;

import com.usuario.usuarios.Entities.Usuario;
import com.usuario.usuarios.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserServices services;
    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<>(services.getUsuarios(),HttpStatus.OK);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Optional<Usuario>> getUsuarioById(@PathVariable int id){
        return new ResponseEntity<Optional<Usuario>>(services.getUsuarioById(id),HttpStatus.OK);
    }
    @GetMapping("/usuarioByUser/{userId}")
    public ResponseEntity<Optional<Usuario>> getUsuarioByUserId(@PathVariable String userId){
        return new ResponseEntity<Optional<Usuario>>(services.getUsuarioByUserid(userId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        return new ResponseEntity<>(services.create(usuario),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateById(@PathVariable int id,@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(services.updateUser(id, usuario.getName(), usuario.getLastName(), usuario.getPassword(),
                usuario.getTelefono(), usuario.getEmailAddress(), usuario.getTipoDeDocumento(), usuario.getDocumento()),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
    services.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserByUserId(@PathVariable String userId){
        Optional<Usuario> usuarioOptional = services.getUsuarioByUserid(userId);
        if (usuarioOptional.isPresent()) {
            services.deleteUserById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new RuntimeException("El usuario con userId " + userId + " no existe.");
        }
    }


}
