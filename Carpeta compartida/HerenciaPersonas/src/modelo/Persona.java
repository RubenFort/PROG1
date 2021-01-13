package modelo;

import java.util.Date;
import java.util.Objects;

//Por contener uno o mas metodos abtractos la clase ha de marcarse como abtracta
public abstract class Persona {
    
    private String NIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private DireccionPostal direccion;
    private long telefono; //siempre se dudará entre numérico y string ... para gustos
    private Date fechaNacimiento;
    
    //Constructores

    public Persona(String NIF, String apellido1, String apellido2, String nombre) {
        this.NIF = NIF;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
    }
    
    
    //Getters & Setters
    
    //Este método devuelve el nombre completo formateado de manera "oficial"
    // y es método declarado final para evitar (prohibir) su reescritura
    public final String getNombreOficial(){
        return apellido1 + " " + apellido2 + "," + nombre;
    }
    
    //Al ser abstracto este método(no sabemos escribirlo a este nivel) la clase 
    //ha de marcarse como abstracta
    public abstract boolean pideDiaLibre (Date diaSolicitado);

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.NIF, other.NIF)) {
            return false;
        }
        return true;
    }
    
    
   
}
