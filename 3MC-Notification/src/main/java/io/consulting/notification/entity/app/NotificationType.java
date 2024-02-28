package io.consulting.notification.entity.app;

import jakarta.persistence.Table;

@Table(name = "notification_type")
public enum NotificationType {
    LIKE, COMMENT, SHARE, NEW_POST, TRANSACTION
}
