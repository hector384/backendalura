package com.project.alura.repository;
import com.project.alura.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsBynombre(String nombre);
    boolean existsBycorreo(String correo);
    Usuario findByCorreo(String correo);
}

