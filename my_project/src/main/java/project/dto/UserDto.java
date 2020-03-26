package project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String email;
    private String name;

    public static UserDto fromUser(User user){
        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
