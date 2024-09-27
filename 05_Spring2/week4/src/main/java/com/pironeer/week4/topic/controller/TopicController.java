package com.pironeer.week4.topic.controller;

import com.pironeer.week4.global.dto.response.SuccessResponse;
import com.pironeer.week4.global.dto.response.result.ListResult;
import com.pironeer.week4.global.dto.response.result.SingleResult;
import com.pironeer.week4.topic.dto.request.TopicCreateRequest;
import com.pironeer.week4.topic.dto.request.TopicUpdateRequest;
import com.pironeer.week4.topic.dto.response.TopicResponse;
import com.pironeer.week4.topic.service.TopicService;
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
    public ResponseEntity<SuccessResponse<Void>> create(@RequestBody TopicCreateRequest request) {
        topicService.save(request);
        return ResponseEntity.ok(SuccessResponse.ok(null));
    }

    // Topic ID로 단건 조회
    @GetMapping("/{topicId}")
    public ResponseEntity<SuccessResponse<SingleResult<TopicResponse>>> read(@PathVariable("topicId") Long id) {
        SingleResult<TopicResponse> response = topicService.findById(id);
        return ResponseEntity.ok(SuccessResponse.ok(response));
    }

    // 모든 Topic 조회
    @GetMapping
    public ResponseEntity<SuccessResponse<ListResult<TopicResponse>>> readAll() {
        ListResult<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok(SuccessResponse.ok(responses));
    }

    // Topic 업데이트
    @PatchMapping
    public ResponseEntity<SuccessResponse<SingleResult<TopicResponse>>> update(@RequestBody TopicUpdateRequest request) {
        SingleResult<TopicResponse> response = topicService.update(request);
        return ResponseEntity.ok(SuccessResponse.ok(response));
    }

    // Topic 삭제
    @DeleteMapping("/{topicId}")
    public ResponseEntity<SuccessResponse<Void>> remove(@PathVariable("topicId") Long id) {
        topicService.deleteById(id);
        return ResponseEntity.ok(SuccessResponse.ok(null));
    }
}