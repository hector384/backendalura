package com.project.alura.DTO;

public record UsuarioDto(

        Long id,

        String nombre,
        String correo,
        String contraseña,
        String perfiles

) {


}
