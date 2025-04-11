package com.emmlg.ForoAluraHub.replies.service;

import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.emmlg.ForoAluraHub.replies.repository.ReplyRepository;
import com.emmlg.ForoAluraHub.topics.repository.TopicRepository;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.emmlg.ForoAluraHub.common.constants.Messages.*;
import static com.emmlg.ForoAluraHub.util.ConvertDtoToEntity.convertDtoToEntity;
import static com.emmlg.ForoAluraHub.util.ConvertEntityToDto.convertEntityToDto;


@Service
@AllArgsConstructor
public class ReplyService implements IReplyService {

    private final ReplyRepository replyRepository;
    private final TopicRepository topicRepository;

    @Override
    @Transactional
    public ReplyDto addReply(ReplyDto replyDto) {
        var existingTopic = topicRepository.findByTitle(replyDto.getTopicTitle());
        if (existingTopic == null) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("Topic not found", "maybe not created yet"),
                    TOPIC_NOT_FOUND,
                    TOPIC_SEARCH
            );
        }
        Reply reply = convertDtoToEntity(replyDto);
        existingTopic.getReplies().add(reply);

        return convertEntityToDto(replyRepository.save(reply));
    }

    @Override
    @Transactional
    public List<ReplyDto> addReplies(List<ReplyDto> replyDtos) {
        return replyDtos.stream()
                .map(this::addReply)
                .toList();
    }


    @Override
    @Transactional
    public ReplyDto updateReply(ReplyDto replyDto, Integer replyId) {
        var existingReply = replyRepository.findById(replyId.longValue())
                .orElseThrow(() -> new ForoAluraHubExceptions(
                        HttpStatus.NOT_FOUND,
                        List.of("Reply not found", "maybe it was deleted"),
                        REPLY_NOT_FOUND,
                        REPLY_SEARCH
                ));


        existingReply.setMessage(replyDto.getReplyMessage());
        existingReply.setUpdateDate(replyDto.getUpdateDate());

        return convertEntityToDto(replyRepository.save(existingReply));
    }


    @Override
    @Transactional
    public GeneralResponse deleteReply(Integer replyId) {
        var existingReply = replyRepository.findById(replyId.longValue())
                .orElseThrow(() -> new ForoAluraHubExceptions(
                        HttpStatus.NOT_FOUND,
                        List.of("Reply not found", "maybe it was deleted"),
                        REPLY_NOT_FOUND,
                        REPLY_SEARCH
                ));
        replyRepository.delete(existingReply);
        return GeneralResponse.builder()
                .message(REPLY_DELETED)
                .status(HttpStatus.OK)
                .build();
    }
}
