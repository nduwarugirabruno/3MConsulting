package io.app.notification.entity.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "User")
@Entity(name = "User")
public class User extends AUser {

    public User() {
        super();
    }

    public User(Long id, String nom, Long number, String mail, String password, String skills) {
        super(id, nom, number, mail, password, skills);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}


