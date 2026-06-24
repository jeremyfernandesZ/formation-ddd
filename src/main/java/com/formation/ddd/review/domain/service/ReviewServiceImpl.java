package com.formation.ddd.review.domain.service;

import com.formation.ddd.moderation.DeleteModerationEventHandler;
import com.formation.ddd.moderation.ReviewId;
import com.formation.ddd.review.domain.model.Author;
import com.formation.ddd.review.domain.model.Rating;
import com.formation.ddd.review.domain.model.Review;
import com.formation.ddd.review.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final DeleteModerationEventHandler deleteModerationEventHandler;

    public ReviewServiceImpl(ReviewRepository reviewRepository, DeleteModerationEventHandler deleteModerationEventHandler) {
        this.reviewRepository = reviewRepository;
        this.deleteModerationEventHandler = deleteModerationEventHandler;
    }

    @Override
    public void publishReview(String comment, Rating rating, Author author) {
        Long newId = reviewRepository.getNewId();
        Review review = Review.publish(newId, comment, rating, author);
        reviewRepository.saveReview(review);
    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteReview(id);
        deleteModerationEventHandler.handle(new ReviewId(id));
    }
}
