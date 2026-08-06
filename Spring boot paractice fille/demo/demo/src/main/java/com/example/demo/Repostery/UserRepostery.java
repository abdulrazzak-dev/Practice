package com.example.demo.Repostery;

import com.example.demo.Modules.Todo;
import com.example.demo.Modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepostery  extends JpaRepository<User,Long > {
    Optional<User> findByEmail(String email);
}
