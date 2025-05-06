package com.emmlg.ForoAluraHub.topics.controller;


import com.emmlg.ForoAluraHub.curso.dto.TopicoAutorCursoDto;
import com.emmlg.ForoAluraHub.topics.dto.TopicoDto;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import com.emmlg.ForoAluraHub.topics.service.TopicosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/topicos")
@RequiredArgsConstructor
public class TopicosController {

@Autowired
private final TopicosService topicosService;

// CREATE
@PostMapping("/add")
public ResponseEntity<?> addTopico(@RequestBody TopicoAutorCursoDto topicoAutorCursoDto) {

    try {
        System.out.println("Buscando usuario con ID: " + topicoAutorCursoDto.getIdAutor());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(topicosService.addTopico(topicoAutorCursoDto));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}



    @GetMapping("/read")
    public ResponseEntity<List<Topic>> getAllTopicos() {


        List<Topic> topicos = topicosService.getAllTopicos();
        return ResponseEntity.ok(topicos);
    }


    @GetMapping("/read/{id_topicos}")
    public ResponseEntity<Topic> readTopicos(@PathVariable Long id_topicos) {
        Topic topico = topicosService.getTopicoById(id_topicos);
        return ResponseEntity.ok(topico);
    }


    /* UPDATE */
    @PutMapping("/update/{idTopico}")
    public ResponseEntity<?> updateTopico(@RequestBody TopicoDto topicoDto, @PathVariable Long idTopico) {
        // 1. verificar si existe, esto lo hacemos en el service

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
            .body(topicosService.updateTopico(topicoDto,idTopico));
        }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        // Aquí iría la lógica para actualizar el tópico en la base de datos


    }



    @DeleteMapping("/delete/{idtopic}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long idtopic) {
        // Verificar si el tópico existe antes de eliminarlo
        topicosService.deleteTopico(idtopic);

        // Responder con 204 No Content si la eliminación fue exitosa
        return ResponseEntity.noContent().build();
    }


}
