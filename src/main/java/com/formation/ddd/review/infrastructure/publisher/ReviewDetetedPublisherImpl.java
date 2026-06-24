package com.formation.ddd.review.infrastructure.publisher;

import com.formation.ddd.moderation.EventSubscriber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReviewDetetedPublisherImpl implements EventDispatcher, EventSubscriber {

    private final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> handlers = new HashMap<>();

    public <E extends Event> void dispatch(E event) {
        if (handlers.containsKey(event.getClass())) {
            for (EventHandler<? extends Event> handler : handlers.get(event.getClass())) {
                ((EventHandler<E>) handler).handle(event);
            }
        }
    }

    @Override
    public <E extends Event> void subscribe(Class<E> eventType, EventHandler<E> consumer) {
        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(consumer);
    }
}

