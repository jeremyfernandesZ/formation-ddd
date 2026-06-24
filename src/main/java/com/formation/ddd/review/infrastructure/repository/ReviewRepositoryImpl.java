package com.formation.ddd.review.infrastructure.repository;

import com.formation.ddd.review.domain.model.Author;
import com.formation.ddd.review.domain.model.Rating;
import com.formation.ddd.review.domain.model.Review;
import com.formation.ddd.review.domain.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    HashMap<Long, Review> reviewMap;

    public ReviewRepositoryImpl() {
        this.reviewMap = new HashMap<>();
        Author author = new Author(1L, "John", "Doe");
        Rating rating = new Rating(3);
        Review review = Review.publish(1L, "My comment", rating, author);
        this.reviewMap.put(0L, review);
    }

    public Review saveReview(Review review) {
        return this.reviewMap.put(review.getId(), review);
    }

    @Override
    public void deleteReview(long reviewId) {
        this.reviewMap.remove(reviewId);
    }

    public Long getNewId() {
        return (long) this.reviewMap.size();
    }

}
