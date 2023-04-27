package com.miportfolio.CAB.repository;

import com.miportfolio.CAB.models.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Integer> {

    public Optional<Proyectos> findByNombreProy(String nombreProy);

    public boolean existsByNombreProy(String nombreProy);
}
