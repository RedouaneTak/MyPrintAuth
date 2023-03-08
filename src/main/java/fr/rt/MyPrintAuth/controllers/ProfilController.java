package fr.rt.MyPrintAuth.controllers;


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
    public ResponseEntity<User> getProfil(Principal principal){


        Optional<User> userOptional = userService.getUserByEmail(principal.getName());




        return ResponseEntity.ok(userOptional.get());


    }
}
