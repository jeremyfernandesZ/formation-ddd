package com.formation.ddd.moderation;

import com.formation.ddd.review.infrastructure.publisher.Event;
import com.formation.ddd.review.infrastructure.publisher.EventHandler;

public interface EventSubscriber {
    <E extends Event> void subscribe(Class<E> eventType, EventHandler<E> consumer);
}

