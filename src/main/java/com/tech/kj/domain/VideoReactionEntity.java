package com.tech.kj.domain;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VideoReactionEntity extends BaseEntity {
    private String userId;
    private String videoId;
    private Boolean isLiked;
}
