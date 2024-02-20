package com.digital.mcdigital.entity.metier;

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

    public AUser() {
        super();
    }

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

    @Override
    public String toString() {
        return "\tUser: " +
                "\n\t\tid: " + id +
                "\n\t\tname: " + name +
                "\n\t\tsurname: " + surname +
                "\n\t\tnumber: " + number +
                "\n\t\tmail: " + mail +
                "\n\t\tpassword: " + password +
                "\n\t\tskills: " + skills +
                "\n\t\tactive: " + active;
    }
}
