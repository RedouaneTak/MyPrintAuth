package fr.rt.MyPrintAuth.repositories;

import fr.rt.MyPrintAuth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
}