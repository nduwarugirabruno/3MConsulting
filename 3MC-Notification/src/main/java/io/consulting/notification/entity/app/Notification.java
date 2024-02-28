package io.consulting.notification.entity.app;

import io.consulting.notification.entity.metier.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Notification")
@Entity(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    private User userTo;

    @ManyToOne(cascade = CascadeType.ALL)
    private User userFrom;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @Column(name = "delivered")
    private Boolean delivered;

    @Column(name = "consult")
    private Boolean consult;

    public Notification() {
        super();
    }

    public Notification(Long id, String content, User userTo, User userFrom, NotificationType notificationType) {
        this.id = id;
        this.content = content;
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.notificationType = notificationType;
    }

    @Override
    public String toString() {
        return "\tNotification:" +
                "\n\t\tid: " + id +
                "\n\t\tcontent: " + content +
                "\n\t\tuserTo: " + userTo +
                "\n\t\tuserFrom: " + userFrom +
                "\n\t\tnotificationType: " + notificationType +
                "\n\t\tdelivered: " + delivered +
                "\n\t\tconsult: " + consult;
    }
}
