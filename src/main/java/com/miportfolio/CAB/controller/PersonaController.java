package com.miportfolio.CAB.controller;

import com.miportfolio.CAB.models.Persona;
import com.miportfolio.CAB.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService persoServ;

    @GetMapping("/persona/mostrar")
//    @ResponseBody
    public List<Persona> getPersona() {
        return persoServ.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String crearPersona(@RequestBody Persona pers) {
        persoServ.savePersona(pers);
        return "Usuario creado satisfactoriamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        persoServ.deletePersona(id);
        return "Usuario eliminado satisfactoriamente";
    }

        @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("imgPerfil") String nuevaImg) {
        Persona persona = persoServ.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setTitulo(nuevoTitulo);
        persona.setDescripcion(nuevaDescripcion);
        persona.setImgPerfil(nuevaImg);

        persoServ.savePersona(persona);
        return persona;
    }

    @GetMapping("/persona/mostrar/perfil")
    public Persona findPersona() {
        return persoServ.findPersona((long) 2);
    }

}
