package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import project.models.User;
import project.models.VerificationToken;
import project.repositories.TokenRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenService {

    Long getUser(String token);
    String getToken(User user);

    String save(User model);
}
