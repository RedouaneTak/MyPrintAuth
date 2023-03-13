package fr.rt.MyPrintAuth.mapper.impl;

import fr.rt.MyPrintAuth.dto.UserDto;
import fr.rt.MyPrintAuth.entities.Role;
import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto toDto(User user) {
        if(user==null){
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setIdRole(user.getRole().getIdRole());

        return userDto;
    }

    @Override
    public List<UserDto> toListDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(toDto(user));
        }

        return userDtos;
    }

    @Override
    public User toUser(UserDto userDto) {
        if(userDto ==null){
            return null;
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(new Role(userDto.getIdRole(), ""));

        return user;

    }

    @Override
    public User toUser(UserDto userDto, User user) {
        return null;
    }

}
