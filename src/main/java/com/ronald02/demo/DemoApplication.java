package com.ronald02.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        List<Persona> personas = Arrays.asList(
                new Persona("ronald", 37, "M", "lima"),
                new Persona("sandy", 31, "F", "huanuco"),
                new Persona("maria", 50, "F", "lima")
        );

        Map<String , List<Persona>> listaCiudad = new HashMap<>();

        for (Persona persona : personas) {
            listaCiudad.putIfAbsent(persona.getCiudad(), new ArrayList<>());
            listaCiudad.get(persona.getCiudad()).add(persona);
        }

        System.out.println("personas agregadas por ciudad");
        for(Map.Entry<String , List<Persona>> entry : listaCiudad.entrySet()) {
            System.out.println("ciudad " + entry.getKey());
            for(Persona p : entry.getValue()) {
                System.out.println(" - " + p.getNombre());
            }
        }
    }

}
