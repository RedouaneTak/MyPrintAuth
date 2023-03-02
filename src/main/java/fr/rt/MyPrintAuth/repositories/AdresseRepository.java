package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Integer> {


}
