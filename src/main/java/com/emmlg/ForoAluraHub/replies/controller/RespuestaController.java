package com.emmlg.ForoAluraHub.replies.controller;

import com.emmlg.ForoAluraHub.replies.dto.RespuestaDto;
import com.emmlg.ForoAluraHub.replies.service.RespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/respuesta")
public class RespuestaController {
    @Autowired
    private final RespuestaService respuestaService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody RespuestaDto respuestadto) {
        return ResponseEntity.ok(respuestaService.addRespuesta(respuestadto));
    }

    @GetMapping("/readByUsr/{idUsuario}")
    public ResponseEntity readByUsr(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(respuestaService.getRespuestaById(idUsuario));
    }

    @PutMapping("/update/{idRespuesta}")
    public ResponseEntity update(@PathVariable long idRespuesta, @RequestBody RespuestaDto respuestadto) {
        //pedir el id usuario y la respuesta
        return ResponseEntity.ok(respuestaService.updateRespuesta(respuestadto, idRespuesta));
    }
    @DeleteMapping("delete/{idrespuesta}")
    // pedir id usuario y respuesta
    public ResponseEntity delete(@PathVariable Long idrespuesta) {
        return ResponseEntity.ok(respuestaService.deleteRespuesta(idrespuesta));
    }
}
