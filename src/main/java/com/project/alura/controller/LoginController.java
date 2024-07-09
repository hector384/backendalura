package com.project.alura.controller;

import com.project.alura.DTO.DatosLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://0.0.0.0/0:0000")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticaUsuario(@RequestBody @Valid DatosLogin datosLogin){
        Authentication token = new UsernamePasswordAuthenticationToken( datosLogin.login(), datosLogin.clave());
        authenticationManager.authenticate(token);
        return null;
    }
}
