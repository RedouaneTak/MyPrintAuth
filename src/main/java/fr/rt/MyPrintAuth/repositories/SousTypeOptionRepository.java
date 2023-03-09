package fr.rt.MyPrintAuth.repositories;


import fr.rt.MyPrintAuth.entities.SousTypeOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousTypeOptionRepository extends JpaRepository<SousTypeOption,Integer> {
}
