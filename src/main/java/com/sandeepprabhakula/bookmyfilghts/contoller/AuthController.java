package com.sandeepprabhakula.bookmyfilghts.contoller;

import com.sandeepprabhakula.bookmyfilghts.data.Users;
import com.sandeepprabhakula.bookmyfilghts.dto.AuthResponse;
import com.sandeepprabhakula.bookmyfilghts.dto.LoginDTO;
import com.sandeepprabhakula.bookmyfilghts.repository.UserRepository;
import com.sandeepprabhakula.bookmyfilghts.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authMan;

    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users) {
        String uid = UUID.randomUUID().toString();
        users.setId(uid);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody LoginDTO loginDTO) throws Exception {
        Authentication auth = authMan.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        Users user = userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(()-> new Exception("Username not found"));
        String uid = user.getId();
        if (auth.isAuthenticated()) {
            return AuthResponse.builder()
                    .uid(uid)
                    .jwtToken(jwtService.generateToken(loginDTO.getEmail()))
                    .email(loginDTO.getEmail())
                    .build();
        } else return new AuthResponse();
    }
}
