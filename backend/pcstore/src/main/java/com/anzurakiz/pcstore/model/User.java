package com.anzurakiz.pcstore.model;

import com.anzurakiz.pcstore.model.enumeration.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "shop_users")
@NoArgsConstructor
public class User {

    @Id
    private String email;

    @Enumerated(value = EnumType.STRING)
    private UserType type;

    private String name;

    private String surname;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private String password;

    public User(String email, UserType type, String name, String surname, LocalDate dateOfBirth, String password) {
        this.email = email;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }
}
