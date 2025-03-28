package com.emmlg.ForoAluraHub.topics.modelo;


import com.emmlg.ForoAluraHub.curso.modelo.Course;
import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_topic")
    private long topicId;

    @Column(name="topic_title")
    private String title;

    @Column(name ="post_message", length = 1000) // longitud maximo de 1000
    private String message;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name="status")
    private String status;

    /* relacion.   topicos(M) --> (1)curso
     * es Unidireccecional :
     * - el topico debe de ver a qué curso pertenece
     */
     @ManyToOne(cascade = CascadeType.PERSIST)
     @JoinColumn(name = "fk_cursId")
     private Course cursoName;

     /* relacion Topicos:1-->M: Respuesta
     * relacion unidireccional topico a respuesta
     * borrara toda las respuesta al borrar el topico
     *  si borro una respues no eliminara el topico
     */
     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
     @JoinColumn(name = "fk_topicId")
     private List<Reply> replies;

    // PENDIENTE
    /* relacion Topicos(M)-->(1)Usuario
    * muchos topicos pueden tener un usuario
    * un usuario puede eliminar topicos, pero topicos no
    * al ver el usuario puedo ver sus topicos
    */

    /*@JsonIgnore  // Evita la serialización recursiva en el lado del usuario
    @ManyToOne
    @JoinColumn(name="fk_userId")
    private Usuario author;*/


}
