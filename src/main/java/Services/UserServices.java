package Services;

import Entities.Usuario;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository repository;
    public Usuario create(String name, String apellido, String password, String telefono,
                          String correo, String tipoDeDocumento, String documento){
    Usuario usuario = new Usuario();
    usuario.setName(name);
    usuario.setLastName(apellido);
    usuario.setPassword(password);
    usuario.setTelefono(telefono);
    usuario.setDocumento(documento);
    usuario.setEmailAddress(correo);
    usuario.setTipoDeDocumento(tipoDeDocumento);
    return repository.save(usuario);
    }
    public Usuario create(String name, String apellido, String password, String correo){
        Usuario usuario = new Usuario();
        usuario.setName(name);
        usuario.setLastName(apellido);
        usuario.setPassword(password);
        usuario.setEmailAddress(correo);
        return repository.save(usuario);
    }
    public List<Usuario> getUsuarios(){
        return repository.findAll();
    }
    public Optional<Usuario> getUsuarioById(int id){
        return repository.findById(id);
    }
    public Optional<Usuario> getUsuarioByUserid(int id) {
        return repository.findByUserId(id);}
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
    public void deleteUserById (int id){
        Usuario usuarioExistente = repository.findByUserId(id).orElseThrow(()-> new RuntimeException("No hay un usuario con ese id." +
                "Revise nuevamente el id"));
        repository.delete(usuarioExistente);
    }

    public void deleteUserByUserId (int userId){
        Usuario usuarioExistente = repository.findByUserId(userId).orElseThrow(()-> new RuntimeException("No hay un usuario con ese id." +
                "Revise nuevamente el id"));
        repository.delete(usuarioExistente);
    }
}
