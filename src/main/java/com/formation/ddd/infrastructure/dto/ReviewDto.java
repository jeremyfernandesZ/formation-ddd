package com.formation.ddd.infrastructure.dto;

import com.formation.ddd.domain.model.Author;
import com.formation.ddd.domain.model.Rating;


public record ReviewDto(String comment,
                        Rating rating,
                        // Faut une DTO
                        Author author) {
}
