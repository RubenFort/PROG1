package modelo;

import java.util.Date;
import java.util.Objects;


public class Persona {
    
    private String NIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private DireccionPostal direccion;    
    private long telefono;
    private Date fechaNacimineto;
    
    //Constructores
    
    //Getters & Setters
    
    //Habria que reescribir equals para que 2 personas sean iguales cuando lo es su DNI

    @Override
    public int hashCode() {
        int hash = 3;
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
