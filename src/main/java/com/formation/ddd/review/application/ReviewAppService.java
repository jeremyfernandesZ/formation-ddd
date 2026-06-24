package com.formation.ddd.review.application;

import com.formation.ddd.review.infrastructure.dto.ReviewDto;

public interface ReviewAppService {

    void publishReview(ReviewDto review);

    void deleteReview(long reviewId);
}
