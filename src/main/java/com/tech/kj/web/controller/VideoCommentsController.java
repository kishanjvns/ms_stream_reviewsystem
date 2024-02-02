package com.tech.kj.web.controller;

import com.tech.kj.service.VideoCommentService;
import com.tech.kj.web.dto.CommentRequestDto;
import com.tech.kj.web.dto.VideoReactionRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review/api/v1/comment")
@RequiredArgsConstructor
@Slf4j
public class VideoCommentsController {
    private final VideoCommentService videoCommentService;
    @PostMapping
    public ResponseEntity saveLikeDisLikeReaction(@RequestBody CommentRequestDto requestDto){
        log.info("post api invoked to store the like and dislike: {}",requestDto);
        String savedId = videoCommentService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{videoId}")
    public ResponseEntity<List<CommentRequestDto>> getCommentsByVideoId(@PathVariable("videoId") String videoId, @Param("pageNumber")Integer pageNumber, @Param("pageSize")Integer pageSize ){
       log.info("get like and dislike api invoked by videId: {}",videoId);
        return ResponseEntity.ok(videoCommentService.getCommentsByVideoId(videoId,pageNumber,pageSize));
    }

    @GetMapping("/reply/{commentId}")
    public ResponseEntity<List<CommentRequestDto>> getCommentsByParentCommentId(@PathVariable("commentId") String commentId, @Param("pageNumber")Integer pageNumber, @Param("pageSize")Integer pageSize ){
        log.info("get like and dislike api invoked by videId: {}",commentId);
        return ResponseEntity.ok(videoCommentService.getCommentsByParentCommentId(commentId,pageNumber,pageSize));
    }


}
