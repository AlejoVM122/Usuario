package Controller;

import Entities.Usuario;
import Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserServices services;
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<>(services.getUsuarios(),HttpStatus.OK);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Optional<Usuario>> getUsuarioById(@RequestParam int id){
        return new ResponseEntity<Optional<Usuario>>(services.getUsuarioById(id),HttpStatus.OK);
    }
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<Optional<Usuario>> getUsuarioByUserId(@RequestParam int UserId){
        return new ResponseEntity<Optional<Usuario>>(services.getUsuarioById(UserId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody String name,@RequestBody String apellido,
                                          @RequestBody String password, @RequestBody String telefono,
                                          @RequestBody String correo,@RequestBody String tipoDeDocumento,
                                          @RequestBody String documento){
        return new ResponseEntity<>(services.create(name, apellido, password, telefono, correo, tipoDeDocumento, documento),
                HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody String name,@RequestBody String apellido,@RequestBody String password,
                                          @RequestBody String correo){
        return new ResponseEntity<>(services.create(name,apellido,password,correo),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateById(@PathVariable int id,@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(services.updateUser(id, usuario.getName(), usuario.getLastName(), usuario.getPassword(),
                usuario.getTelefono(), usuario.getEmailAddress(), usuario.getTipoDeDocumento(), usuario.getDocumento()),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id){
        services.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserByUserId(@PathVariable int userId){
        services.deleteUserById(userId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
