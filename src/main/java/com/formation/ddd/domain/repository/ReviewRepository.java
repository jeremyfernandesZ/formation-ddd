package com.formation.ddd.domain.repository;

import com.formation.ddd.domain.model.Review;

public interface ReviewRepository {
    Review saveReview(Review review);

    Long getNewId();
}
