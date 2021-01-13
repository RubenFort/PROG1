package modelo;


public class Contacto {

    //Atributos
    private int id;
    private String nombre;
    private String fechaNacimiento;
    private long telefono;
    private char tipo; //(A)migo,(E)nemigo,(F)amilia,(T)rabajo 
    private boolean tieneCoche;

    //Constructores

    public Contacto() {
    }
      
    public Contacto(String nombre, String fechaNacimiento, long telefono,
                    char tipo, boolean tieneCoche) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.tipo = tipo;
        this.tieneCoche = tieneCoche;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
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
