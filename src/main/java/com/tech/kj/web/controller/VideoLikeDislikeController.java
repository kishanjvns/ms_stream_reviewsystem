package com.tech.kj.web.controller;

import com.tech.kj.service.VideoReactionService;
import com.tech.kj.web.dto.VideoReactionRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review/api/v1/reaction")
@RequiredArgsConstructor
@Slf4j
public class VideoLikeDislikeController {
    private final VideoReactionService videoReactionService;
    @PostMapping
    public ResponseEntity saveLikeDisLikeReaction(@RequestBody VideoReactionRequestDto requestDto){
        log.info("post api invoked to store the like and dislike: {}",requestDto);
        long savedId = videoReactionService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{videoId}")
    public ResponseEntity<List<VideoReactionRequestDto>> getVideoLikeDisLikeByVideId(@PathVariable("videoId") String videoId, @Param("pageNumber")Integer pageNumber, @Param("pageSize")Integer pageSize ){
       log.info("get like and dislike api invoked by videId: {}",videoId);
        return ResponseEntity.ok(videoReactionService.getLikeDisLikeReactionByVideoId(videoId,pageNumber,pageSize));
    }


}
