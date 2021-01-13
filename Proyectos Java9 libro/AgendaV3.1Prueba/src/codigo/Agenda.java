
package codigo;

public class Agenda {
    
    //ATRIBUTOS
    private int CAPACIDAD;
    private int ocupacion;
    private int siguienteId;
    private Contacto [] contactos;
    
    //CONSTRUCTORES
    public Agenda () {
        CAPACIDAD=10;
        contactos = new Contacto [CAPACIDAD];
        ocupacion=0;
        siguienteId=0;
    }
         
    public Agenda (int maxCapacidad) {
        CAPACIDAD=maxCapacidad;
        contactos = new Contacto[CAPACIDAD];
        ocupacion=0;
        siguienteId=0;
    }
    
    //METODOS

    public int getCAPACIDAD() {
        return CAPACIDAD;
    }
    
    public boolean addContacto(Contacto nuevo){
        
        if(ocupacion<CAPACIDAD){
            
            nuevo.setId(ocupacion);
            contactos[ocupacion]=nuevo;
            ocupacion++;
            siguienteId++;
            return true;  
        }
        return false; 
    }
    
    public Contacto [] getAllContactos (){
        Contacto [] listaContactos = new Contacto[ocupacion];
        
        for (int i = 0; i < ocupacion; i++) {
            listaContactos[i]=contactos[i];
        }
        return listaContactos;
    }
    
    public Contacto getContactoById (int id) {
        
        Contacto c;
        
        if (id<0||id>siguienteId) {
            return null;
        }

        for (int i = 0; i < ocupacion; i++) {
            
            if (id==contactos[i].getId()){
                
                c=contactos[i];
                return c;
            }
        }
        return null;
    }
    
    public boolean deleteContactoById (int id) {
        
        if(id<0||id>=siguienteId){
            return false;
        }
        for (int i = 0; i < ocupacion; i++) {
            if (id==contactos[i].getId()){
                for (int j = i; j < ocupacion-1; j++) {
                    contactos[j]=contactos[j+1];
                }
                ocupacion--;
                return true;
            }
        }
        return false;
    }
    
    public Contacto getContactoByTipo (char tipo){
        
        Contacto c;
        
        for (int i = 0; i < ocupacion; i++) {
            if (tipo==contactos[i].getTipo()) {
                c=contactos[i];
                return c;
            }
        }
        return null;
    }
    
    public Contacto getContactoByTelefono (long telefono){
        
        Contacto c;
        
        for (int i = 0; i < ocupacion; i++) {
            if (telefono==contactos[i].getTelefono()) {
                c=contactos[i];
                return c;
            }
        }
        return null;
    }
    
}
