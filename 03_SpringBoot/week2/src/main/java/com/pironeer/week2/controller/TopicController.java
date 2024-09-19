package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.TopicCreateRequest;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // 생성자를 annotation으로 만들 수 있다.
//@RequestMapping("/api/topic") // 으로 시작하도록

public class TopicController {
    private final TopicService topicService;

    @PostMapping("/api/topic")// Post 요청 받음
    public ResponseEntity<?> create(@RequestBody TopicCreateRequest request) { // RequestBody가 request변수에 값을 담음
        topicService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/topic/{topicId}")
    public ResponseEntity<TopicResponse> read(@PathVariable("topicId") Long id) { //변수를 가져오는 annotation
        TopicResponse response = topicService.findById(id);
        return ResponseEntity.ok().body(response);
    }
}
