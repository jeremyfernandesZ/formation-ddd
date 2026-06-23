package com.formation.ddd.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Review {

    private Long id;

    private String comment;

    private int rating;

    private int countReport;

    private Author author;

    private LocalDateTime createdAt;

    private boolean isTagged;

    private boolean isNotificationSent;

    private Boolean isValidated;

    private Review() {
    }

    public static Review publish(Long id, String comment, int rating, Author author) {
        Review review = new Review();
        review.id = id;
        review.comment = comment;
        review.rating = rating;
        review.countReport = 0;
        review.author = author;
        review.isTagged = false;
        review.isValidated = null;
        review.createdAt = LocalDateTime.parse("2026-06-23T14:35:12");
        review.isNotificationSent = false;
        return review;
    }

    public void tag() {
        this.isTagged = true;
    }

    public void validate() {
        this.isValidated = true;
    }

    public void invalidate() {
        this.isValidated = false;
    }

    public void sendNotification() {
        if (this.isValidated != null && this.isValidated) {
            this.isNotificationSent = true;
        }
    }

}
