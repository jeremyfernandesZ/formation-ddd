package com.formation.ddd.domain.model;

import com.formation.ddd.review.domain.enums.TagEnum;
import com.formation.ddd.review.domain.enums.ValidationEnum;
import com.formation.ddd.review.domain.model.Author;
import com.formation.ddd.review.domain.model.Rating;
import com.formation.ddd.review.domain.model.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReviewTest {

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

}