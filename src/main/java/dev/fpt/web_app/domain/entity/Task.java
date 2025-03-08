package dev.fpt.web_app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Task")
public class Task extends Topic{

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
