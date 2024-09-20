package com.pironeer.week2.service;


import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponse save(CommentCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        Comment comment = Comment.builder()
                .content(request.content())
                .topicId(request.topicId())
                .topicId(request.topicId())
                .createdAt(now)
                .updatedAt(now)
                .build();
        Comment savedComment = commentRepository.save(comment);
        return CommentResponse.of(savedComment);
    }

    public List<CommentResponse> findAllByTopicId(Long topicId) {
        List<Comment> comments = commentRepository.findAllByTopicId(topicId);
        return comments.stream()
                .map(CommentResponse::of)
                .toList();
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}