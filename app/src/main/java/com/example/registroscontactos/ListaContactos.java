package com.example.registroscontactos;

import java.util.ArrayList;
import java.util.List;

public class ListaContactos {
    private static List<Contacto> lista = new ArrayList<>();

    public static List<Contacto> getLista() {
        return lista;
    }

    public static void agregarContacto(Contacto contacto) {
        lista.add(contacto);
    }
}