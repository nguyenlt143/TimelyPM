package dev.fpt.web_app.domain.repository;

import dev.fpt.web_app.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository  extends JpaRepository<Status, Integer> {
}
