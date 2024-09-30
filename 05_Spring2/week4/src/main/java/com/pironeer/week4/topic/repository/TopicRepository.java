package com.pironeer.week4.topic.repository;

import com.pironeer.week4.topic.entity.Topic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    private final Map<Long, Topic> topicMap = new HashMap<>();

    // 새로운 Topic 저장
    public void save(Topic topic) {
        if (topic.getId() == null) {
            Long id = topicIdxGenerator.incrementAndGet();
            topic.setId(id);
            topicMap.put(id, topic);
        } else {
            topicMap.replace(topic.getId(), topic);
        }
    }

    // Topic ID로 조회
    public Optional<Topic> findById(Long id) {
        return Optional.ofNullable(topicMap.get(id));
    }

    // 모든 Topic 조회
    public List<Topic> findAll() {
        return topicMap.values().stream().toList();
    }

    // Topic 삭제
    public void deleteById(Long id) {
        topicMap.remove(id);
    }
}