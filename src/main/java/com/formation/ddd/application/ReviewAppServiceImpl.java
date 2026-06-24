package com.formation.ddd.application;

import com.formation.ddd.domain.service.ReviewService;
import com.formation.ddd.infrastructure.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewAppServiceImpl implements ReviewAppService {

    @Autowired
    private ReviewService reviewService;

    public void publishReview(ReviewDto review) {
        reviewService.publishReview(review.comment(), review.rating(), review.author());
    }
}
