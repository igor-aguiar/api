package com.github.igoraguiar.med.voll.api.domain.User.repository;

import com.github.igoraguiar.med.voll.api.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
