package project.services;

import project.dto.UserDto;

public interface EmailService {
    public void sendConfirmation(String token, UserDto userDto);
    public void sendImageUrl(String email, String fileName);
}
