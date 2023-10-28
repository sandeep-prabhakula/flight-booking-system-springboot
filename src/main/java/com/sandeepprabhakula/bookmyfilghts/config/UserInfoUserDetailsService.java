package com.sandeepprabhakula.bookmyfilghts.config;

import com.sandeepprabhakula.bookmyfilghts.data.Users;
import com.sandeepprabhakula.bookmyfilghts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmail(email);
        return user.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("invalid user"));
    }
}
