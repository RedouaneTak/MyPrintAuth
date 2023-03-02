package fr.rt.MyPrintAuth.controllers;

import fr.rt.MyPrintAuth.entities.Adresse;
import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(){

        return ResponseEntity.ok(userService.getUsers());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathParam("id") Integer id){

        Optional<User> user = userService.getUserById(id);
        if(user.isPresent())
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity modifyUser(@PathParam("id")Integer id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String email,
                                     @RequestParam String password){

        userService.modifyUser(id,firstName,lastName,email,password);

        return ResponseEntity.ok().build();

    }



}
