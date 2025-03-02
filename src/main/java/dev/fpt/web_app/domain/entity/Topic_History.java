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
@Table(name = "topic_history")
public class Topic_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(name = "action")
    private String action;

    @Column(name = "entity_type")
    private String entity_type;

    @ManyToOne
    @JoinColumn(name = "changed_by")
    private User changed_by;

    @Column(name = "changed_at")
    private Timestamp changed_at;
}
