package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.Commande;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    public Commande addCommande(Commande commande){

        Commande newCommande = commandeRepository.save(commande);
        return  newCommande;
    }
}
