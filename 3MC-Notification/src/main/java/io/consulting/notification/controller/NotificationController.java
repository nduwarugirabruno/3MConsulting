package io.consulting.notification.controller;

import io.consulting.notification.entity.app.Notification;
import io.consulting.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/notification")
public class NotificationController {

	final
	NotificationService notificationService;

	@Autowired
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping(path = "/new")
	public ResponseEntity<Notification> create(@RequestBody Notification notification){
		return notificationService.create(notification);
	}

	@PutMapping(path = "/edit/{id}")
	public ResponseEntity<Notification> update(@RequestBody Notification notification, @PathVariable Long id){
		return notificationService.update(notification, id);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return notificationService.delete(id);
	}

	@GetMapping(path = "/read/all")
	public List<Notification> readAll(){
		return notificationService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public Notification readById(@PathVariable Long id){
		return notificationService.getUById(id);
	}

	@GetMapping("/read/content/{content}")
	public List<Notification> readByName(@PathVariable String content) {
		return notificationService.getByContent(content);
	}

}