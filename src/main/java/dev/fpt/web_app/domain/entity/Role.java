package dev.fpt.web_app.domain.entity;

import dev.fpt.web_app.domain.enums.Role_Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long RoleId;

    @Column(name = "role_name", nullable = false, unique = true)
    private String RoleName;

    @Column(name = "role_type")
    @Enumerated(EnumType.STRING)
    private Role_Type role_type;

    @Column(name = "created_at")
    private Instant created_at;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "deactivated")
    private Instant deactivated_at;

}
