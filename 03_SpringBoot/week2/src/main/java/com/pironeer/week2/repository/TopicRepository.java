package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong();
    private final Map<Long, Topic> topicMap = new HashMap<>();

    public void save(Topic topic) {
        Long id = topicIdxGenerator.incrementAndGet();
        topic.setId(id);
        topicMap.put(id, topic);
    }

    public Optional<Topic> findById(Long id) {
        return Optional.ofNullable(topicMap.get(id));
    }

    public List<Topic> findAll() {
        return topicMap.values().stream().toList();
    }
}