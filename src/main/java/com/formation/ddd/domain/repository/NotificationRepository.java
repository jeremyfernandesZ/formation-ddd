package com.formation.ddd.domain.repository;

import com.formation.ddd.domain.model.Notification;

public interface NotificationRepository {
    Notification saveNotification(Notification notification);
}
