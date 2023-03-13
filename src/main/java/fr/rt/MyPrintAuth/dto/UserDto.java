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

    private Integer idRole;







}
