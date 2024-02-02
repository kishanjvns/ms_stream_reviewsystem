package com.tech.kj.web.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoReactionRequestDto {
    private String userId;
    private String videoId;
    private Boolean isLiked;
}
