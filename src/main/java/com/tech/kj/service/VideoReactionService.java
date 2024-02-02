package com.tech.kj.service;

import com.tech.kj.web.dto.VideoReactionRequestDto;

import java.util.List;

public interface VideoReactionService {
    public String save(VideoReactionRequestDto request);
    public List<VideoReactionRequestDto> getLikeDisLikeReactionByVideoId(String videoId,Integer pageNumber,Integer pageSize);
}
