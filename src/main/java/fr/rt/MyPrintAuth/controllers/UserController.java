package fr.rt.MyPrintAuth.controllers;

import fr.rt.MyPrintAuth.dto.PossederDto;
import fr.rt.MyPrintAuth.dto.UserDto;
import fr.rt.MyPrintAuth.entities.Adresse;
import fr.rt.MyPrintAuth.entities.PossederPK;
import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.services.AdresseService;
import fr.rt.MyPrintAuth.services.PossederService;
import fr.rt.MyPrintAuth.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final PossederService possederService;

    private final AdresseService adresseService;

    public UserController(UserService userService, PossederService possederService, AdresseService adresseService) {
        this.userService = userService;
        this.possederService = possederService;
        this.adresseService = adresseService;
    }


    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers() {

        return ResponseEntity.ok(userService.getUsers());

    }

    @GetMapping("/all")
    public ResponseEntity<Page<UserDto>> getUsersWithPageable(Pageable pageable){

        return ResponseEntity.ok(userService.findAllWithPageable(pageable));

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathParam("id") Integer id) {



        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDto> modifyUser(@PathParam("id")Integer id,@RequestBody UserDto userDto) {



        return ResponseEntity.ok(userService.modifyUser(id,userDto));

    }

    @GetMapping("/{id}/adresses")
    public ResponseEntity<List<PossederDto>> getAdressesByIdUser(@PathParam("id") Integer id) {

        return ResponseEntity.ok(PossederDto.toListPossederDto(possederService.getAdressesByIdUser(id)));

    }


    @PostMapping("/{id}/adresses/add")
    public ResponseEntity addAdresseForUser(@PathParam("id") Integer id, @RequestBody Adresse adresse) {


        adresseService.addAdresseForUser(id, adresse);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/{id}/adresses/{idAdresse}")
    public ResponseEntity<Adresse> getUserAdresseById(@PathParam("id")Integer id,@PathParam("idAdresse") Integer idAdresse) {

        return ResponseEntity.ok(adresseService.getAdresseById(idAdresse).get());

    }

    @DeleteMapping("/{id}/adresses/{idAdresse}")
    public ResponseEntity removeAdresseFromUser(@PathParam("id")Integer id,@PathParam("idAdresse") Integer idAdresse){


        possederService.removePossederByPossederPK(id,idAdresse);
        return ResponseEntity.ok().build();
    }




}
