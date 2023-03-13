package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Commande;
import fr.rt.MyPrintAuth.repositories.CommandeRepository;
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
