package com.usuario.usuarios.Services;
import com.usuario.usuarios.Entities.Usuario;
import com.usuario.usuarios.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository repository;
    public Usuario create(Usuario usuario){
        if (repository.findByUserId(usuario.getUserId()).isPresent()){
            System.out.println("Your userId is in use, try another");
             throw new RuntimeException("yor user is already created");
        }return repository.save(usuario);
    }
    public Usuario createUsuario(String name, String apellido, String password, String userId, String correo){
        Usuario usuario = new Usuario();
        usuario.setName(name);
        if (repository.findByUserId(userId).isPresent()){
            System.out.println("Your userId is not valid, cause now is in use");
        }usuario.setUserId(userId);

        usuario.setLastName(apellido);
        usuario.setPassword(password);
        usuario.setEmailAddress(correo);
        return repository.save(usuario);
    }
    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }
    public Optional<Usuario> getUsuarioById(int id){
        return repository.findById(id);}
    public Optional<Usuario> getUsuarioByUserid(String userid) {
        return repository.findByUserId(userid);}
    public Usuario updateUser( int id,String name, String apellido, String password, String telefono,
                              String correo, String tipoDeDocumento, String documento){
        Usuario usuarioExistente = repository.findById(id).
                orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        usuarioExistente.setName(name);
        usuarioExistente.setLastName(apellido);
        usuarioExistente.setPassword(password);
        usuarioExistente.setEmailAddress(correo);
        usuarioExistente.setTipoDeDocumento(tipoDeDocumento);
        usuarioExistente.setDocumento(documento);
        return repository.save(usuarioExistente);
        }
        @Transactional
        public void deleteUserById(String userId){
        repository.deleteByUserId(userId);
    }
    public void delete(int id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            System.out.println("Your username has been deleted");
        } else{
            System.out.println("No se encontro el usuario");}
    }

}
