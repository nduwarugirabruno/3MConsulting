package io.app.notification.service;

import io.app.notification.entity.app.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
	ResponseEntity<Notification> create(Notification notification);
	ResponseEntity<Notification> update(Notification notification, Long id);
	ResponseEntity<String> delete(Long id);
	List<Notification> getAll();
	Notification getUById(Long id);
	List<Notification> getByContent(String content);
}

