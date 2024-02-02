package com.tech.kj.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentRequestDto {
    private String videoId;
    private String userId;
    private String parentCommentCommentId;
    private String commentText;
}