package com.miportfolio.CAB.service;

import com.miportfolio.CAB.models.ExpLaboral;
import com.miportfolio.CAB.repository.IExpLabRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExpLabService {

    @Autowired
    IExpLabRepository iExpLabRepository;

    public List<ExpLaboral> list() {
        return iExpLabRepository.findAll();
    }

    public Optional<ExpLaboral> getOne(int id) {
        return iExpLabRepository.findById(id);
    }

    public Optional<ExpLaboral> getByNombreExp(String nombreExp) {
        return iExpLabRepository.findByNombreExp(nombreExp);
    }

    public void save(ExpLaboral exp) {
        iExpLabRepository.save(exp);
    }

    public void delete(int id) {
        iExpLabRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iExpLabRepository.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp) {
        return iExpLabRepository.existsByNombreExp(nombreExp);
    }
}
