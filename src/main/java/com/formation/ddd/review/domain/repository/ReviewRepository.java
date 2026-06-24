package com.formation.ddd.review.domain.repository;

import com.formation.ddd.review.domain.model.Review;

public interface ReviewRepository {
    Review saveReview(Review review);

    void deleteReview(long reviewId);

    Long getNewId();
}
