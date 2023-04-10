package com.miportfolio.CAB.controller;

import com.miportfolio.CAB.dto.DtoPersona;
import com.miportfolio.CAB.models.Persona;
import com.miportfolio.CAB.security.controller.Mensaje;
import com.miportfolio.CAB.service.PersonaService;
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
@RequestMapping("persona")
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {

   @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //TODO: Agregar multi usuario
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {
//        if (StringUtils.isBlank(dtoPersona.getNombre())) {
//            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//
//        if (personaService.existsByNombre(dtoPersona.getNombre())) {
//            return new ResponseEntity(new Mensaje("Persona existente"), HttpStatus.BAD_REQUEST);
//        }
//
//        Persona persona = new Persona(
//                dtoPersona.getNombre(),
//                dtoPersona.getApellido(),
//                dtoPersona.getTitulo(),
//                dtoPersona.getDescripcion(),
//                dtoPersona.getImgPerfil()
//        );
//        personaService.save(persona);
//        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        if (personaService.existsByNombre(dtoPersona.getNombre())
                && personaService.getByNombre(dtoPersona.getNombre()).get().getId() != id) {

            return new ResponseEntity(new Mensaje("Persona existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setTitulo(dtoPersona.getTitulo());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setImgPerfil(dtoPersona.getImgPerfil());

        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//        if (!personaService.existsById(id)) {
//            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
//        }
//
//        personaService.delete(id);
//        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
//
//    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
