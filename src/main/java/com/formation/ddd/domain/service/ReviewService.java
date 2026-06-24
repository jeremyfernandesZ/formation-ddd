package com.formation.ddd.domain.service;

import com.formation.ddd.domain.model.Author;
import com.formation.ddd.domain.model.Rating;


public interface ReviewService {
    void publishReview(String comment, Rating rating, Author author);
}
