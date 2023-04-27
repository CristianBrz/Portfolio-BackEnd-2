package com.miportfolio.CAB.controller;

import com.miportfolio.CAB.dto.DtoProyectos;
import com.miportfolio.CAB.models.Proyectos;
import com.miportfolio.CAB.security.controller.Mensaje;
import com.miportfolio.CAB.service.ProyectosService;
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
@RequestMapping("proyectos")
@CrossOrigin(origins = "https://miportfoliocab.web.app")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (proyectosService.existsByNombreProy(dtoProyectos.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyecto = new Proyectos(
                dtoProyectos.getNombreProy(),
                dtoProyectos.getTipoProy(),
                dtoProyectos.getDescripcionProy(),
                dtoProyectos.getUrlProy(),
                dtoProyectos.getImgProy()
        );
        proyectosService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        if (proyectosService.existsByNombreProy(dtoProyectos.getNombreProy())
                && proyectosService.getByNombreProy(dtoProyectos.getNombreProy()).get().getId() != id) {

            return new ResponseEntity(new Mensaje("Proyecto existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoProyectos.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyecto = proyectosService.getOne(id).get();
        proyecto.setNombreProy(dtoProyectos.getNombreProy());
        proyecto.setTipoProy(dtoProyectos.getTipoProy());
        proyecto.setDescripcionProy(dtoProyectos.getDescripcionProy());
        proyecto.setUrlProy(dtoProyectos.getUrlProy());
        proyecto.setImgProy(dtoProyectos.getImgProy());

        proyectosService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Proyectos proyecto = proyectosService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
}
