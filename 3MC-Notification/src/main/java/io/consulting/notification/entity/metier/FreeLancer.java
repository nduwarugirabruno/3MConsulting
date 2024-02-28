package io.consulting.notification.entity.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "FreeLancer")
@Entity(name = "FreeLancer")
public class FreeLancer extends AUser {

    public FreeLancer(String name, String surname, Long number, String mail, String password, String skills) {
        super(name, surname, number, mail, password, skills);
    }

    public FreeLancer(String name, String surname, Long number, String mail, String password) {
        super(name, surname, number, mail, password);
    }

}


