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
    public void addContacto(Contacto nuevo) {
        if (ocupacion < CAPACIDAD) {
            nuevo.setId(siguienteID);
            contactos[ocupacion] = nuevo;
            siguienteID++;
            ocupacion++;
        } else {
            System.out.println("No se pudo cargar contacto");
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
     
    public Contacto getContactoById (int id){
        if (id<0 || id>=siguienteID) {
            return null;
        }
            for (int i = 0; i < ocupacion; i++) {
                if(contactos[i].getId() == id){
                    return contactos[i];
                }
            }
        return null;
    }

    public boolean dropContacto (int id){
        
        if(id<0 || id>=siguienteID){
            return false;
        }
        for (int i=0; i<ocupacion; i++){
            if(id==contactos[i].getId()){
                for (int j = i; j < ocupacion-1; j++) {
                    contactos[i] = contactos[i + 1];
                }
                ocupacion--;
                return true;
            }
        }
    return false;
    }
}
