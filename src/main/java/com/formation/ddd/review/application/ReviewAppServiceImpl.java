package com.formation.ddd.review.application;

import com.formation.ddd.review.domain.model.Rating;
import com.formation.ddd.review.domain.service.ReviewService;
import com.formation.ddd.review.infrastructure.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewAppServiceImpl implements ReviewAppService {

    @Autowired
    private ReviewService reviewService;

    public void publishReview(ReviewDto review) {
        reviewService.publishReview(review.comment(), new Rating(review.rating()), review.author());
    }

    @Override
    public void deleteReview(long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
