package dev.fpt.web_app.domain.repository;

import dev.fpt.web_app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findUserByUserName(String email);
    Optional<User> findAllBy();
}