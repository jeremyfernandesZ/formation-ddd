package com.formation.ddd.moderation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class ModerationAppServiceImpl {

    HashMap<Long, List<Moderation>> reviewMap;

    public ModerationAppServiceImpl() {
        this.reviewMap = new HashMap<>();
        this.reviewMap.put(1L, List.of(new Moderation("Inappropriate content"), new Moderation("Spam")));
    }

    public void deleteModeration(ReviewId id) {
        reviewMap.remove(id.id());
        log.info("Moderation for review with id {} has been deleted.", id.id());
    }

}
