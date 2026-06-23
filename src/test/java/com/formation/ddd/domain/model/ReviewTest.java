package com.formation.ddd.domain.model;

import com.formation.ddd.domain.enums.TagEnum;
import com.formation.ddd.domain.enums.ValidationEnum;
import com.formation.ddd.domain.repository.NotificationRepository;
import com.formation.ddd.domain.service.ReviewService;
import com.formation.ddd.domain.service.ReviewServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewTest {
    @InjectMocks
    private ReviewServiceImpl reviewService;
    @Mock
    private NotificationRepository notificationRepository;


    @Test
    void should_publish_review() {
        Author author = new Author(1L, "John", "Doe");
        Rating rating = new Rating(3);

        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", rating, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating().getValue());
        Assertions.assertEquals(TagEnum.UnTagged, review.getIsTagged());
        Assertions.assertFalse(review.isNotificationSent());

        Assertions.assertEquals(1L, review.getAuthor().getId());
    }

    @Test
    void should_tag_review() {
        Author author = new Author(1L, "John", "Doe");
        Rating rating = new Rating(3);
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", rating, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating().getValue());
        Assertions.assertEquals(TagEnum.UnTagged, review.getIsTagged());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.tag();
        Assertions.assertEquals(TagEnum.Tagged, review.getIsTagged());
    }

    @Test
    void should_review_validate() {
        Author author = new Author(1L, "John", "Doe");
        Rating rating = new Rating(3);
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", rating, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating().getValue());
        Assertions.assertEquals(TagEnum.UnTagged, review.getIsTagged());
        Assertions.assertEquals(ValidationEnum.Undefined, review.getIsValidated());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.validate();
        Assertions.assertEquals(ValidationEnum.IsValidated, review.getIsValidated());
    }

    @Test
    void should_review_invalidate() {
        Author author = new Author(1L, "John", "Doe");
        Rating rating = new Rating(3);
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", rating, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating().getValue());
        Assertions.assertEquals(TagEnum.UnTagged, review.getIsTagged());
        Assertions.assertEquals(ValidationEnum.Undefined, review.getIsValidated());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.invalidate();
        Assertions.assertEquals(ValidationEnum.IsNotValidated, review.getIsValidated());
    }

    @Test
    void should_send_notification(){
        Author author = new Author(1L, "John", "Doe");
        Rating rating = new Rating(3);
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", rating, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating().getValue());
        Assertions.assertEquals(TagEnum.UnTagged, review.getIsTagged());
        Assertions.assertEquals(ValidationEnum.Undefined, review.getIsValidated());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());
        String message = "Notification sent: " + review.getComment() +" with the rating of : "+
                review.getRating() + " by " +
                review.getAuthor().getFirstName() + " " + review.getAuthor().getLastName();

        when(this.notificationRepository.saveNotification(any(Notification.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        review.validate();
        reviewService.sendNotification(review);
        ArgumentCaptor<Notification> captor =
                ArgumentCaptor.forClass(Notification.class);

        verify(notificationRepository).saveNotification(captor.capture());
        Assertions.assertEquals(message, captor.getValue().getMessage());
    }
}