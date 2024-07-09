package com.project.alura.service;

import com.project.alura.DTO.TopicosDto;
import com.project.alura.entity.Topico;
import com.project.alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoServiceImplementation implements  TopicoService
{

    @Autowired
    TopicoRepository topicoRepository;
    @Override
    public Topico NewTopico(Topico topico) {
        topico.setFechaCreacion(LocalDateTime.now());
        if (topicoRepository.existsByTitulo(topico.getTitulo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title already exists");
        }
        if (topicoRepository.existsByMensaje(topico.getMensaje())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message already exists");
        }
        return topicoRepository.save(topico);
    }

    @Override
    public List<Topico> getAllTopics() {

        return topicoRepository.findAll();
    }

    @Override
    public List<TopicosDto> getAllTopicsDTO() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    @Override
    public Optional<TopicosDto> getTopicosById(long id) {
        return topicoRepository.findById((int) id).map(this::convertToDto);
    }

    @Override
    public boolean deleteTopicById(int id) {
        return getTopicosById(id).map(topico ->
        {
            topicoRepository.deleteById(id);
            return true;
        }).orElse(false);

    }

    @Override
    public Topico updateTopic(Long id, Topico topico) {
        Optional<Topico> optionalTopico = topicoRepository.findById(Math.toIntExact(id));
        if (optionalTopico.isPresent()) {
            Topico existingTopico = optionalTopico.get();
            existingTopico.setTitulo(topico.getTitulo());
            existingTopico.setMensaje(topico.getMensaje());
            existingTopico.setAutor(topico.getAutor());
            existingTopico.setCurso(topico.getCurso());
            existingTopico.setStatus(topico.getStatus());
            return topicoRepository.save(existingTopico);
        } else {
            // Opcional: Manejar el caso en el que no se encuentra el tópico
            throw new RuntimeException("Tópico no encontrado con id " + id);
        }
    }


    private TopicosDto convertToDto(Topico topico) {
        return new TopicosDto(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
