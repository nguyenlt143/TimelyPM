package dev.fpt.web_app.domain.entity;

import dev.fpt.web_app.domain.enums.User_role;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_image")
    private String user_image;

    @Enumerated(EnumType.STRING)
    private User_role role;

    @Column(name = "email_tf")
    private String email_two_factor;

    @Column(name = "user_status")
    private String user_status;

    @Column(name = "created_at")
    private Instant created_at;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "is_blocked")
    private boolean is_blocked;


}
