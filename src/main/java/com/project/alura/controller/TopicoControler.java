package com.project.alura.controller;


import com.project.alura.DTO.TopicosDto;
import com.project.alura.entity.Topico;
import com.project.alura.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://0.0.0.0/0:0000")
@RequestMapping("/topicos")

public class TopicoControler {

    @Autowired
    TopicoService topicoService;



    @PostMapping("/new")
    public ResponseEntity<Topico> NewTopico (@RequestBody @Valid Topico topico){

        return new ResponseEntity<>(topicoService.NewTopico(topico),
                HttpStatus.CREATED
        );
    }
    @GetMapping
    public ResponseEntity<List<Topico>> getTopicos(){
        return new ResponseEntity<>(topicoService.getAllTopics(),HttpStatus.OK);

    }
    @GetMapping("/findall")
    public ResponseEntity<List<TopicosDto>> getTopics(){
        return new ResponseEntity<>(topicoService.getAllTopicsDTO(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TopicosDto> getTopicosById(@PathVariable("id") Long id) {
        return topicoService.getTopicosById(id)
                .map(topicoDto -> new ResponseEntity<>(topicoDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClientbyID (@PathVariable("id") int id){
        if(topicoService.deleteTopicById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody Topico topico) {
        Topico updatedTopico = topicoService.updateTopic(id, topico);
        return new ResponseEntity<>(updatedTopico, HttpStatus.OK);
    }
}
