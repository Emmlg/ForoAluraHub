package com.emmlg.ForoAluraHub.replies.service;

import com.emmlg.ForoAluraHub.replies.dto.RespuestaDto;
import com.emmlg.ForoAluraHub.replies.modelo.Reply;

public interface IRespuesta {

    RespuestaDto addRespuesta(RespuestaDto respuestaDto);
    Reply getRespuestaById(Long id);
    RespuestaDto updateRespuesta(RespuestaDto respuestaDto,long idrespuesta);
    String deleteRespuesta(Long idRespuesta);

}
