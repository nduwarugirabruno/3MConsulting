package io.app.notification.entity.metier;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "AUser")
@Entity(name = "AUser")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 15, nullable = false)
    private Long number;

    @Column(length = 100, nullable = false)
    private String mail;

    @Column(length = 100, nullable = false)
    private String password;

    @Column
    private String skills;

    public AUser() {
        super();
    }

    public AUser(Long id, String name, Long number, String mail, String password, String skills) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.mail = mail;
        this.password = password;
        this.skills = skills;
    }

}
