package com.pironeer.week4.controller;

import com.pironeer.week4.dto.request.TopicCreateRequest;
import com.pironeer.week4.dto.request.TopicUpdateRequest;
import com.pironeer.week4.dto.response.TopicResponse;
import com.pironeer.week4.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topic")
public class TopicController {
    private final TopicService topicService;

    // 새로운 Topic 생성
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    // Topic ID로 단건 조회
    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable Long topicId) {
        TopicResponse response = topicService.findById(topicId);
        return ResponseEntity.ok(response);
    }

    // 모든 Topic 조회
    @GetMapping
    public ResponseEntity<List<TopicResponse>> readAll() {
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok(responses);
    }

    // Topic 업데이트
    @PatchMapping
    public ResponseEntity<TopicResponse> update(@RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok(response);
    }

    // Topic 삭제
    @DeleteMapping("/{topicId}")
    public ResponseEntity<?> delete(@PathVariable Long topicId) {
        topicService.deleteById(topicId);
        return ResponseEntity.ok().build();
    }
}