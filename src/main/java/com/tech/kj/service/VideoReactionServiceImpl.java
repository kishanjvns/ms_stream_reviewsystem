package com.tech.kj.service;

import com.tech.kj.domain.VideoReactionEntity;
import com.tech.kj.domain.mapper.VideoReactionMapper;
import com.tech.kj.repository.VideoReactionRepository;
import com.tech.kj.web.dto.VideoReactionRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoReactionServiceImpl implements VideoReactionService{
    private final VideoReactionRepository videoReactionRepository;
    private final VideoReactionMapper mapper;
    @Override
    public String save(VideoReactionRequestDto request) {
        log.info("invoked save method with "+request);
        VideoReactionEntity saveEntity= videoReactionRepository.save(mapper.dtoToEntity(request));
        log.info("video reaction saved with id: {}",saveEntity.getId());
        return saveEntity.getId();
    }

    @Override
    public List<VideoReactionRequestDto> getLikeDisLikeReactionByVideoId(String videoId,Integer pageNumber,Integer pageSize) {
        log.info("invoked getLikeDisLikeReactionByVideoId with param videoId: {}, pageNumber: {}, pageSize: {}",videoId,pageNumber,pageSize);
        List<VideoReactionRequestDto> responsePageRecord= null;
        if(!Objects.isNull(pageNumber) && !Objects.isNull(pageSize)){
            Page<VideoReactionEntity> pageRecord = videoReactionRepository.getLikeDisLikeReactionByVideoId(videoId, PageRequest.of(pageNumber,pageSize));
            responsePageRecord = pageRecord.stream().map(mapper::entityToDto).collect(Collectors.toList());
        }else{
            List<VideoReactionEntity>  record = videoReactionRepository.getLikeDisLikeReactionByVideoId(videoId);
            responsePageRecord =  record.stream().map(mapper::entityToDto).collect(Collectors.toList());
        }
        log.info("returning list of like and deslike response from reposiotry: {} ",responsePageRecord);
        return responsePageRecord;
    }


}
