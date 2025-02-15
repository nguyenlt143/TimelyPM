package dev.fpt.web_app.domain.repository;

import dev.fpt.web_app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}