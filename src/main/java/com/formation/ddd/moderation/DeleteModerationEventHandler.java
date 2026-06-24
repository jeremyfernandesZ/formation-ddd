package com.formation.ddd.moderation;

import com.formation.ddd.review.infrastructure.publisher.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteModerationEventHandler implements EventHandler<ReviewId> {
    private final ModerationAppServiceImpl moderationAppServiceImpl;

    public DeleteModerationEventHandler(EventSubscriber eventSubscriber, ModerationAppServiceImpl moderationAppServiceImpl) {
        this.moderationAppServiceImpl = moderationAppServiceImpl;
        eventSubscriber.subscribe(ReviewId.class, this);
    }

    @Override
    public void handle(ReviewId event) {
        moderationAppServiceImpl.deleteModeration(event);
    }
}
