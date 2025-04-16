package com.ronald02.demo.model;

public class Persona {

    private String nombre;
    private int edad;
    private String genero;
    private String ciudad;

    public Persona(String nombre, int edad, String genero, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getGenero() { return genero; }
    public String getCiudad() { return ciudad; }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + genero + ", " + ciudad + ")";
    }


}
