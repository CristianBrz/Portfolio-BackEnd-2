package com.miportfolio.CAB.controller;

import com.miportfolio.CAB.dto.DtoEducacion;
import com.miportfolio.CAB.models.Educacion;
import com.miportfolio.CAB.security.controller.Mensaje;
import com.miportfolio.CAB.service.EducacionService;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "https://miportfoliocab.web.app")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existsByNombreEdu(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoEducacion.getNombreEdu(),
                dtoEducacion.getLugarEdu(),
                dtoEducacion.getFechaEdu(),
                dtoEducacion.getDescripcionEdu(),
                dtoEducacion.getImgEdu()
        );
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        if (educacionService.existsByNombreEdu(dtoEducacion.getNombreEdu())
                && educacionService.getByNombreEdu(dtoEducacion.getNombreEdu()).get().getId() != id) {

            return new ResponseEntity(new Mensaje("Educacion existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoEducacion.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setNombreEdu(dtoEducacion.getNombreEdu());
        educacion.setLugarEdu(dtoEducacion.getLugarEdu());
        educacion.setFechaEdu(dtoEducacion.getFechaEdu());
        educacion.setDescripcionEdu(dtoEducacion.getDescripcionEdu());
        educacion.setImgEdu(dtoEducacion.getImgEdu());

        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
