
package modelo;

public class Agenda {
    
    //ATRIBUTOS
    private int CAPACIDAD;
    private int ocupacion;
    private int siguienteId;
    private Contacto [] contactos;
    
    //CONSTRUCTORES
    public Agenda (){
        CAPACIDAD = 10;
        contactos = new Contacto[CAPACIDAD];
        ocupacion = 0;
        siguienteId = 0;
    }
    
    public Agenda (int maxContactos) {
        CAPACIDAD = maxContactos;
        contactos = new Contacto[CAPACIDAD];
        ocupacion = 0;
        siguienteId = 0;
    }

    //GETTERS
    public int getCAPACIDAD() {
        return CAPACIDAD;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public int getSiguienteId() {
        return siguienteId;
    }
    
    //METODOS
    public boolean addContacto (Contacto nuevo) {
        
        if (ocupacion>=CAPACIDAD) {
            return false;
        }
        nuevo.setId(siguienteId);
        contactos[ocupacion]=nuevo;
        ocupacion++;
        siguienteId++;
        return true;
    }
    
    public boolean deleteContactoById (int id) {
        
        if (id<0||id>=siguienteId) {
            return false;
        }
        
        for (int i = 0; i < ocupacion; i++) {
            if (id==contactos[i].getId()) {
                for (int j = i; j < ocupacion-1; j++) {
                    contactos[j]=contactos[j+1];
                }
                ocupacion--;
                return true;
            }
        }
        return false;
    }
    
    public Contacto [] getAllContactos () {
        Contacto [] c = new Contacto[ocupacion];
        
        for (int i = 0; i < ocupacion; i++) {
            c[i]=contactos[i];
        }
        return c;
    } 
    
    public Contacto getContactoById (int id) {
        
        if (id<0||id>=siguienteId){
            return null;
        }
        
        for (int i = 0; i < ocupacion; i++) {
            if (id==contactos[i].getId())
                return contactos[i];
        }
        return null;
    }
    
    public Contacto [] getContactosByTipo (char tipo){
        Contacto [] contactosTipo; 
        int cont=0;
        int j=0;
        
        for (int i = 0; i < ocupacion; i++) {
             if (tipo==contactos[i].getTipo()) {
                 cont++;
             }
        }
        contactosTipo = new Contacto[cont];
             
        for (int i = 0; i < ocupacion; i++) {
            if (tipo==contactos[i].getTipo()) {
                 contactosTipo[j]=contactos[i];
                 j++;
             }
        }
        if (j==0) {
            return null;
        }
        return contactosTipo;
    }
    
    public Contacto [] getContactosByTelefono (long tlf) {
        Contacto [] contactosPorTelefono;
        int cont=0;
        int j=0;
        
        for (int i = 0; i < ocupacion; i++) {
            if (tlf==contactos[i].getTelefono()) {
                cont++;
            }
        }
        contactosPorTelefono = new Contacto[cont];
        
        for (int i = 0; i < ocupacion; i++) {
            if (tlf==contactos[i].getTelefono()) {
                contactosPorTelefono[j]=contactos[i];
                j++;
            }
        }
        if (j==0){
            return null;
        }
        return contactosPorTelefono;
    } 
}
