package fr.rt.MyPrintAuth.services;


import fr.rt.MyPrintAuth.repositories.ComporteRepository;
import org.springframework.stereotype.Service;

@Service
public class ComporteService {

    private final ComporteRepository comporteRepository;

    public ComporteService(ComporteRepository comporteRepository) {
        this.comporteRepository = comporteRepository;
    }
}
