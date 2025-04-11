package com.emmlg.ForoAluraHub.replies.controller;

import com.emmlg.ForoAluraHub.replies.dto.ReplyDto;
import com.emmlg.ForoAluraHub.replies.service.ReplyService;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "replies", description = "Operations related to replies of a post")
@RestController
@AllArgsConstructor
@RequestMapping("${api.prefix}/replies")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Reply created successfully")
    public ReplyDto createReplyPost(@RequestBody ReplyDto replyDto) {
        return replyService.addReply(replyDto);
    }

    @PostMapping("list")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Reply created successfully")
    public List<ReplyDto> createReplyPostList(@RequestBody List<ReplyDto> replyDto) {
        return replyService.addReplies(replyDto);
    }


    @PutMapping("/{replyId}")
    public ReplyDto updateReply(@PathVariable Integer replyId, @RequestBody ReplyDto replyDto) {
        return replyService.updateReply(replyDto, replyId);
    }

    @DeleteMapping("/{replyId}")
    public GeneralResponse delete(@PathVariable Integer replyId) {

        return replyService.deleteReply(replyId);
    }
}
