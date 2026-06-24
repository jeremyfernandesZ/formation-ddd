package com.formation.ddd.moderation;


import com.formation.ddd.review.infrastructure.publisher.Event;

public record ReviewId(Long id) implements Event {

}
