package modelo;

public class Agenda {

    //ATRIBUTOS
    private final int CAPACIDAD;
    private int ocupacion;
    private int siguienteID;
    private final Contacto[] contactos;

    //CONSTRUCTORES
    public Agenda (){
        CAPACIDAD=10;
        ocupacion=0;
        siguienteID=0;
        contactos=new Contacto[CAPACIDAD];
    }
    
    public Agenda (int maxContactos){
        CAPACIDAD=maxContactos;
        ocupacion=0;
        siguienteID=0;
        contactos=new Contacto[maxContactos];
    }

    public int getCAPACIDAD() {
        return CAPACIDAD;
    }
    
    public boolean addContacto (Contacto nuevo){

        if (ocupacion<CAPACIDAD) {
            nuevo.setId(siguienteID);
            contactos[ocupacion] = nuevo;
            ocupacion++;
            siguienteID++;
             return true;
        } else {
            return false;
        }
    }
    
    public Contacto[] getAllContactos (){
        Contacto [] contactosExistentes = new Contacto[ocupacion];
        
        for (int i = 0; i < ocupacion; i++) {
            contactosExistentes[i] = contactos[i];
        }
        return contactosExistentes;
    } 
    
    public Contacto getContactoById (int id){
        
        if (id<0||id>=siguienteID){
            return null;
        }
        
        for (int i = 0; i < ocupacion; i++) {
            if (id==contactos[i].getId()) {
            return contactos[i];
            }
        }
        return null;
    }
    
    public boolean dropContacto (int id) {
        
        if (id<0||id>CAPACIDAD) {
            return false;
        }
        
        for (int i = 0; i < ocupacion; i++) {
            if(id==contactos[i].getId()){
                for (int j = i; j < ocupacion-1; j++) {
                    contactos[j]=contactos[j+1];
                    ocupacion--;
                }
                return true;
            }
        }
        return false;
    }
    
}
    

