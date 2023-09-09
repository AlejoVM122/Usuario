package com.usuario.usuarios.Services;

import com.usuario.usuarios.Entities.Usuario;
import com.usuario.usuarios.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.eq;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserServices userServices;
    @Test
    void create() {
        Usuario esperado = new Usuario("alejandro", "alejandro", "valencia", "dkhades", "correo");
        when(repository.save(eq(esperado))).thenReturn(esperado);
        Usuario resultado = userServices.create(esperado);
        Assertions.assertEquals(esperado, resultado);}
    @Test
    void getUsuarios() {
        Usuario esperado = new Usuario("alejandro", "alejandro", "valencia", "dkhades", "correo");
        Usuario esperado1 = new Usuario("Steven", "Valencia", "Molano", "123456", "gmail");
        List<Usuario> lista = new ArrayList<>();
        lista.add(esperado1);
        lista.add(esperado);
        Mockito.when(repository.findAll()).thenReturn(lista);
        final List<Usuario> resultado = repository.findAll();
        Assertions.assertEquals(lista,resultado);
    }
    @Test
    void getUsuarioById() {
        Usuario esperado = new Usuario("alejandro", "alejandro", "valencia", "dkhades", "correo");
        esperado.setId(2);
        Mockito.when(repository.findById(esperado.getId())).thenReturn(Optional.of(esperado));
        final Optional<Usuario> resultado = userServices.getUsuarioById(esperado.getId());
        Usuario usuarioResultado = resultado.get();
        Assertions.assertEquals(esperado, usuarioResultado);}
    @Test
    void getUsuarioByUserid() {
        Usuario esperado = new Usuario("alejandro", "alejandro", "valencia", "dkhades", "correo");
        Mockito.when(repository.findByUserId("dkhades")).thenReturn(Optional.of(esperado));
        final Optional<Usuario> resultado = userServices.getUsuarioByUserid("dkhades");
        Assertions.assertEquals(esperado, resultado.get());}
    @Test
    void updateUser() {
        Usuario esperado = new Usuario("alejandro", "alejandro", "valencia",
                "dkhades", "correo");
        esperado.setId(1);

        Mockito.doReturn(Optional.of(esperado)).when(repository).findById(Mockito.anyInt());
        Mockito.when(repository.save(Mockito.any(Usuario.class))).thenReturn(esperado);

        String nuevoNombre = "Gonzales";
        String nuevoApellido = "MOLANO";
        String nuevaContraseña = "1012";
        String nuevoTelefono = "5555";
        String nuevoCorreo = "ALEJO.COM";
        String nuevoTipoDocumento = "cc";
        String nuevoDocumento = "4545";

        Usuario nuevo =  userServices.updateUser(1, nuevoNombre,
                nuevoApellido, nuevaContraseña, nuevoTelefono, nuevoCorreo, nuevoTipoDocumento, nuevoDocumento);
        Mockito.verify(repository, Mockito.times(1)).save(esperado);
        Assertions.assertEquals(nuevoNombre, nuevo.getName());
    }
    @Test
    void deleteUserById() {
        Usuario usuarioEsperado = new Usuario("alejandro", "alejandro", "valencia", "dkhades", "correo");
        repository.deleteByUserId(usuarioEsperado.getUserId());
        Mockito.verify(repository, Mockito.times(1)).deleteByUserId(usuarioEsperado.getUserId());}
    @Test
    void delete() {
        Usuario usuario = new Usuario(2,"alejandro","valencia","12345","loki","3143830911",
                "@gmail.com","cc","1012");
        repository.deleteById(usuario.getId());
        Mockito.verify(repository,Mockito.times(1)).deleteById(usuario.getId());}
}