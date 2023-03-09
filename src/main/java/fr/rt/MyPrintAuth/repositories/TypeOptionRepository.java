package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.TypeOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOptionRepository extends JpaRepository<TypeOption,Integer> {
}
