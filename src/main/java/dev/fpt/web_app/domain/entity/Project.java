package dev.fpt.web_app.domain.entity;

import dev.fpt.web_app.domain.enums.Project_Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private Project_Status projectStatus;

    @Column(name = "project_image")
    private String projectImage;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deactivated")
    private Timestamp deactivated;
}
