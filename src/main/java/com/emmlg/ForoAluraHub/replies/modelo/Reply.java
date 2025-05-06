package com.emmlg.ForoAluraHub.replies.modelo;

import com.emmlg.ForoAluraHub.user.modelo.User;
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

    @ManyToOne
    @JoinColumn(name = "fk_user_id") // esta es la FK en la tabla de Respuesta
    private User authorResponse;

}
