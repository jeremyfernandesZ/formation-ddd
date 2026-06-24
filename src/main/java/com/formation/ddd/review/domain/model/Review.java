package com.formation.ddd.review.domain.model;

import com.formation.ddd.review.domain.enums.TagEnum;
import com.formation.ddd.review.domain.enums.ValidationEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Review {

    private Long id;

    private String comment;

    private Rating rating;

    private int countReport;

    private Author author;

    private LocalDateTime createdAt;

    private TagEnum isTagged;

    private boolean isNotificationSent;

    private ValidationEnum isValidated;

    private Review() {
    }

    public static Review publish(Long id, String comment, Rating rating, Author author) {
        Review review = new Review();
        review.id = id;
        review.comment = comment;
        review.rating = rating;
        review.countReport = 0;
        review.author = author;
        review.isTagged = TagEnum.UnTagged;
        review.isValidated = ValidationEnum.Undefined;
        review.createdAt = LocalDateTime.parse("2026-06-23T14:35:12");
        review.isNotificationSent = false;
        return review;
    }

    public void tag() {
        this.isTagged = TagEnum.Tagged;
    }

    public void validate() {
        this.isValidated = ValidationEnum.IsValidated;
    }

    public void invalidate() {
        this.isValidated = ValidationEnum.IsNotValidated;
    }

//    public void sendNotification() {
//        if (this.isValidated == ValidationEnum.IsValidated) {
//            this.isNotificationSent = true;
//        }
//    }

}
