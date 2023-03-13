package fr.rt.MyPrintAuth.services;

import fr.rt.MyPrintAuth.dto.UserDto;
import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.mapper.UserMapper;
import fr.rt.MyPrintAuth.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public List<UserDto> getUsers(){
        return userMapper.toListDto(userRepository.findAll());
    }

    public UserDto getUserById(Integer id){

        Optional<User> user = userRepository.findById(id);

        return userMapper.toDto(user.orElseThrow());
    }

    public UserDto getUserByEmail(String email){
        Optional<User> user = userRepository.findUserByEmail(email);

        return userMapper.toDto(user.orElseThrow());
    }

    @Transactional
    public UserDto modifyUser(Integer id,UserDto userDto){
        



        User oldUser = userRepository.findById(id).orElseThrow();
        User user = userMapper.toUser(userDto);

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setRole(user.getRole());




        return userMapper.toDto(userRepository.save(oldUser));

    }
}
