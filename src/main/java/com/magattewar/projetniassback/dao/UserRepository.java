package com.magattewar.projetniassback.dao;

import com.magattewar.projetniassback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Query("SELECT u FROM User u JOIN u.role r WHERE r.name =:name")
    public User findByUsername(String username);
}
