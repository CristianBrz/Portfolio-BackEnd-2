package com.miportfolio.CAB.repository;

import com.miportfolio.CAB.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository  extends JpaRepository<Persona, Long> {
    
}
