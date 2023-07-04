package Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
@Data
@Table
@Entity
public class Usuario {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NonNull
    @Column(name = "nombre")
    private String name;
    @NonNull
    @Column(name = "apellido")
    private String lastName;
    @NonNull
    @Column(name = "password")
    private String password;
    @Column(name = "userId")
    @NonNull
    @GeneratedValue
    private int userId;
    @Column(name = "teléfono")
    private String telefono;
    @NonNull
    @Column(name = "correo")
    private String emailAddress;
    @Column(name = "tipo_de_documento")
    private String tipoDeDocumento;
    @Column(name = "documento")
    private String documento;
    public Usuario(@NonNull int id, @NonNull String name, @NonNull String lastName, @NonNull String password, @NonNull int userId,
                   String telefono, @NonNull String emailAddress, String tipoDeDocumento, String documento) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.userId = userId;
        this.telefono = telefono;
        this.emailAddress = emailAddress;
        this.tipoDeDocumento = tipoDeDocumento;
        this.documento = documento;
    }
    public Usuario(){}
    public Usuario(@NonNull String name, @NonNull String lastName, @NonNull String password, @NonNull String emailAddress) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

}
