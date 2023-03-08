package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){

        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public void modifyUser(Integer id,String firstName,String lastName,String email,String password){
        

        User oldUser = userRepository.findById(id).orElseThrow();

        oldUser.setEmail(email);
        oldUser.setFirstName(firstName);
        oldUser.setLastName(lastName);
        oldUser.setPassword(passwordEncoder.encode(password));


    }
}
