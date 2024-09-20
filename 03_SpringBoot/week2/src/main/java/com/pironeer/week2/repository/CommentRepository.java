package com.pironeer.week2.repository;

import com.pironeer.week2.repository.domain.Comment;
import com.pironeer.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final AtomicLong commentIdxGenerator = new AtomicLong();
    private final Map<Long, Comment> commentMap = new HashMap<>();

    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            Long id = commentIdxGenerator.incrementAndGet();
            comment.setId(id);
        }
        commentMap.put(comment.getId(), comment);
        return comment;
    }

    public Optional<Comment> findById(Long id) {
        return Optional.ofNullable(commentMap.get(id));
    }

    public List<Comment> findAllByTopicId(Long topicId) {
        return commentMap.values().stream()
                .filter(comment -> comment.getTopicId().equals(topicId))
                .toList();
    }

    public void deleteById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL"); // id 검사 후 null이면 예외 발생
        commentMap.remove(id);
    }
}