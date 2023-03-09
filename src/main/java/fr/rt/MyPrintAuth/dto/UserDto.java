package fr.rt.MyPrintAuth.dto;


import fr.rt.MyPrintAuth.entities.Role;
import fr.rt.MyPrintAuth.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;

    private String password;

    private Role role;

    public UserDto(User user){
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        password = user.getPassword();

        role = user.getRole();

    }



    public static List<UserDto> toListUserDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(new UserDto(user));
        }


        return userDtos;

    }

    public static UserDto toUserDto(User user){
        return new UserDto(user);
    }



}
