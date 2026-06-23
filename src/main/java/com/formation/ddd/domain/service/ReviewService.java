package com.formation.ddd.domain.service;

import com.formation.ddd.domain.model.Review;


public interface ReviewService {
      void sendNotification(Review review);
}
