package com.formation.ddd.infrastructure.dto;

import com.formation.ddd.domain.model.Author;


public record ReviewDto(String comment,
                        int rating,
                        // Faut une DTO
                        Author author) {
}
