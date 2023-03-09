package fr.rt.MyPrintAuth.controllers;


import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.entities.SousTypeOption;
import fr.rt.MyPrintAuth.services.SousTypeOptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soustypeoptions")
public class SousTypeOptionController {

    private final SousTypeOptionService sousTypeOptionService;

    public SousTypeOptionController(SousTypeOptionService sousTypeOptionService) {
        this.sousTypeOptionService = sousTypeOptionService;
    }

    @GetMapping("")
    public ResponseEntity<List<SousTypeOption>> getSousTypeOptions(){

        return ResponseEntity.ok(sousTypeOptionService.getSousTypeOptions());
    }

    @PostMapping("")
    public ResponseEntity addSousTypeOption(@RequestBody SousTypeOption sousTypeOption){

        sousTypeOptionService.addSousTypeOption(sousTypeOption);
        return ResponseEntity.ok().build();

    }
}
