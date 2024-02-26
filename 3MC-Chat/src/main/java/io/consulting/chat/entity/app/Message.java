package io.consulting.chat.entity.app;

import io.consulting.chat.entity.metier.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Message")
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private Date date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.DETACH)
    private User sender;

    @OneToOne(cascade = CascadeType.DETACH)
    private User receiver;

    public Message(String message, Date date, Status status, User sender, User receiver) {
        this.message = message;
        this.date = date;
        this.status = status;
        this.sender = sender;
        this.receiver = receiver;
    }
}
