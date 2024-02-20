package io.app.notification.service.impl;

import io.app.notification.entity.app.Notification;
import io.app.notification.repository.NotificationRepository;
import io.app.notification.service.NotificationService;
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
/*            if (notification.getName() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getNumber() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getMail() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getPassword() == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
            }
            if (notification.getSkills() == null)
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
*/
            Notification utmp = notificationRepository.save(notification);
            System.out.println("created" + utmp);
            return new ResponseEntity<>(utmp, HttpStatus.OK); // renvoie une réponse 200
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param notification
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Notification> update(Notification notification, Long id) {
        try {
            Optional<Notification> uses = notificationRepository.findById(id);
            if (uses.isEmpty()) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500

            /*if (notification.getName() != null && !uses.get().getName().equals(notification.getName()))
                uses.get().setName(notification.getName());

            if (notification.getNumber() != 0L && !uses.get().getNumber().equals(notification.getNumber()))
                uses.get().setNumber(notification.getNumber());

            if (notification.getMail() != null && !uses.get().getMail().equals(notification.getMail()))
                uses.get().setMail(notification.getMail());

            if (notification.getPassword() != null && !uses.get().getPassword().equals(notification.getPassword()))
                uses.get().setPassword(notification.getPassword());

            if (notification.getSkills() != null && !uses.get().getSkills().equals(notification.getSkills()))
                uses.get().setSkills(notification.getSkills());*/

            Notification utmp = notificationRepository.saveAndFlush(uses.get());
            System.out.println("updated" + utmp);
            return new ResponseEntity<>(utmp, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            notificationRepository.deleteById(id);
            return new ResponseEntity<>("l'utilisateur a été supprimée", HttpStatus.OK);
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
     * @param content
     * @return
     */
    @Override
    public List<Notification> getByContent(String content) {
        return notificationRepository.findByContent(content);
    }
}
