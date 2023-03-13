package fr.rt.MyPrintAuth.mapper;

import fr.rt.MyPrintAuth.dto.UserDto;
import fr.rt.MyPrintAuth.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(source = "role.roleName",target = "idRole")
    UserDto toDto(User user);

    List<UserDto> toListDto(List<User> users);

    User toUser(UserDto userDto);

    User toUser(UserDto userDto,@MappingTarget User user);


}
