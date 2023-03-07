package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Adresse;
import fr.rt.MyPrintAuth.entities.Posseder;
import fr.rt.MyPrintAuth.entities.PossederPK;
import fr.rt.MyPrintAuth.repositories.AdresseRepository;
import fr.rt.MyPrintAuth.repositories.PossederRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossederService {

    private final PossederRepository possederRepository;
    private final AdresseRepository adresseRepository;

    public PossederService(PossederRepository possederRepository, AdresseRepository adresseRepository) {
        this.possederRepository = possederRepository;
        this.adresseRepository = adresseRepository;
    }

    public List<Posseder> getPosseders(){

        return possederRepository.findAll();
    }

    public List<Posseder> getAdressesByIdUser(Integer id){

        return possederRepository.findPossedersByPossederPK_IdUser(id);
    }


    public void addPosseder(Integer idUser,Adresse adresse){


        Posseder posseder = new Posseder(new PossederPK(idUser,adresse));
        possederRepository.save(posseder);

    }

    @Transactional
    public void removePossederByPossederPK(Integer idUser,Integer idAdresse){

        possederRepository.deleteByPossederPK_IdUserAndPossederPK_Adresse(idUser,new Adresse(idAdresse));
        adresseRepository.delete(new Adresse(idAdresse));
    }
}
