package com.emmlg.ForoAluraHub.topics.service;

import com.emmlg.ForoAluraHub.curso.dto.TopicoAutorCursoDto;
import com.emmlg.ForoAluraHub.topics.dto.TopicoDto;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;

import java.util.List;

public interface ITopicosService {

    TopicoAutorCursoDto addTopico(TopicoAutorCursoDto topicoAutorCursoDto);
    List<Topic> getAllTopicos(); // solo admin
    Topic getTopicoById(Long id);//solo admin -incluye respuestas
    TopicoDto updateTopico(TopicoDto topicoDto, Long idTopico);
    void deleteTopico(long idtopico);

}
