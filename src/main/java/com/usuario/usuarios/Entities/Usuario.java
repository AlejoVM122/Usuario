package com.usuario.usuarios.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

    @Data
    @Table
    @Entity
    public class Usuario {
        @Id
        @NonNull
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;
        @NonNull
        @Column(name = "nombre")
        private String name;
        @Column(name = "apellido")
        private String lastName;
        @NonNull
        @Column(name = "password")
        private String password;
        @Column(name = "userId",updatable = false,unique = true)
        @NonNull
        private String userId;
        @Column(name = "teléfono")
        private String telefono;
        @NonNull
        @Column(name = "correo")
        private String emailAddress;
        @Column(name = "tipo_de_documento")
        private String tipoDeDocumento;
        @Column(name = "documento")
        private String documento;
        public Usuario(@NonNull int id, @NonNull String name, @NonNull String lastName, @NonNull String password, @NonNull String userId,
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
        public Usuario(@NonNull String name, @NonNull String lastName, @NonNull String password,@NonNull String userId, @NonNull String emailAddress) {
            this.name = name;
            this.lastName = lastName;
            this.password = password;
            this.userId=userId;
            this.emailAddress = emailAddress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Usuario usuario)) return false;
            return getId().equals(usuario.getId()) && getName().equals(usuario.getName()) && Objects.equals(getLastName(), usuario.getLastName()) && getPassword().equals(usuario.getPassword()) && getUserId().equals(usuario.getUserId()) && Objects.equals(getTelefono(), usuario.getTelefono()) && getEmailAddress().equals(usuario.getEmailAddress()) && Objects.equals(getTipoDeDocumento(), usuario.getTipoDeDocumento()) && Objects.equals(getDocumento(), usuario.getDocumento());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName(), getLastName(), getPassword(), getUserId(), getTelefono(), getEmailAddress(), getTipoDeDocumento(), getDocumento());
        }
}
