package com.formation.ddd.review.infrastructure.publisher;

public interface EventHandler<T extends Event> {
    void handle(T event);
}
