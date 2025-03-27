package org.example;

import java.util.*;

 /**
  * Clase agenda: Guarda una serie de contactos.
  * @author dam
  * @version 1.0
  * @since 2015
  */
public class Agenda implements IAgenda {
    private List<Persona> contacts; // Lista de Persona

     /**
     * Constructor para inicializar la lista de contactos, que es un array.
     */
    public Agenda() {
        this.contacts = new ArrayList<>();
    }


     /**
      * Method que añade un contacto a la agenda. Solo añade los contactos en caso de que no existan previamente en
      * la agenda.
      * @param name es el nombre del contacto
      * @param phone es el teléfono del contacto
      */
     @Override
     public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact);
        }
    }

     /**
      * Method para eliminar contactos.
      * @param name es el nombre del contacto a eliminar.
      */
     @Override
     public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }


     /**
      * Method para modificar el número de teléfono de un contacto.
      * @param name es el nombre del contacto
      * @param oldPhone es el anterior número de teléfono del contacto.
      * @param newPhone es el nuevo número de teléfono del contacto.
      */
     @Override
     public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

     /**
      * Method para devolver la lista de contactos.
      * @return la lista de contactos.
      */
     @Override
     public List<Persona> getContacts() {
        return this.contacts;
    }
}