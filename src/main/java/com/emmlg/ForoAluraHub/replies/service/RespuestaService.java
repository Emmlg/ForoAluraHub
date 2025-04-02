package com.emmlg.ForoAluraHub.replies.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RespuestaService {
//implements IRespuesta
//   private final RespuestaRepository respuestaRepository;
    //  private final UsuarioRepository usuarioRepository;
    // private final TopicosRepository topicosRepository;

    /* CREATE To-Do
     * - una respuesta debe tener un usuario :done
     * - debe tener un topico a que relacionarse

     */
//    @Override
//    public RespuestaDto addRespuesta(RespuestaDto respuestaDto) {
//
//        // Verificar si el usuario existe
//        Usuario usuario = usuarioRepository.findById(respuestaDto.getId_usuario())
//                .orElseThrow(() -> new RespuestaExceptions("El usuario no existe o no está presente"));
//
//        // Verificar si el tópico existe
//        Topic topico = topicosRepository.findById(respuestaDto.getId_topico())
//                .orElseThrow(() -> new RespuestaExceptions("El tópico no existe"));
//
//        // Crear y llenar la respuesta
//        Reply respuesta = new Reply();
//        respuesta.setAuthor(usuario);
//        respuesta.setTopico(topico);
//        respuesta.setMessage(respuestaDto.getMessage());
//        respuesta.setFechCreacion(respuestaDto.getFechCreacion());
//        respuesta.setSolution(respuestaDto.isSolution());
//
//        // Guardar la respuesta
//         respuestaRepository.save(respuesta);
//         return respuestaDto;
//    }
//
//
///* READ To-Do
//* - ver las respuestas por el id del usuario
//
// */
//    @Override
//    public Reply getRespuestaById(Long id) {
//
//        return respuestaRepository.findById(id).orElseThrow(
//                () -> new RespuestaExceptions("El respuesta no existe"));
//
//    }
///* UPDATE To-Do
//* - al actualizar la respuesta verificar que existe el usuario
//* - no puede modificar al usuario,solo la respuesta
//
// */
//@Override
//public RespuestaDto updateRespuesta(RespuestaDto respuestaDto, long idrespuesta) {
//
//    // Verificar si existe la respuesta
//    Reply respuesta = respuestaRepository.findById(idrespuesta)
//            .orElseThrow(() -> new RespuestaExceptions("La respuesta no existe"));
//
//    // Verificar si el usuario existe
//    Usuario usuario = usuarioRepository.findById(respuestaDto.getId_usuario())
//            .orElseThrow(() -> new RespuestaExceptions("El usuario no existe o no está presente"));
//
//    // Verificar si el tópico existe
//    Topic topico = topicosRepository.findById(respuestaDto.getId_topico())
//            .orElseThrow(() -> new RespuestaExceptions("El tópico no existe"));
//
//    // Actualizar los campos de la respuesta con los datos proporcionados en el DTO
//    respuesta.setAuthor(usuario);
//    respuesta.setTopico(topico);
//    respuesta.setMessage(respuestaDto.getMessage());
//    respuesta.setFechCreacion(respuestaDto.getFechCreacion());
//    respuesta.setSolution(respuestaDto.isSolution());
//
//    // Guardar la respuesta actualizada
//    respuestaRepository.save(respuesta);
//
//    // Retornar el DTO actualizado
//    return respuestaDto;
//}
//
//
//    /*DELETE To-DO
//* - eliminar la respuesta no el usuario
//* - verificar si existe la respuesta
//
// */
//    @Override
//    public String deleteRespuesta(Long idRespuesta) {
//        if (!usuarioRepository.existsById(idRespuesta))
//            throw new RespuestaExceptions("El respuesta no existe");
//        return "el usuario eliminado exitosamente";
//    }
}
