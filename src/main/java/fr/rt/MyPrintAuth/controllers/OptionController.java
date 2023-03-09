package fr.rt.MyPrintAuth.controllers;


import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.services.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("")
    public ResponseEntity<List<Option>> getOptions(){

        return ResponseEntity.ok(optionService.getOptions());
    }

    @PostMapping("")
    public ResponseEntity addOption(@RequestBody Option option){

        optionService.addOption(option);
        return ResponseEntity.ok().build();

    }
}
