package agenda;

import java.util.Vector;

public class Agenda {

    //Atributos de la agenda
    private int siguienteID;
    private final Vector<Contacto> contactos;

    //Crea una agenda vacía con una capacidad por defecto de la capacidad
    //inicial por defecto de Vector (la API actual dice 10 elementos)
    public Agenda() {
        contactos = new Vector();
        siguienteID = 0;
    }

    //Crea una agenda vacía con una capacidad de maxContactos
    public Agenda(int capacidadInicial) {
        contactos = new Vector(capacidadInicial);
        siguienteID = 0;
    }

    public int getSiguienteID() {
        return siguienteID;
    }

    public void setSiguienteID(int siguienteID) {
        this.siguienteID = siguienteID;
    }

    
    //Si hay espacio libre añade el contacto al final (le asigna como ID es
    //valor actual de siguienteID y posteriormente lo incrementa)de la agenda y 
    //devuelve true, si no hay espacio libre no lo añade y devuelve false
    public boolean addContacto(Contacto nuevo) {
        nuevo.setId(siguienteID);
        boolean añadido = contactos.add(nuevo);
        if (añadido) {
            siguienteID++;
            return true;
        } else {
            return false;
        }
    }
    
    //Si hay espacio libre en la agenda, ñade el contacto a la agenda respetando
    //el ID que trae el contacto y devuelve true. Si no puede añadirlo devuelve
    //false.
    public boolean addContactoFromFile(Contacto c){
        return contactos.add(c);
    }

    //Devuelve un array de Contacto de capacidad y tamaño igual al número
    //de contactos que hay actualmente en la agenda
    public Contacto[] getAllContactos() {
        Contacto[] array = new Contacto[contactos.size()];
        return contactos.toArray(array);
    }

    //Busca y devuelve, si existe, el contacto cuya id se corresponde con
    //el solicitado. Si no existe devuelve null
    public Contacto getContactoById(int id) {

        if (id < 0 || id >= siguienteID) {
            return null;
        }

        //Creamos un contacto con el id a buscar
        Contacto buscado = new Contacto(id);
        
        //Localizamos el índice donde está el Contacto con el id buscado
        int indice = contactos.indexOf(buscado);
        
        if(indice==-1){
            return null;
        }
        
        buscado  = contactos.get(indice);
        
        return buscado;
        
    }

    //Busca, borra y devuelve true, si existe, el contacto cuya id se corresponde
    //con el solicitado. Si no existe devuelve false
    public boolean deleteContactoById(int id) {

        if (id < 0 || id >= siguienteID) {
            return false;
        }
        
        Contacto aBorrar = new Contacto(id);
        
        return contactos.remove(aBorrar);

    }

}
