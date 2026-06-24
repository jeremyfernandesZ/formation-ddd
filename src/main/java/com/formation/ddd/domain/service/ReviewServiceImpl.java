package com.formation.ddd.domain.service;

import com.formation.ddd.domain.model.Author;
import com.formation.ddd.domain.model.Rating;
import com.formation.ddd.domain.model.Review;
import com.formation.ddd.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void publishReview(String comment, Rating rating, Author author) {
        Long newId = reviewRepository.getNewId();
        Review review = Review.publish(newId, comment, rating, author);
        reviewRepository.saveReview(review);
    }
}
