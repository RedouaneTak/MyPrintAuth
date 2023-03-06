package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Posseder;
import fr.rt.MyPrintAuth.entities.PossederPK;
import fr.rt.MyPrintAuth.repositories.PossederRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossederService {

    private final PossederRepository possederRepository;

    public PossederService(PossederRepository possederRepository) {
        this.possederRepository = possederRepository;
    }

    public List<Posseder> getPosseders(){

        return possederRepository.findAll();
    }

    public List<Posseder> getAdressesByIdUser(Integer id){

        return possederRepository.findPossedersByPossederPK_IdUser(id);
    }
}
