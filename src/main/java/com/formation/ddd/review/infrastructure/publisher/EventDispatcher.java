package com.formation.ddd.review.infrastructure.publisher;

public interface EventDispatcher {
    <E extends Event> void dispatch(E event);
}

