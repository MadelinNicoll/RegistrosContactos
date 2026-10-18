package com.example.registroscontactos;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String correo;
    private String telefono;
    private String opcion;

    public Contacto(String nombre, String correo, String telefono, String opcion) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.opcion = opcion;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getOpcion() { return opcion; }
}