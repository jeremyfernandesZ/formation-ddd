package com.formation.ddd.review.domain.model;

import lombok.Getter;

@Getter
public class Rating {
    private int value;

    public Rating(int value) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Rating value must be between 1 and 5");
        }
        this.value = value;
    }
}
