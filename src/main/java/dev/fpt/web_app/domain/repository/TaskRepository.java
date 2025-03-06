package dev.fpt.web_app.domain.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends org.springframework.data.jpa.repository.JpaRepository<dev.fpt.web_app.domain.entity.Task, Long> {

}
