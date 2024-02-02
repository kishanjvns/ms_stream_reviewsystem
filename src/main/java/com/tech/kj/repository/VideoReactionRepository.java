package com.tech.kj.repository;

import com.tech.kj.domain.VideoReactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoReactionRepository extends JpaRepository<VideoReactionEntity,String> {
    @Query("select vr from VideoReactionEntity vr where vr.videoId=:videoId")
    public Page<VideoReactionEntity> getLikeDisLikeReactionByVideoId(@Param("videoId") String videoId, Pageable pageable);

    @Query("select vr from VideoReactionEntity vr where vr.videoId=:videoId")
    public List<VideoReactionEntity> getLikeDisLikeReactionByVideoId(@Param("videoId") String videoId);
}
