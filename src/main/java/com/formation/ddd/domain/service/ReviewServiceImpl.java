package com.formation.ddd.domain.service;

import com.formation.ddd.domain.enums.ValidationEnum;
import com.formation.ddd.domain.model.Notification;
import com.formation.ddd.domain.model.Review;
import com.formation.ddd.domain.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final NotificationRepository notificationRepository;

    public ReviewServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendNotification(Review review) {
        String message = "Notification sent: " + review.getComment() +" with the rating of : "+ review.getRating() + " by " + review.getAuthor().getFirstName() + " " + review.getAuthor().getLastName();
        Long id = new Random().nextLong();
        Notification notification = new Notification(id, message);
        if(review.getIsValidated().equals(ValidationEnum.IsValidated)) {
            notificationRepository.saveNotification(notification);
        }
    }
}
