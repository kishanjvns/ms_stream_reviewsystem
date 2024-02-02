package com.tech.kj.service;

import com.tech.kj.domain.CommentEntity;
import com.tech.kj.domain.VideoReactionEntity;
import com.tech.kj.domain.mapper.VideoCommentMapper;
import com.tech.kj.domain.mapper.VideoReactionMapper;
import com.tech.kj.repository.VideoCommentRepository;
import com.tech.kj.repository.VideoReactionRepository;
import com.tech.kj.web.dto.CommentRequestDto;
import com.tech.kj.web.dto.VideoReactionRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoCommentServiceImpl implements VideoCommentService{
    private final VideoCommentRepository commentRepository;
    private final VideoCommentMapper mapper;
    @Override
    public String save(CommentRequestDto request) {
        log.info("invoked save method with "+request);
        CommentEntity saveEntity= commentRepository.save(mapper.dtoToEntity(request));
        log.info("video reaction saved with id: {}",saveEntity.getId());
        return saveEntity.getId();
    }

    @Override
    public List<CommentRequestDto> getCommentsByVideoId(String videoId,Integer pageNumber,Integer pageSize) {
        log.info("invoked getLikeDisLikeReactionByVideoId with param videoId: {}, pageNumber: {}, pageSize: {}",videoId,pageNumber,pageSize);
        List<CommentRequestDto> responsePageRecord;
        if(!Objects.isNull(pageNumber) && !Objects.isNull(pageSize)){
            Page<CommentEntity>  pageRecord = commentRepository.getCommentByVideoIdWithPage(videoId, PageRequest.of(pageNumber,pageSize));
            responsePageRecord=  pageRecord.stream().map(mapper::entityToDto).collect(Collectors.toList());
        }else{
            List<CommentEntity> records = commentRepository.getCommentVideoId(videoId);
            responsePageRecord=  records.stream().map(mapper::entityToDto).collect(Collectors.toList());
        }
        log.info("returning list of like and deslike response from reposiotry: {} ",responsePageRecord);
        return responsePageRecord;
    }

    @Override
    public List<CommentRequestDto> getCommentsByParentCommentId(String parentCommentId,Integer pageNumber,Integer pageSize){
        log.info("invoked getCommentsByParentCommentId: {}",parentCommentId);
        Page<CommentEntity>  pageRecord = commentRepository.getCommentsByParentCommentId(parentCommentId, PageRequest.of(pageNumber,pageSize));
        log.info("fetched record size is :{} ",null!=pageRecord?pageRecord.getSize():0);
        List<CommentRequestDto> responsePageRecord=  pageRecord.stream().map(mapper::entityToDto).collect(Collectors.toList());
        return  responsePageRecord;
    }
}
