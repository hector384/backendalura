package com.project.alura.controller;

import com.project.alura.entity.Usuario;
import com.project.alura.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://0.0.0.0/0:0000")
@RequestMapping("/user")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @PostMapping("/new")
    public ResponseEntity<Usuario> NewUser (@RequestBody @Valid Usuario usuario){

        return new ResponseEntity<>(usuarioService.NewUser(usuario),
                HttpStatus.CREATED
        );
    }
}
