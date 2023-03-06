package fr.rt.MyPrintAuth.controllers;

import fr.rt.MyPrintAuth.entities.Adresse;
import fr.rt.MyPrintAuth.services.AdresseService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping()
    public ResponseEntity<List<Adresse>> getAdresses(){
        return ResponseEntity.ok(adresseService.getAdresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Adresse>> getAdresseById(@PathParam("id") Integer id){

        Optional<Adresse> adresse = adresseService.getAdresseById(id);
        if(adresse.isPresent())
            return ResponseEntity.ok(adresse);
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("")
    public ResponseEntity addAdresse(@RequestBody Adresse adresse){


        adresseService.addAdresse(adresse);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity modifyAdresse(@PathParam("id")Integer id,@RequestBody Adresse adresse){

        adresseService.modifyAdresse(id,adresse);
        return ResponseEntity.ok().build();

    }
}
