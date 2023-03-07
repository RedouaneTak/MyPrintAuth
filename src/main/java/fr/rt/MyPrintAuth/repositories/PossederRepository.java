package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.Adresse;
import fr.rt.MyPrintAuth.entities.Posseder;
import fr.rt.MyPrintAuth.entities.PossederPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossederRepository extends JpaRepository<Posseder, PossederPK> {


    void deleteByPossederPK_IdUserAndPossederPK_Adresse(int possederPK_idUser, Adresse possederPK_adresse);

    List<Posseder> findPossedersByPossederPK_IdUser(Integer id);
}
