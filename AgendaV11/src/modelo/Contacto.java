package modelo;

import java.util.Date;

public class Contacto {

    //Atributos
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private long telefono;
    private Tipo tipo; //(A)migo,(E)nemigo,(F)amilia,(T)rabajo 
    private boolean tieneCoche;

    //Constructores
    public Contacto() {
    }
      
    public Contacto(String nombre, Date fechaNacimiento, long telefono,
                    Tipo tipo, boolean tieneCoche) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.tipo = tipo;
        this.tieneCoche = tieneCoche;
    }
    
    //Constructor Dummy
    public Contacto(int id) {
        this.id = id;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Contacto other = (Contacto) obj;
        
         return (this.id == other.getId());
    }

    
    
}
