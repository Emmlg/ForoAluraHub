package com.emmlg.ForoAluraHub.replies.modelo;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Replies")
public class Reply {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reply")
    private Integer replyId;

    @Column(name = "reply_message", unique = true, length = 3000)
    private String message;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "update_date")
    private LocalDate updateDate;


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
