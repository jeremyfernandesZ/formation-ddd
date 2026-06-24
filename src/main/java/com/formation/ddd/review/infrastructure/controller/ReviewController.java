package com.formation.ddd.review.infrastructure.controller;

import com.formation.ddd.review.application.ReviewAppService;
import com.formation.ddd.review.infrastructure.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewAppService reviewAppService;

    @PostMapping("/reviews")
    public void publishReview(@RequestBody ReviewDto reviewDto) {
        reviewAppService.publishReview(reviewDto);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable long reviewId) {
        reviewAppService.deleteReview(reviewId);
    }

}
