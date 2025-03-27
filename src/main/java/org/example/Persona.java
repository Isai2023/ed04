package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase contacto, representa a un contacto con un nombre y un teléfono
 * @author dam
 * @version 1.0
 * @since 2025
 */
public class Persona {
    private String name;
    private List<String> phones;

    /**
     * Constructor para crear un contacto.
     * @param name es el nombre del contacto
     * @param phone es el teléfono del contacto
     */
    public Persona(String name, String phone) {
        this.setName(name);
        this.setPhones(new ArrayList<>());
        this.getPhones().add(phone);
    }

    /**
     * Method para obtener el nombre del contacto
     * @return el nombre del contacto
     */
    public String getName() {
        return this.name;
    }

    /**
     * Obtiene la lista de números de teléfono del contacto
     * @return la lista de teléfonos del contacto
     */
    public List<String> getPhones() {
        return this.phones;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}