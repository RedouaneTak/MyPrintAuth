package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.Comporte;
import fr.rt.MyPrintAuth.entities.ComportePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComporteRepository extends JpaRepository<Comporte, ComportePK> {
}
