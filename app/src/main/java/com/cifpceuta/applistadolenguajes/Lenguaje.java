package com.cifpceuta.applistadolenguajes;

public class Lenguaje {
    private String nombre;
    private int imagenBorrar;

    public Lenguaje(String nombre, int imagenBorrar) {
        this.nombre = nombre;
        this.imagenBorrar = imagenBorrar;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenBorrar() {
        return imagenBorrar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagenBorrar(int imagenBorrar) {
        this.imagenBorrar = imagenBorrar;
    }
}
