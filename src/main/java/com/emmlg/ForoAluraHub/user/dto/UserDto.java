package com.emmlg.ForoAluraHub.user.dto;

import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.emmlg.ForoAluraHub.topics.modelo.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Builder
public class UserDto implements Serializable {

    @Schema(name = "User Id", description = "User id", example = "1")
    private Integer userId;

    @NotBlank
    @Schema(name = "User Name", description = "User name", example = "JohnDoe")
    private String userName;

    @NotBlank
    @Schema(name = "Email", description = "User email", example = "abc2@gmail.com")
    private String userEmail;

    @NotBlank
    @Schema(name = "Password", description = "User password", example = "123456")
    private String userPassword;

    @NotBlank
    @JsonProperty("user_Role")
    @Schema(name = "rol", description = "user rol", example = "ADMIN/ CLIENT / STUDENT")
    private String userRole;

    @Schema(name = "Topics or Replies", description = "Topics or replies created by the user")
    private List<Object> topicOrReplyList;
}
