package com.miportfolio.CAB.controller;

import com.miportfolio.CAB.dto.DtoExpLaboral;
import com.miportfolio.CAB.models.ExpLaboral;
import com.miportfolio.CAB.security.controller.Mensaje;
import com.miportfolio.CAB.service.ExpLabService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://miportfoliocab.web.app")
public class ExpLaboralController {

    @Autowired
    ExpLabService expLabService;

    @GetMapping("/lista")
    public ResponseEntity<List<ExpLaboral>> list() {
        List<ExpLaboral> list = expLabService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExpLaboral dtoExperiencia) {
        if (StringUtils.isBlank(dtoExperiencia.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (expLabService.existsByNombreExp(dtoExperiencia.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }

        ExpLaboral experiencia = new ExpLaboral(
                dtoExperiencia.getNombreExp(),
                dtoExperiencia.getLugarExp(),
                dtoExperiencia.getFechaExp(),
                dtoExperiencia.getDescripcionExp(),
                dtoExperiencia.getImgExp()
        );
        expLabService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExpLaboral dtoExperiencia) {
        if (!expLabService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        if (expLabService.existsByNombreExp(dtoExperiencia.getNombreExp())
                && expLabService.getByNombreExp(dtoExperiencia.getNombreExp()).get().getId() != id) {

            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoExperiencia.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        ExpLaboral explab = expLabService.getOne(id).get();
        explab.setNombreExp(dtoExperiencia.getNombreExp());
        explab.setLugarExp(dtoExperiencia.getLugarExp());
        explab.setFechaExp(dtoExperiencia.getFechaExp());
        explab.setDescripcionExp(dtoExperiencia.getDescripcionExp());
        explab.setImgExp(dtoExperiencia.getImgExp());

        expLabService.save(explab);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expLabService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        expLabService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ExpLaboral> getById(@PathVariable("id") int id) {
        if (!expLabService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        ExpLaboral experiencia = expLabService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

}
