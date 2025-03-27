package org.example;

import java.util.*;

 /**
  * Clase agenda: Guarda una serie de contactos.
  * @author dam
  * @version 1.0
  * @since 2015
  */
public class Agenda {
    private List<Contacto> contacts; // Lista de Contacto

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
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Contacto c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Contacto newContact = new Contacto(name, phone);
            contacts.add(newContact);
        }
    }

     /**
      * Method para eliminar contactos.
      * @param name es el nombre del contacto a eliminar.
      */
    public void removeContact(String name) {
        Iterator<Contacto> it = contacts.iterator();

        while (it.hasNext()) {
            Contacto c = it.next();

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
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Contacto c : contacts) {
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
    public List<Contacto> getContacts() {
        return this.contacts;
    }
}