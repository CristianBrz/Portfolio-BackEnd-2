package com.miportfolio.CAB.security.repository;

import com.miportfolio.CAB.security.entity.Rol;
import com.miportfolio.CAB.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolRepository extends JpaRepository<Rol, Integer>{
    
        Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
