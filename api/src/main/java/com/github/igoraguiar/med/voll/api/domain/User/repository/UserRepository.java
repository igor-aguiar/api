package com.github.igoraguiar.med.voll.api.domain.User.repository;

import com.github.igoraguiar.med.voll.api.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByName(String username);
}
