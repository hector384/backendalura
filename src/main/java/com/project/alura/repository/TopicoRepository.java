package com.project.alura.repository;


import com.project.alura.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer> {

    boolean existsByTitulo(String titulo);
    boolean existsByMensaje(String mensaje);

}
