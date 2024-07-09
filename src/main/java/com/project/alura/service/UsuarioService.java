package com.project.alura.service;


import com.project.alura.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    public Usuario NewUser(Usuario usuario) ;
}
