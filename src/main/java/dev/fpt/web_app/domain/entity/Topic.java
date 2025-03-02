package dev.fpt.web_app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "topic_type")
    private String topicType;

    @Column(name = "summary")
    private String summary;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @Column(name = "labels")
    private String labels;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "reported_by")
    private User reportedBy;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "parent_topic_id")
    private Topic parentTopic;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "deactivated_at")
    private Timestamp deactivatedAt;
}
