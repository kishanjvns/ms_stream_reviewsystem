package com.tech.kj.domain.mapper;

import com.tech.kj.domain.VideoReactionEntity;
import com.tech.kj.web.dto.VideoReactionRequestDto;
import org.springframework.stereotype.Component;

@Component
public class VideoReactionMapper {
    public VideoReactionEntity dtoToEntity(VideoReactionRequestDto requestDto){
        return  VideoReactionEntity.builder()
                .videoId(requestDto.getVideoId())
                .userId(requestDto.getUserId())
                .isLiked(requestDto.getIsLiked())
                .build();
    }
    public VideoReactionRequestDto entityToDto(VideoReactionEntity requestDto){
        return  VideoReactionRequestDto.builder()
                .videoId(requestDto.getVideoId())
                .userId(requestDto.getUserId())
                .isLiked(requestDto.getIsLiked())
                .build();
    }
}
