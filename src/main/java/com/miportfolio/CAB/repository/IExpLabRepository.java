package com.miportfolio.CAB.repository;

import com.miportfolio.CAB.models.ExpLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpLabRepository extends JpaRepository<ExpLaboral, Integer> {

    public Optional<ExpLaboral> findByNombreExp(String nombreExp);

    public boolean existsByNombreExp(String nombreExp);
}
