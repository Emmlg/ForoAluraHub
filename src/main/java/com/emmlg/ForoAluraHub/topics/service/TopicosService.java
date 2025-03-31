package com.emmlg.ForoAluraHub.topics.service;

import com.emmlg.ForoAluraHub.Exceptions.TopicoDuplicadoException;
import com.emmlg.ForoAluraHub.Exceptions.TopicosExceptions;
import com.emmlg.ForoAluraHub.curso.dto.TopicoAutorCursoDto;
import com.emmlg.ForoAluraHub.topics.dto.TopicoDto;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicosService  {

    /*implements ITopicosService
    private final TopicosRepository topicosRepository;
  //  private final UsuarioRepository usuarioRepository;


/* REGLAS PARA AGREGAR TOPICOS
    - tener todo los elementos de topicos
    - solo incluir id autor,idcurso
    - no tener titulos o mensajes duplicados
    - respuesta opcional pero si tiene con autor que es username pero internamente unimos a su id_usuario
    - el curso debe de existir en la base de datos o crearlo con la categoria pero se controla con los enums



@Override
public TopicoAutorCursoDto addTopico(TopicoAutorCursoDto topicoAutorCursoDto) {

System.out.println("Buscando usuario con ID: " + topicoAutorCursoDto.getIdAutor());

// 1. Verificar si el usuario existe por ID
    Usuario autor = usuarioRepository.findById(topicoAutorCursoDto.getIdAutor())
            .orElseThrow(() -> new TopicosExceptions("El usuario no existe"));
    // 2. validar no mismo titulo o mensaje
    if(topicosRepository.existsByTitulo(topicoAutorCursoDto.getTitulo())){
        throw new TopicosExceptions("El Titulo ya existe");
    }

    if(topicosRepository.existsByMensaje(topicoAutorCursoDto.getMensaje())){
        throw new TopicosExceptions("El Mensaje ya existe");
    }

    //3. pasar los datos de dto a topicos

    Topic topico = new Topic();
    topico.setTitulo(topicoAutorCursoDto.getTitulo());
    topico.setMensaje(topicoAutorCursoDto.getMensaje());
    topico.setFechaCreacion(LocalDate.now()); // Asegurar formato correcto
    topico.setStatus(ForumStatus.OPEN);
    topico.setAuthor(autor); // Se asigna el usuario recuperado

    // 4. Validar y asignar curso (se persiste automáticamente por `CascadeType.PERSIST`)
    if (topicoAutorCursoDto.getCurso() == null) {
        throw new TopicosExceptions("El curso no puede ser nulo");
    }
    topico.setCursoName(topicoAutorCursoDto.getCurso());

    // 5. Guardar el Topico
    topicosRepository.save(topico);

return topicoAutorCursoDto;
}

    /* READ - To DO
     * - read all topics with it's own answer : done
     * - specific topic id : done
     * agregar paginacion :
     * agregar filtro de busquedas :


    @Override
    public List<Topic> getAllTopicos() {
        return topicosRepository.findAll();
    }

    @Override
    public Topic getTopicoById(Long id) {
        return topicosRepository.findById(id)
                .orElseThrow(() -> new TopicosExceptions("No existe el tópico con ID: " + id));
    }

    /* UPDATE TO-DO
    * - verificar si existe el id topico : Done
    * - verificar no mismo titulo o mensaje : Done
    * - poder actualizar las respuestas
    * desde topicos(esto sera muy complicado si tiene muchas respuestas) :
    * - crear mejor su propio enpoint update respuesta
    * relacionarlo con el idtopicos :
    * -
    @Override
    public TopicoDto updateTopico(TopicoDto topicoDto, Long idTopico) {
        // 1. Verificar si el tópico existe
        Topic topicoExistente = topicosRepository.findById(idTopico)
                .orElseThrow(() -> new TopicosExceptions("No existe el tópico con ID: " + idTopico));
        if (topicosRepository.existsByTituloAndMensaje(
                topicoDto.getTitulo(), topicoDto.getMensaje())) {
            throw new TopicoDuplicadoException("Este tópico ya existe con el mismo título y mensaje.");
        }
        // 2. Actualizar solo los campos que el cliente proporciona
        if (topicoDto.getTitulo() != null && !topicoDto.getTitulo().isEmpty()) {
            topicoExistente.setTitulo(topicoDto.getTitulo());
        }
        if (topicoDto.getMensaje() != null && !topicoDto.getMensaje().isEmpty()) {
            topicoExistente.setMensaje(topicoDto.getMensaje());
        }
        if (topicoDto.getStatus() != null) {
            topicoExistente.setStatus(topicoDto.getStatus());
        }
        // Si necesitas otros campos, actualiza aquí según lo que recibas en el objeto topico.

        // 3. Guardar el tópico actualizado
         topicosRepository.save(topicoExistente);
        return topicoDto;
    }

    /*DELETE To-Do
    * - eliminar un topico y sus datos relacionados:
    * - eliminar un topico desde una respuesta:

    @Override
    public void deleteTopico(long idtopico) {
        if (!topicosRepository.existsById(idtopico)){
            throw new TopicosExceptions("El tópico con ID " + idtopico + " no existe.");
        }
        topicosRepository.deleteById(idtopico); // Elimina el tópico
    }*/

}
