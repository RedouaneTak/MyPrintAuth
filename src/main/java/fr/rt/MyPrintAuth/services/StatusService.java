package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Status;
import fr.rt.MyPrintAuth.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status addStatus(Status status){

        Date date = new Date();

        status.setDate(date);
        Status newStatus = statusRepository.save(status);

        return newStatus;
    }


}
