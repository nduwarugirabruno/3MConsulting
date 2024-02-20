package io.app.notification.entity.metier;

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
    private Long idAdmin;

    @Column
    private String email;

    @Column
    private String password;

    public Admin() {
        super();
    }

    public Admin(Long idAdmin, String email, String password) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
