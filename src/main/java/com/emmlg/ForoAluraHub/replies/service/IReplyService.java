package com.emmlg.ForoAluraHub.replies.service;

import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.util.GeneralResponse;

import java.util.List;

public interface IReplyService {

    ReplyDto addReply(ReplyDto replyDto);

    List<ReplyDto> addReplies(List<ReplyDto> replyDtos);
    
    ReplyDto updateReply(ReplyDto replyDto, Integer replyId);

    GeneralResponse deleteReply(Integer ReplyId);

}
