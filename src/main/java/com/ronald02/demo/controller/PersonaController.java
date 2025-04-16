package com.ronald02.demo.controller;


import com.ronald02.demo.model.Persona;
import com.ronald02.demo.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService servicio;

    public PersonaController(PersonaService servicio) {
        this.servicio = servicio;
    }


    @GetMapping
    public List<Persona> listar() {
        return servicio.getTodas();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Persona> buscarPorNombre(@PathVariable String nombre) {
        return servicio.buscarPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ciudades")
    public List<String> ciudadesUnicas() {
        return servicio.getCiudadesUnicas();
    }

    @GetMapping("/ordenadas")
    public List<Persona> ordenadasPorEdad() {
        return servicio.getOrdenadasPorEdadDesc();
    }

    @GetMapping("/agrupadas")
    public Map<String, List<Persona>> agrupadasPorCiudad() {
        return servicio.getAgrupadasPorCiudad();
    }

}
