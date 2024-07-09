package com.project.alura.service;

import com.project.alura.DTO.TopicosDto;
import com.project.alura.entity.Topico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TopicoService {



    public Topico NewTopico(Topico topico) ;
    public List<Topico> getAllTopics();
    public List<TopicosDto> getAllTopicsDTO();

    Optional<TopicosDto> getTopicosById(long id);

    public boolean deleteTopicById (int id);


    Topico updateTopic(Long id, Topico topico);
}



