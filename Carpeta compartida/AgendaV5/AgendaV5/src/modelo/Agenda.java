package modelo;

public class Agenda {

    //Atributos de la agenda
    private final int CAPACIDAD;
    private int ocupacion;
    private int siguienteID;
    private final Contacto[] contactos;

    //Crea una agenda vacía con una capacidad por defecto de 10 contactos
    public Agenda() {
        CAPACIDAD = 10;
        contactos = new Contacto[CAPACIDAD];
        ocupacion = 0;
        siguienteID = 0;
    }

    //Crea una agenda vacía con una capacidad de maxContactos
    public Agenda(int maxContactos) {
        CAPACIDAD = maxContactos;
        contactos = new Contacto[CAPACIDAD];
        ocupacion = 0;
        siguienteID = 0;
    }

    //Devuelve la capacidad de la agenda
    public int getCAPACIDAD() {
        return CAPACIDAD;
    }

    //Si hay espacio libre añade el contacto al final de la agenda y devuelve
    //true, si no hay espacio libre no lo añade y devuelve false
    public boolean addContacto(Contacto nuevo) {
        if (ocupacion < CAPACIDAD) {
            nuevo.setId(siguienteID);
            contactos[ocupacion] = nuevo;
            siguienteID++;
            ocupacion++;
            return true;
        } else {
            return false;
        }
    }

    //Devuelve un array de Contacto de capacidad y tamaño igual al número
    //de contactos que hay actualmente en la agenda
    public Contacto[] getAllContactos() {
        Contacto[] todos = new Contacto[ocupacion];
        for (int i = 0; i < ocupacion; i++) {
            todos[i] = contactos[i];
        }
        return todos;
    }

    //Busca y devuelve, si existe, el contacto cuya id se corresponde con
    //el solicitado. Si no existe devuelve null
    public Contacto getContactoById(int id) {

        if (id < 0 || id >= siguienteID) {
            return null;
        }

        for (int i = 0; i < ocupacion; i++) {
            if (contactos[i].getId() == id) {
                return contactos[i];
            }
        }
        return null;
    }

    //Busca, borra y devuelve true, si existe, el contacto cuya id se corresponde
    //con el solicitado. Si no existe devuelve false
    public boolean deleteContactoById(int id) {

        if (id < 0 || id >= siguienteID) {
            return false;
        }

        for (int i = 0; i < ocupacion; i++) {
            if (contactos[i].getId() == id) {
                for (int j = i + 1; j < ocupacion; j++) {
                    contactos[j - 1] = contactos[j];
                }
                ocupacion--;
                return true;
            }
        }

        return false;
    }

}
