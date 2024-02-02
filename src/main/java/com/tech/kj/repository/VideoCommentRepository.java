package com.tech.kj.repository;

import com.tech.kj.domain.CommentEntity;
import com.tech.kj.domain.VideoReactionEntity;
import com.tech.kj.web.dto.CommentRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoCommentRepository extends JpaRepository<CommentEntity,String> {

    @Query("select vr from CommentEntity vr where vr.videoId=:videoId")
    public Page<CommentEntity> getCommentByVideoIdWithPage(@Param("videoId") String videoId, Pageable pageable);

    @Query("select vr from CommentEntity vr where vr.videoId=:videoId")
    public List<CommentEntity> getCommentVideoId(@Param("videoId") String videoId);

    @Query("select vr from CommentEntity vr where vr.parentCommentCommentId=:parentCommentCommentId")
    public Page<CommentEntity> getCommentsByParentCommentId(@Param("parentCommentCommentId") String parentCommentCommentId, Pageable pageable);
}
