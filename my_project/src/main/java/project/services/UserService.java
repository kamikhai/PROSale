package project.services;

import project.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> find(Long id);
}
