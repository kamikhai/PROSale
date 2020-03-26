package project.services;

import project.dto.UserDto;

import javax.mail.internet.MimeMessage;

public interface MessageContentService {

    String getMailConfirmPage(UserDto userDto, String token, MimeMessage message);
    String getFileUrl(String url, MimeMessage message);
}
