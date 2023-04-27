package com.miportfolio.CAB.service;

import com.miportfolio.CAB.models.Proyectos;
import com.miportfolio.CAB.repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {

    @Autowired
    IProyectosRepository iProyectoRepository;

    public List<Proyectos> list() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return iProyectoRepository.findById(id);
    }

    public Optional<Proyectos> getByNombreProy(String nombreProy) {
        return iProyectoRepository.findByNombreProy(nombreProy);
    }

    public void save(Proyectos proyecto) {
        iProyectoRepository.save(proyecto);
    }

    public void delete(int id) {
        iProyectoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iProyectoRepository.existsById(id);
    }

    public boolean existsByNombreProy(String nombreProy) {
        return iProyectoRepository.existsByNombreProy(nombreProy);
    }

}
