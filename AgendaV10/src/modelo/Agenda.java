package modelo;

import java.util.Vector;

public class Agenda {

    
/************************ ATRIBUTOS ************************/
    private final int CAPACIDAD;
    private int ocupacion;
    private int siguienteID;
    private Vector <Contacto> contactos;

    
/************************ CONSTRUCTORES ************************/
    //Crea una agenda vacía con una capacidad de 10
    public Agenda() {
        CAPACIDAD = 10;
        contactos = new Vector(CAPACIDAD);
        ocupacion = 0;
        siguienteID = 0;
    }
    
    //Crea una agenda vacía con una capacidad de maxContactos
    public Agenda(int maxContactos) {
        CAPACIDAD = maxContactos;
        contactos = new Vector(CAPACIDAD);
        ocupacion = 0;
        siguienteID = 0;
    }
    

/************************ METODOS ************************/
    //Devuelve la capacidad de la agenda
    public int getCAPACIDAD() {
        
        return CAPACIDAD;
    }
    
    //------------ Añade un contacto ------------
    /*Si hay espacio libre añade el contacto al final de la agenda y devuelve
    true, si no hay espacio libre no lo añade y devuelve false*/
    public boolean addContacto (Contacto nuevo){
    
        if (ocupacion<CAPACIDAD) {
            nuevo.setId(siguienteID++);
            contactos.add(nuevo);
            ocupacion++;
            return true;
        } else {
            return false;
        }
    }
    
    //------------ Devuelve todos los contactos ------------
    /*Devuelve un array de contactos de capacidad y tamaño igual al numero de
    contactos que hay actualmente en la agenda*/
    public Contacto[] getAllContactos (){
    //Devuelve todos los contactos, pero no devolvemos contactos[], sus indices vacíos no los devolvemos.
    //Devolvemos una copia de contactos[] llamada lista[] con los valores que hay en contactos[], pero sin copiar los indices vacíos.
    //La CAPACIDAD de lista[] es igual al número de indices no vacios de contactos[].
        Contacto[] todos = new Contacto[contactos.size()];
        todos= contactos.toArray(todos);
        
        return todos;
    }
    
    //------------ Devuelve un contacto ------------
    /*Busca y devuleve, si existe, el cintacto cuya id se corresponde con
    el solicitado, si no existe devuleve null*/
    public Contacto getContactoById (int id){
    //Método que si encuentra el contacto lo devulve, si no, devuelve null
    
        if (id<0 || id>=siguienteID){
            return null;
        }
        for (int i = 0; i < ocupacion; i++) {
            if(contactos.get(i).getId() == id){
                return contactos.get(i);
            }
        }
        return null;
    }
    
    //------------ Borra un contacto ------------
    /*Busca y borra, si existe, el contacto cuya id se corresponde con
    el solicitado, si no existe devuleve false*/
    public boolean deleteContactoById (int id){
    //Método que si encuentra el ID a borrar, lo borra y devuleve true, si no devulve false
    
        if (id<0 || id>=siguienteID){
            return false;
        }
        for (int i = 0; i < ocupacion; i++) {
            if (contactos.get(i).getId() == id) {
                contactos.remove(i);
                ocupacion--;
                return true;
            }
        }
        return false;
    }
    
    //------------ buscar contactos por tipo ------------
//    public Contacto[] getContactosByTipo (Tipo tipo){
//        Contacto c = new Contacto();
//        int j=0;
//        int cont = 0;
//        
//        for (int i = 0; i< ocupacion; i++) {
//            if(tipo==contactos[i].getTipo())
//                cont++;   
//        }
//        Contacto[] todos=new Contacto[cont];
//        for (int i = 0; i< ocupacion; i++) {
//            if(tipo==contactos[i].getTipo())
//                todos[j]=contactos[i];
//                j++;
//        }
//        
//        return todos;
//    }
//    
//    public Contacto getContactosByTelefono(long telefono) {
//        Contacto c = new Contacto();
//        int j=0;
//        
//        for (int i = 0; i< ocupacion; i++) {
//            if(telefono==contactos[i].getTelefono())
//                c=contactos[i];
//            
//        }
//        return c;
//    }
    
}
