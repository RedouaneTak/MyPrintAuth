package fr.rt.MyPrintAuth.controllers;


import fr.rt.MyPrintAuth.dto.UserDto;
import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/profil")
public class ProfilController {


    private final UserService userService;

    public ProfilController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public ResponseEntity<UserDto> getProfil(Principal principal) {


        return ResponseEntity.ok(userService.getUserByEmail(principal.getName()));


    }
}
