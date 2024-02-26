package io.app.notification.entity.metier;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "AUser")
@Entity(name = "AUser")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String surname;

    @Column(nullable = false)
    private Long number;

    @Column(length = 100, nullable = false)
    private String mail;

    @Column(length = 100, nullable = false)
    private String password;

    @Column
    private String skills;

    @Column(nullable = false)
    private Boolean active;

    public AUser(String name, String surname, Long number, String mail, String password, String skills) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.mail = mail;
        this.password = password;
        this.skills = skills;
        this.active = true;
    }

    public AUser(String name, String surname, Long number, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.mail = mail;
        this.password = password;
        this.active = true;
    }
}
