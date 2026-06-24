package com.formation.ddd.review.domain.service;

import com.formation.ddd.review.domain.model.Author;
import com.formation.ddd.review.domain.model.Rating;


public interface ReviewService {
    void publishReview(String comment, Rating rating, Author author);

    void deleteReview(long id);
}
