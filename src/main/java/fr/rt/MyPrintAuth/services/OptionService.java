package fr.rt.MyPrintAuth.services;


import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.repositories.OptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final OptionRepository optionRepository;


    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }


    public List<Option> getOptions(){
        return optionRepository.findAll();
    }

    public void addOption(Option option){
        optionRepository.save(option);
    }
}
