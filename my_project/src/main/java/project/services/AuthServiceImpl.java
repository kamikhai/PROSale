package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import project.dto.UserDto;
import project.models.Role;
import project.models.State;
import project.models.User;
import project.repositories.UserRepository;

import java.util.concurrent.ExecutorService;

@Component
public class AuthServiceImpl implements AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ExecutorService executorService;

    @Override
    public Long signUp(User model) {
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        model.setState(State.NOT_CONFIRMED);
        model.setRole(Role.USER);
        model.setId(userRepository.save(model));
        String token = tokenService.save(model);
        executorService.submit(() -> emailService.sendConfirmation(token, UserDto.fromUser(model)));
        return model.getId();
    }


}
