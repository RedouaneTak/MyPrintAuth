package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.entities.SousTypeOption;
import fr.rt.MyPrintAuth.repositories.SousTypeOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousTypeOptionService {

    private final SousTypeOptionRepository sousTypeOptionRepository;

    public SousTypeOptionService(SousTypeOptionRepository sousTypeOptionRepository) {
        this.sousTypeOptionRepository = sousTypeOptionRepository;
    }


    public List<SousTypeOption> getSousTypeOptions(){
        return sousTypeOptionRepository.findAll();
    }

    public void addSousTypeOption(SousTypeOption sousTypeOption){
        sousTypeOptionRepository.save(sousTypeOption);
    }
}
