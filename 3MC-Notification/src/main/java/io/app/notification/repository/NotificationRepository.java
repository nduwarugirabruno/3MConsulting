package io.app.notification.repository;

import io.app.notification.entity.app.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	@Query("select n from Notification n where n.content like %?1%")
	List<Notification> findByContent(String content);
}
