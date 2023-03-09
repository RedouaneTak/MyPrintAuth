package fr.rt.MyPrintAuth.controllers;

import fr.rt.MyPrintAuth.entities.Categorie;
import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.services.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Categorie>> getCategories(){

        return ResponseEntity.ok(categorieService.getCategories());
    }

    @PostMapping("")
    public ResponseEntity addOption(@RequestBody Categorie categorie){

        categorieService.addCategorie(categorie);
        return ResponseEntity.ok().build();

    }
}
