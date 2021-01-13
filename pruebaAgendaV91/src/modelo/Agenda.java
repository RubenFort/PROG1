package modelo;

public class Agenda {
    
    private int siguienteId;
    private int ocupacion;
    private int CAPACIDAD;
    private Contacto[] contactos;

    public Agenda(int cap) {
        siguienteId = 0;
        ocupacion = 0;
        CAPACIDAD = cap;
        contactos = new Contacto[CAPACIDAD] ;
    }
    
    public Agenda() {
        siguienteId = 0;
        ocupacion = 0;
        CAPACIDAD = 10;
        contactos = new Contacto[CAPACIDAD] ;
    }
    
    public void addContacto(Contacto c){
        c.setId(siguienteId);
        contactos[ocupacion]=c;
        ocupacion++;
        siguienteId++;
    }

    public Contacto[] getAllContactos() {
        Contacto[] lista= new Contacto[ocupacion];
        for (int i = 0; i < ocupacion; i++) {
            lista[i] = contactos[i];
        }
        return lista;
    }

    public Contacto getContactoById(int id) {
        Contacto c;
        
        if (id<0||id>=siguienteId) {
            return null;
        }
        for (int i = 0; i < ocupacion; i++) {
            if(id==contactos[i].getId()){
                c=contactos[i];
                return c;
            }
        }
        return null;
    }

    public boolean deleteContacto(int id) {
        Contacto c;
        
        if (id<0||id>=siguienteId) {
            return false;
        }
        for (int i = 0; i < ocupacion; i++) {
            if(id==contactos[i].getId()){
                for (int j = i; j < ocupacion-1; j++) {
                    contactos[j]=contactos[j+1];
                }
                ocupacion--;
                return true;
            }
        }
        return false;
    }
    
    
    
}
