package com.formation.ddd.infrastructure.dto;

import com.formation.ddd.domain.enums.TagEnum;
import com.formation.ddd.domain.enums.ValidationEnum;
import com.formation.ddd.domain.model.Author;
import com.formation.ddd.domain.model.Rating;

import java.time.LocalDateTime;

public record ReviewDto(Long id,

                        String comment,

                        Rating rating,

                        int countReport,

                        Author author,

                        LocalDateTime createdAt,

                        TagEnum isTagged,

                        boolean isNotificationSent,

                        ValidationEnum isValidated) {

}
