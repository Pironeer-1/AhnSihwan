package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.repository.domain.Topic;
import com.pironeer.week2.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // 생성자를 annotation으로 만들 수 있다.
@Tag(name = "게시물(Topic)")
@RequestMapping("/api/topic") // 으로 시작하도록
public class TopicController {
    private final TopicService topicService;

    @PostMapping// Post 요청 받음
    @Operation(summary = "게시물 작성")
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) { // RequestBody가 request변수에 값을 담음
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) { //변수를 가져오는 annotation
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public ResponseEntity<List<TopicResponse>> readAll() {
        List<TopicResponse> responses = topicService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PatchMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<?> remove(@PathVariable("topicId") Long id) {
        topicService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
