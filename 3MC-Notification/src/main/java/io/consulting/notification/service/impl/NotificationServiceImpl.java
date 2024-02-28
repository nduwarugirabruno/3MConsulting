package io.consulting.notification.service.impl;

import io.consulting.notification.entity.app.Notification;
import io.consulting.notification.repository.NotificationRepository;
import io.consulting.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    /**
     * @param notification data of notification
     * @return state of the creation
     */
    @Override
    public ResponseEntity<Notification> create(Notification notification) {
        try {
            if (notification.getContent() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getNotificationType() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getDelivered() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getUserFrom() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getConsult() == null)
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500

            Notification notification1 = notificationRepository.save(notification);
            System.out.println("created" + notification1);
            return new ResponseEntity<>(notification1, HttpStatus.OK); // renvoie une réponse 200
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param notification new data of notification
     * @param id of searched Notification
     * @return the updated Notification
     */
    @Override
    public ResponseEntity<Notification> update(Notification notification, Long id) {
        try {
            Optional<Notification> uses = notificationRepository.findById(id);
            if (uses.isEmpty()) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500

            if (notification.getContent() != null && !uses.get().getContent().equals(notification.getContent()))
                uses.get().setContent(notification.getContent());

            if (notification.getNotificationType() != null && !uses.get().getNotificationType().equals(notification.getNotificationType()))
                uses.get().setNotificationType(notification.getNotificationType());

            if (notification.getConsult() != null && !uses.get().getConsult().equals(notification.getConsult()))
                uses.get().setConsult(notification.getConsult());

            if (notification.getDelivered() != null && !uses.get().getDelivered().equals(notification.getDelivered()))
                uses.get().setDelivered(notification.getDelivered());

            Notification notification1 = notificationRepository.saveAndFlush(uses.get());
            System.out.println("updated" + notification1);
            return new ResponseEntity<>(notification1, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param id of searched Notification
     * @return the state of corresponding Notification
     */
    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            notificationRepository.deleteById(id);
            return new ResponseEntity<>("Notification supprimée", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>("An error has occured: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return a list of all Notifications
     */
    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    /**
     * @param id of searched Notification
     * @return corresponding Notification
     */
    @Override
    public Notification getUById(Long id) {
        if (notificationRepository.findById(id).isPresent()) return notificationRepository.findById(id).get();
        else return null;
    }

    /**
     * @param content of searched Notification
     * @return corresponding Notifications
     */
    @Override
    public List<Notification> getByContent(String content) {
        return notificationRepository.findByContent(content);
    }

    /**
     * @param userName of the userFrom of searched Notification
     * @return corresponding Notifications
     */
    @Override
    public List<Notification> getByUserName(String userName) {
        return notificationRepository.findByUserFrom(userName);
    }
}
