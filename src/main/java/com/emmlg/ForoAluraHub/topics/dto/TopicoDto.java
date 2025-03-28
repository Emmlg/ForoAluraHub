package com.emmlg.ForoAluraHub.topics.dto;

import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TopicoDto {

    private Long topicoId;
    private String title;
    private String message;
    private ForumStatus status;
    private String author;
    private Date creationDate;
    private Date updateDate;
    private String CursoName;
    private String CursoCategory;
    private List<Reply> answers;


}
