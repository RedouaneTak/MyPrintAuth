package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.Status;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {



}
