package com.ronald02.demo.service;


import com.ronald02.demo.model.Persona;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonaService {


    private final List<Persona> personas = Arrays.asList(
            new Persona("Ana", 25, "F", "Lima"),
            new Persona("Luis", 34, "M", "Cusco"),
            new Persona("María", 19, "F", "Lima"),
            new Persona("Carlos", 40, "M", "Arequipa"),
            new Persona("Lucía", 30, "F", "Lima"),
            new Persona("José", 50, "M", "Trujillo")
    );


    public List<Persona> getTodas() {
        return personas;
    }

    public Optional<Persona> buscarPorNombre(String nombre) {
        return personas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }



    public List<String> getCiudadesUnicas() {
        return personas.stream()
                .map(Persona::getCiudad)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }


    public List<Persona> getOrdenadasPorEdadDesc() {
        return personas.stream()
                .sorted(Comparator.comparingInt(Persona::getEdad).reversed())
                .collect(Collectors.toList());
    }

    public Map<String, List<Persona>> getAgrupadasPorCiudad() {
        return personas.stream()
                .collect(Collectors.groupingBy(Persona::getCiudad));
    }




}
