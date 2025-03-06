package dev.fpt.web_app.domain.repository;

import dev.fpt.web_app.domain.entity.Project;
import dev.fpt.web_app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByCreatedBy(User createdBy);
}