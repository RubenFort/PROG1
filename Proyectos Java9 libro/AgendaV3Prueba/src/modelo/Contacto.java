
package modelo;

public class Contacto {

    //ATRIBUTOS
    private int id;
    private String nombre;
    private String FechaNacimiento;
    private long Telefono;
    private char tipo;
    private boolean tieneCoche;
    
    //CONSTRUCTORES
    public Contacto(){
    }

    public Contacto(String nombre, String FechaNacimiento, long Telefono, char tipo, boolean tieneCocha) {
        this.nombre = nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.Telefono = Telefono;
        this.tipo = tipo;
        this.tieneCoche = tieneCocha;
    }
    
    //GETTERS Y SETTERS

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

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isTieneCoche() {
        return tieneCoche;
    }

    public void setTieneCoche(boolean tieneCoche) {
        this.tieneCoche = tieneCoche;
    }
    
    
}
