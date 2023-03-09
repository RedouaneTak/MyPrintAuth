package fr.rt.MyPrintAuth.services;


import fr.rt.MyPrintAuth.entities.Option;
import fr.rt.MyPrintAuth.entities.TypeOption;
import fr.rt.MyPrintAuth.repositories.TypeOptionRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TypeOptionService {

    private final TypeOptionRepository typeOptionRepository;

    public TypeOptionService(TypeOptionRepository typeOptionRepository) {
        this.typeOptionRepository = typeOptionRepository;
    }


    public List<TypeOption> getTypeOptions(){
        return typeOptionRepository.findAll();
    }

    public void addTypeOption(TypeOption typeOption){
        typeOptionRepository.save(typeOption);
    }
}
