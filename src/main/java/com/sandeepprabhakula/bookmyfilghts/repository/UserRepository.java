package com.sandeepprabhakula.bookmyfilghts.repository;

import com.sandeepprabhakula.bookmyfilghts.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    Optional<Users>findByEmail(String email);
}
