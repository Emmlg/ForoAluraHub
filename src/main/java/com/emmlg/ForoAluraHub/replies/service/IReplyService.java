package com.emmlg.ForoAluraHub.replies.service;

import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.emmlg.ForoAluraHub.util.GeneralRespose;

import java.util.List;

public interface IReplyService {

    ReplyDto addReply(ReplyDto replyDto);

    List<ReplyDto> addReplies(List<ReplyDto> replyDtos);
    
    ReplyDto updateReply(ReplyDto replyDto, Integer replyId);

    GeneralRespose deleteReply(Integer ReplyId);

}
