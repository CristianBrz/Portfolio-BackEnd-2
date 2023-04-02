package com.miportfolio.CAB.controller;

import com.miportfolio.CAB.dto.DtoSkills;
import com.miportfolio.CAB.models.Skills;
import com.miportfolio.CAB.security.controller.Mensaje;
import com.miportfolio.CAB.service.SkillsService;
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
@RequestMapping("skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills) {
        if (StringUtils.isBlank(dtoSkills.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (skillsService.existsByNombreSkill(dtoSkills.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(
                dtoSkills.getNombreSkill(),
                dtoSkills.getProgreso()
        );

        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        if (skillsService.existsByNombreSkill(dtoSkills.getNombreSkill())
                && skillsService.getByNombreSkill(dtoSkills.getNombreSkill()).get().getId() != id) {

            return new ResponseEntity(new Mensaje("Experiencia existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoSkills.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Campo obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = skillsService.getOne(id).get();
        skills.setNombreSkill(dtoSkills.getNombreSkill());
        skills.setProgreso(dtoSkills.getProgreso());

        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no exixte"), HttpStatus.NOT_FOUND);
        }

        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

}
