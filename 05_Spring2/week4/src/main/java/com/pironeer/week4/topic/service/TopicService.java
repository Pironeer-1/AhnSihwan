package com.pironeer.week4.topic.service;

import com.pironeer.week4.global.dto.response.result.ListResult;
import com.pironeer.week4.global.dto.response.result.SingleResult;
import com.pironeer.week4.global.exception.CustomException;
import com.pironeer.week4.global.exception.ErrorCode;
import com.pironeer.week4.global.mapper.TopicMapper;
import com.pironeer.week4.global.service.ResponseService;
import com.pironeer.week4.topic.entity.Topic;
import com.pironeer.week4.topic.dto.request.TopicCreateRequest;
import com.pironeer.week4.topic.dto.request.TopicUpdateRequest;
import com.pironeer.week4.topic.dto.response.TopicResponse;
import com.pironeer.week4.topic.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    // 새로운 Topic 저장
    public void save(TopicCreateRequest request) {
        if (request.title() == null || request.title().isBlank()) {
            throw new CustomException(ErrorCode.INVALID_PARAMETER);
        }
        Topic topic = TopicMapper.from(request);
        topicRepository.save(topic);
    }

    // Topic ID로 조회
    public SingleResult<TopicResponse> findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.OBJECT_NOT_FOUND));
        return ResponseService.getSingleResult(TopicResponse.of(topic));
    }

    // 모든 Topic 조회
    public ListResult<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicResponse> list = topics.stream().map(TopicResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    // Topic 업데이트
    public SingleResult<TopicResponse> update(TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new CustomException(ErrorCode.OBJECT_NOT_FOUND));
        Topic updatedTopic = TopicMapper.from(request, topic);
        topicRepository.save(updatedTopic);
        return ResponseService.getSingleResult(TopicResponse.of(updatedTopic));
    }

    // Topic 삭제
    public void deleteById(Long id) {
        if (!topicRepository.findById(id).isPresent()) {
            throw new CustomException(ErrorCode.OBJECT_NOT_FOUND);
        }
        topicRepository.deleteById(id);
    }
}