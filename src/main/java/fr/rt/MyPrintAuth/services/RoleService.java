package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.Role;
import fr.rt.MyPrintAuth.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles(){
        return  roleRepository.findAll();
    }
}
