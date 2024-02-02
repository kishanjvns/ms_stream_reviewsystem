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
public class CommentEntity  extends BaseEntity{
    private String videoId;
    private String userId;
    private String parentCommentCommentId;
    private String commentText;
}
