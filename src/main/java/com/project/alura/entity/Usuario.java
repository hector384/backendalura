package com.project.alura.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "title is mandatory")
    private String nombre;
    @NotBlank(message = "title is mandatory")
    private String correo;
    @NotBlank(message = "title is mandatory")
    private String contrasena;
    @NotBlank(message = "title is mandatory")
    private String perfiles ;


    // getters y setters


    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(String perfiles) {
        this.perfiles = perfiles;
    }
}
