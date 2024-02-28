package io.consulting.user.entity.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "AUser")
@Entity(name = "AUser")
public class User extends AUser {

    public User(String name, String surname, Long number, String mail, String password, String skills) {
        super(name, surname, number, mail, password, skills);
    }

    public User(String name, String surname, Long number, String mail, String password) {
        super(name, surname, number, mail, password);
    }

}


