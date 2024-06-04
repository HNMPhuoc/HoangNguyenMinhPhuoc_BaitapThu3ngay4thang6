package com.Demo.baikiemtra.Entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String id, String firstName, String lastName, String email, String password, Date birthday, boolean isDeleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.isDeleted = isDeleted;
    }
}