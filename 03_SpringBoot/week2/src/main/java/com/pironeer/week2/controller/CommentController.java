package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody CommentCreateRequest request) {
        CommentResponse response = commentService.save(request);
        return ResponseEntity.ok(response);
    }

    // 특정 게시물에 속한 모든 댓글 조회
    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<CommentResponse>> readAllByTopicId(@PathVariable Long topicId) {
        List<CommentResponse> responses = commentService.findAllByTopicId(topicId);
        return ResponseEntity.ok(responses);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> delete(@PathVariable Long commentId) {
        commentService.deleteById(commentId);
        return ResponseEntity.ok().build();
    }
}