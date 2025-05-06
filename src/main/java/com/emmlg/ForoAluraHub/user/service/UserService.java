package com.emmlg.ForoAluraHub.user.service;

import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.topics.dto.TopicDto;
import com.emmlg.ForoAluraHub.user.dto.UserDto;
import com.emmlg.ForoAluraHub.user.modelo.User;
import com.emmlg.ForoAluraHub.user.repository.UserRepository;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.emmlg.ForoAluraHub.common.constants.Messages.*;
import static com.emmlg.ForoAluraHub.util.ConvertDtoToEntity.convertDtoToEntity;
import static com.emmlg.ForoAluraHub.util.ConvertEntityToDto.convertEntityToDto;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        boolean userExists = userRepository.existsUserByUserName((userDto.getUserName()));

        if (userExists)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of(USER_ALREADY_EXISTS, "El usuario Ya Existe"),
                    "User found with username: " + userDto.getUserName(),
                    USER_SEARCH);

        return convertEntityToDto(userRepository.save(convertDtoToEntity(userDto)));
    }

    @Override
    public UserDto getUserById(Integer id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ForoAluraHubExceptions(
                        HttpStatus.NOT_FOUND,
                        List.of("User not found with id: " + id, "El usuario problamentente no existe"),
                        USER_NOT_FOUND,
                        USER_SEARCH));
        return convertEntityToDto(user);
    }

    @Override
    public UserDto getUserByUserName(String userName) {
        var user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new ForoAluraHubExceptions(
                        HttpStatus.NOT_FOUND,
                        List.of("User not found with username : " + userName, "El usuario problamentente no existe"),
                        USER_NOT_FOUND,
                        USER_SEARCH));
        return convertEntityToDto(user);
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        var existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ForoAluraHubExceptions(
                        HttpStatus.NOT_FOUND,
                        List.of("User not found with id: " + id, "El usuario problamentente no existe"),
                        USER_NOT_FOUND,
                        USER_SEARCH));

        existingUser.setUserName(userDto.getUserName());
        existingUser.setUserEmail(userDto.getUserEmail());
        existingUser.setUserPassword(userDto.getUserPassword());
        existingUser.setUserRole(userDto.getUserRole());
        User userUpdated = userRepository.save(existingUser);
        return convertEntityToDto(userUpdated);
    }

    @Override
    public GeneralResponse deleteUser(Integer id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ForoAluraHubExceptions(
                        HttpStatus.NOT_FOUND,
                        List.of("User not found with id: " + id, "El usuario problamentente no existe"),
                        USER_NOT_FOUND,
                        USER_SEARCH));
        return GeneralResponse.builder()
                .message(USER_DELETED)
                .status(HttpStatus.OK)
                .build();

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .userEmail(user.getUserEmail())
                        .userPassword(user.getUserPassword())
                        .userRole(user.getUserRole())
                        .topicOrReplyList(user.getTopics().stream()
                                .map(topic -> TopicDto.builder()
                                        .topicoId(topic.getTopicId())
                                        .title(topic.getTitle())
                                        .message(topic.getMessage())
                                        .status(topic.getStatus())
                                        .creationDate(topic.getCreationDate())
                                        .updateDate(topic.getUpdateDate())
                                        .CursoName(topic.getCourse().getCourseName())
                                        .CursoCategory(topic.getCourse().getCategory().getCategoryName())
                                        .replies(topic.getReplies().stream()
                                                .map(reply -> ReplyDto.builder()
                                                        .replyId(reply.getReplyId())
                                                        .replyMessage(reply.getMessage())
                                                        .creationDate(reply.getCreationDate())
                                                        .authorResponse(reply.getAuthorResponse().getUserName()) // Solo si `reply.getUser()` no es null
                                                        .build())
                                                .collect(Collectors.toList()))
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

}
