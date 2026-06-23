package com.formation.ddd.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReviewTest {

    @Test
    void should_publish_review() {
        Author author = new Author(1L, "John", "Doe");

        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", 3, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating());
        Assertions.assertFalse(review.isTagged());
        Assertions.assertFalse(review.isNotificationSent());

        Assertions.assertEquals(1L, review.getAuthor().getId());
    }

    @Test
    void should_tag_review() {
        Author author = new Author(1L, "John", "Doe");
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", 3, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating());
        Assertions.assertFalse(review.isTagged());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.tag();
        Assertions.assertTrue(review.isTagged());
    }

    @Test
    void should_review_validate() {
        Author author = new Author(1L, "John", "Doe");
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", 3, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating());
        Assertions.assertFalse(review.isTagged());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.validate();
        Assertions.assertTrue(review.getIsValidated());
    }

    @Test
    void should_review_invalidate() {
        Author author = new Author(1L, "John", "Doe");
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", 3, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating());
        Assertions.assertFalse(review.isTagged());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.invalidate();
        Assertions.assertFalse(review.getIsValidated());
    }

    @Test
    void should_not_send_notification() {
        Author author = new Author(1L, "John", "Doe");
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", 3, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating());
        Assertions.assertFalse(review.isTagged());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.sendNotification();
        Assertions.assertFalse(review.isNotificationSent());
    }

    @Test
    void should_send_notification() {
        Author author = new Author(1L, "John", "Doe");
        String creationDate = "2026-06-23T14:35:12";
        Review review = Review.publish(1L, "My comment", 3, author);
        Assertions.assertEquals(1L, review.getId());
        Assertions.assertEquals("My comment", review.getComment());
        Assertions.assertEquals(0, review.getCountReport());
        Assertions.assertEquals(creationDate, review.getCreatedAt().toString());
        Assertions.assertEquals(3, review.getRating());
        Assertions.assertFalse(review.isTagged());
        Assertions.assertEquals(1L, review.getAuthor().getId());
        Assertions.assertFalse(review.isNotificationSent());

        review.validate();
        review.sendNotification();
        Assertions.assertTrue(review.isNotificationSent());
    }

}