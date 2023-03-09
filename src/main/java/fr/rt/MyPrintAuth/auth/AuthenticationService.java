package fr.rt.MyPrintAuth.auth;


import fr.rt.MyPrintAuth.config.JwtService;
import fr.rt.MyPrintAuth.entities.Role;
import fr.rt.MyPrintAuth.entities.User;
import fr.rt.MyPrintAuth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse registerUser(RegisterRequest request) {

         Optional<User> userOptional = repository.findUserByEmail(request.getEmail());

         if(userOptional.isPresent())
             return AuthenticationResponse.builder().build();

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(1,"USER"))
                .build();
        repository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse registerStaff(RegisterRequest request) {

        Optional<User> userOptional = repository.findUserByEmail(request.getEmail());

        if(userOptional.isPresent())
            return AuthenticationResponse.builder().build();

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(2,"STAFF"))
                .build();
        repository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {

        Optional<User> userOptional = repository.findUserByEmail(request.getEmail());

        if(userOptional.isPresent())
            return AuthenticationResponse.builder().build();

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(3,"ADMIN"))
                .build();
        repository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );

        var user = repository.findUserByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
