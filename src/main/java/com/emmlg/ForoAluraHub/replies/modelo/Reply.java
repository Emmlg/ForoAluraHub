package com.emmlg.ForoAluraHub.replies.modelo;

import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "topic_Replies")
public class Reply {

    // datos de respuesta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reply")
    private long replyId;

    @Column(name = "reply_message", length = 1000) // longitud maximo de 1000
    private String message;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;


    /* Many to one Respuestas(M) --> (1) usuario
    * esto sera bidireccional
    * - usuarios pueden escribir respuesas
    * - usuarios pueden ver quien respondio
    * */
    // datos del usuario que escribio
    /*   @JsonBackReference  // Evita la recursión al serializar el usuario de la respuesta
    @ManyToOne
    @JoinColumn(name = "fk_userId")
    private Usuario author;*/

}
