package modelo;

import java.util.Vector;

public class Agenda {
  
/************************ ATRIBUTOS ************************/
    private int siguienteID;
    private final Vector <Contacto> contactos;
    private final Vector <Usuario> usuarios;
    
    
/************************ CONSTRUCTORES ************************/
    //Crea una agenda vacía con una capacidad por defecto de la capacidad
    //inicial por defecto de Vector(La API actual dice que 10 por defecto)
    public Agenda() {
        contactos = new Vector();
        siguienteID = 0;
        usuarios = new Vector ();
    }
    
    //Crea una agenda vacía con una capacidad de maxContactos
    public Agenda(int capacidadInicial) {
        contactos = new Vector(capacidadInicial);
        siguienteID = 0;
        usuarios = new Vector();
    }
    
    
/************************ METODOS ************************/
    
    public int getSiguienteID (){
        return siguienteID;
    }

    public void setSiguienteID(int siguienteID) {
        this.siguienteID = siguienteID;
    }
    
    ////------------ Añade un usuario //------------
    public boolean addUsuario (Usuario u) {
        return usuarios.add(u);
    }
    
    ////------------ Compara si la clave y usuario escritas son correctas //------------
    public int compruebaUsuario (String usuario, String clave){
        Usuario buscado = new Usuario(usuario, clave);
        
        return usuarios.indexOf(buscado);
    }
    
    //------------ Añade un contacto desdse el fichero ------------
    public boolean addContactoFromBD(Contacto c) {
        return contactos.add(c);
    }
    
    //------------ Añade un contacto ------------
    public boolean addContacto (Contacto nuevo){
            nuevo.setId(siguienteID);
            boolean añadido = contactos.add(nuevo);
            if (añadido) {
                siguienteID++;
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
         
        return contactos.toArray(todos);
    }
    
    //------------ Devuelve un contacto ------------
    /*Busca y devuleve, si existe, el contacto cuya id se corresponde con
    el solicitado, si no existe devuelve null*/
    public Contacto getContactoById (int id){
    //Método que si encuentra el contacto lo devulve, si no, devuelve null
    
        if (id<0 || id>=siguienteID){
            return null;
        }
        
        //Creamos un contacto con el id a buscar
        Contacto buscado = new Contacto(id);
        
        //localizamos el indice donde esta el contacto con el id buscado
        int indice = contactos.indexOf(buscado);
        
        if (indice==-1){
            return null;
        }
            
        return contactos.get(indice);
    }
    
    //------------ Borra un contacto ------------
    /*Busca y borra, si existe, el contacto cuya id se corresponde con
    el solicitado, si no existe devuleve false*/
    public boolean deleteContactoById (int id){
    //Método que si encuentra el ID a borrar, lo borra y devuleve true, si no devulve false
    
        if (id<0 || id>=siguienteID){
            return false;
        }
        Contacto buscado = new Contacto(id);

        return contactos.remove(buscado);
       
    } 

}
