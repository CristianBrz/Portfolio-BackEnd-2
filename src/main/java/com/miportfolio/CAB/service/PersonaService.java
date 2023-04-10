package com.miportfolio.CAB.service;

import com.miportfolio.CAB.models.Persona;
import com.miportfolio.CAB.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {

    @Autowired
    IPersonaRepository iPersoRepo;

    public List<Persona> list() {
        return iPersoRepo.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return iPersoRepo.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return iPersoRepo.findByNombre(nombre);
    }

    public void save(Persona persona) {
        iPersoRepo.save(persona);
    }

    public void delete(int id) {
        iPersoRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return iPersoRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iPersoRepo.existsByNombre(nombre);
    }

}
