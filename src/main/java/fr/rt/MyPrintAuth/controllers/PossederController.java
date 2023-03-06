package fr.rt.MyPrintAuth.controllers;

import fr.rt.MyPrintAuth.dto.PossederDto;
import fr.rt.MyPrintAuth.entities.Posseder;
import fr.rt.MyPrintAuth.services.PossederService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posseder")
public class PossederController {

    private final PossederService possederService;

    public PossederController(PossederService possederService) {
        this.possederService = possederService;
    }

    @GetMapping("")
    public ResponseEntity<List<PossederDto>> getPosseder(){
        return ResponseEntity.ok(PossederDto.toListPossederDto(possederService.getPosseders()));
    }
}
