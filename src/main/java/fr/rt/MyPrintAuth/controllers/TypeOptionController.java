package fr.rt.MyPrintAuth.controllers;


import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.entities.TypeOption;
import fr.rt.MyPrintAuth.services.TypeOptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeoptions")
public class TypeOptionController {

    private final TypeOptionService typeOptionService;

    public TypeOptionController(TypeOptionService typeOptionService) {
        this.typeOptionService = typeOptionService;
    }

    @GetMapping("")
    public ResponseEntity<List<TypeOption>> getOptions(){

        return ResponseEntity.ok(typeOptionService.getTypeOptions());
    }

    @PostMapping("")
    public ResponseEntity addOption(@RequestBody TypeOption typeOption){

        typeOptionService.addTypeOption(typeOption);
        return ResponseEntity.ok().build();

    }
}
