package com.emmlg.ForoAluraHub.replies.dto;

import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReplyDto implements Serializable {


    @Schema(description = "ID del topico")
    private Integer replyId;

    @Schema(description = "Mensaje de la respuesta")
    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 3000, message = "El mensaje no puede exceder los 3000 caracteres")
    @JsonProperty("message")
    private String replyMessage;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de creacion de la respuesta")
    @JsonProperty("creation_Date")
    private LocalDate creationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de actualizacion de la respuesta")
    @JsonProperty("update_Date")
    private LocalDate updateDate;

    @Schema(description = "Nombre del topico")
    @NotBlank
    @JsonProperty("topic_Title")
    private String topicTitle;

}
