package com.formation.ddd.review.infrastructure.dto;

import com.formation.ddd.review.domain.model.Author;


public record ReviewDto(String comment,
                        int rating,
                        // Faut une DTO
                        Author author) {
}
