package fr.rt.MyPrintAuth.services;


import fr.rt.MyPrintAuth.entities.Categorie;
import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getCategories(){
        return categorieRepository.findAll();
    }

    public void addCategorie(Categorie categorie){
        categorieRepository.save(categorie);
    }
}
