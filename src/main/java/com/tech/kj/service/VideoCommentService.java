package com.tech.kj.service;

import com.tech.kj.web.dto.CommentRequestDto;
import com.tech.kj.web.dto.VideoReactionRequestDto;

import java.util.List;

public interface VideoCommentService {
    public String save(CommentRequestDto request);
    public List<CommentRequestDto> getCommentsByVideoId(String videoId,Integer pageNumber,Integer pageSize);
    public List<CommentRequestDto> getCommentsByParentCommentId(String videoId,Integer pageNumber,Integer pageSize);
}
