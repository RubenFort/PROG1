package modelo;

public class Agenda {

    //Atributos de la agenda
    private final int CAPACIDAD;
    private int ocupacion;
    private int siguienteID;
    private Contacto[] contactos;

    //Constructores
    public Agenda() {
        CAPACIDAD = 10;
        contactos = new Contacto[CAPACIDAD];
        ocupacion = 0;
        siguienteID = 0;
    }

    public Agenda(int maxContactos) {
        CAPACIDAD = maxContactos;
        contactos = new Contacto[CAPACIDAD];
        ocupacion = 0;
        siguienteID = 0;
    }

    public int getCAPACIDAD() {
        return CAPACIDAD;
    }
    
    
    
    

}
