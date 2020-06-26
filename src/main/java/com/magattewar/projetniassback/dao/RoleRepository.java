package com.magattewar.projetniassback.dao;

import com.magattewar.projetniassback.model.Role;
import com.magattewar.projetniassback.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(RoleName name);
}
