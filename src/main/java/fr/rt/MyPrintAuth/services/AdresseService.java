package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Adresse;
import fr.rt.MyPrintAuth.repositories.AdresseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public List<Adresse> getAdresses(){

        return adresseRepository.findAll();

    }

    public Optional<Adresse> getAdresseById(Integer id){

         return adresseRepository.findById(id);

    }

    public void addAdresse(Adresse adresse){

        adresseRepository.save(adresse);
    }

    @Transactional
    public void modifyAdresse(Integer id,Adresse adresse){

        Adresse oldAdresse =  adresseRepository.findById(id).orElseThrow();

        oldAdresse.setRue(adresse.getRue());
        oldAdresse.setComplement(adresse.getComplement());
        oldAdresse.setCodePostal(adresse.getCodePostal());
        oldAdresse.setVille(adresse.getVille());
        oldAdresse.setTypeAdresse(adresse.getTypeAdresse());

    }
}
