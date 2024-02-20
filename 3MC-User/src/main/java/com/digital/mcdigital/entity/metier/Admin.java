package com.digital.mcdigital.entity.metier;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Admin")
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column(nullable = false)
    private Long number;

    @Column
    private String password;

    public Admin() {
        super();
    }

    public Admin(String email, Long number, String password) {
        this.email = email;
        this.number = number;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\tAdmin:" +
                "\n\t\tid: " + id +
                "\n\t\temail: " + email +
                "\n\t\tpassword: " + password;
    }
}
