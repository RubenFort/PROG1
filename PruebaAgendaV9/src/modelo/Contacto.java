package modelo;

import java.util.Date;


public class Contacto {

    //Atributos
    private int id;
    private String nombre;
    private Date fecha;
    private long telefono;
    private Tipo tipo; 
    private boolean tieneCoche;

    //Constructores
    public Contacto() {
    }
      
    public Contacto(String nombre, Date fecha, long telefono,
                    Tipo tipo, boolean tieneCoche) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.tipo = tipo;
        this.tieneCoche = tieneCoche;
    }
    
    public Contacto(String registro){
        
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

}
