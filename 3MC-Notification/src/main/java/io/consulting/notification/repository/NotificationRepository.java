package io.consulting.notification.repository;

import io.consulting.notification.entity.app.Notification;
import io.consulting.notification.entity.app.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	@Query("select n from Notification n where n.content like %?1%")
	List<Notification> findByContent(String content);

	@Query("select n from Notification n where n.userFrom.name like %?1%")
	List<Notification> findByUserFrom(String name);

	List<Notification> findByNotificationType(NotificationType notificationType);

}
