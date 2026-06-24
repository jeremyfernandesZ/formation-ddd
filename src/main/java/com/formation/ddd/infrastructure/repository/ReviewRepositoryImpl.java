package com.formation.ddd.infrastructure.repository;

import com.formation.ddd.domain.model.Review;
import com.formation.ddd.domain.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    HashMap<Long, Review> reviewMap = new HashMap<>();

    public Review saveReview(Review review) {
        return this.reviewMap.put(review.getId(), review);
    }

    public Long getNewId() {
        return (long) this.reviewMap.size();
    }

}
