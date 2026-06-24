package com.formation.ddd.infrastructure.controller;

import com.formation.ddd.application.ReviewAppService;
import com.formation.ddd.infrastructure.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    private ReviewAppService reviewAppService;

    @PostMapping("/reviews")
    public void publishReview(@RequestBody ReviewDto reviewDto) {
        reviewAppService.publishReview(reviewDto);
    }

}
