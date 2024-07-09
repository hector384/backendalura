package com.project.alura.DTO;

import java.time.LocalDateTime;

public record TopicosDto(
        Long topicoId, String id,
        String titulo,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {

}
