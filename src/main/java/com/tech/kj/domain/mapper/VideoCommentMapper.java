package com.tech.kj.domain.mapper;

import com.tech.kj.domain.CommentEntity;
import com.tech.kj.domain.VideoReactionEntity;
import com.tech.kj.web.dto.CommentRequestDto;
import com.tech.kj.web.dto.VideoReactionRequestDto;
import org.springframework.stereotype.Component;

@Component
public class VideoCommentMapper {
    public CommentEntity dtoToEntity(CommentRequestDto requestDto){
        return  CommentEntity.builder()
                .videoId(requestDto.getVideoId())
                .userId(requestDto.getUserId())
                .parentCommentCommentId(requestDto.getParentCommentCommentId())
                .commentText(requestDto.getCommentText())
                .build();
    }
    public CommentRequestDto entityToDto(CommentEntity requestDto){
        return  CommentRequestDto.builder()
                .videoId(requestDto.getVideoId())
                .userId(requestDto.getUserId())
                .parentCommentCommentId(requestDto.getParentCommentCommentId())
                .commentText(requestDto.getCommentText())
                .build();
    }
}
