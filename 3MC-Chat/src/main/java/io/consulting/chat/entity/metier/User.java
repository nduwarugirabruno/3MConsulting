package io.consulting.chat.entity.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "User")
@Entity(name = "User")
public class User extends AUser {

    public User(String name, String surname, Long number, String mail, String password, String skills) {
        super(name, surname, number, mail, password, skills);
    }

    public User(String name, String surname, Long number, String mail, String password) {
        super(name, surname, number, mail, password);
    }

}


