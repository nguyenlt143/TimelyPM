package dev.fpt.web_app.domain.entity;

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
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long id;

    @Column(name = "permission", nullable = false, unique = true)
    private String Permission;

    @Column(name = "created_at")
    private Instant CreatedAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deactivated")
    private Instant DeactivatedAt;
}
