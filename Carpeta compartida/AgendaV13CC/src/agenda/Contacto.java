package agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Contacto {

    //Atributos
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private long telefono;
    private Tipo tipo; 
    private boolean tieneCoche;

    //Constructores
    private Contacto() {
        
    }

    public Contacto(int id) {
        this.id = id;
    }
      
    public Contacto(String nombre, Date fechaNacimiento, long telefono,
                    Tipo tipo, boolean tieneCoche) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.tipo = tipo;
        this.tieneCoche = tieneCoche;
    }
    
    public Contacto(String registro) throws RegistroContactoMalFormadoException{
        
        //id#nombre#fechaNacimiento#telefono#tipo#tieneCoche
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String[] campos = registro.split("#");
        
        try {
            this.id = Integer.parseInt(campos[0]);
            this.nombre = campos[1];
            this.fechaNacimiento = sdf.parse(campos[2]);
            this.telefono = Long.parseLong(campos[3]);
            this.tipo = Tipo.valueOf(campos[4]);
            this.tieneCoche = Boolean.parseBoolean(campos[5]);         
        } catch (Exception e) {
            throw new RegistroContactoMalFormadoException();
        }
        
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isTieneCoche() {
        return tieneCoche;
    }

    public void setTieneCoche(boolean tieneCoche) {
        this.tieneCoche = tieneCoche;
    }

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
        final Contacto other = (Contacto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public String toRegistro(){
        //Devuelve un String con el formato de un registro
        //id#nombre#fechaNacimiento#telefono#tipo#tieneCoche
        String registro;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        registro = id + "#" + nombre + "#" + sdf.format(fechaNacimiento) + "#" +
                    telefono + "#" + tipo + "#" + tieneCoche;
        
        return registro;
    }

}
