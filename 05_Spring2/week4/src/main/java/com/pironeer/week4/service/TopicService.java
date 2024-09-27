package com.pironeer.week4.service;

import com.pironeer.week4.mapper.TopicMapper;
import com.pironeer.week4.repository.domain.Topic;
import com.pironeer.week4.dto.request.TopicCreateRequest;
import com.pironeer.week4.dto.request.TopicUpdateRequest;
import com.pironeer.week4.dto.response.TopicResponse;
import com.pironeer.week4.repository.TopicRepository;
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
        LocalDateTime now = LocalDateTime.now();
        // TopicMapper 활용해서 Topic 객체 생성
        Topic topic = TopicMapper.from(request);
        topicRepository.save(topic);
    }

    // Topic ID로 조회
    public TopicResponse findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        return TopicResponse.of(topic);
    }

    // 모든 Topic 조회
    public List<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return topics.stream().map(TopicResponse::of).toList();
    }

    // Topic 업데이트
    public TopicResponse update(TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        if (request.title() != null) topic.setTitle(request.title());
        if (request.content() != null) topic.setContent(request.content());
        topic.setUpdatedAt(LocalDateTime.now());
        topicRepository.save(topic);
        return TopicResponse.of(topic);
    }

    // Topic 삭제
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}