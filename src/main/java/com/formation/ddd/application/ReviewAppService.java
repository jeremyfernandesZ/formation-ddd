package com.formation.ddd.application;

import com.formation.ddd.infrastructure.dto.ReviewDto;

public interface ReviewAppService {

    void publishReview(ReviewDto review);
}
