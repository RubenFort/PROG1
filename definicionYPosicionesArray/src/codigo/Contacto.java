package codigo;

import java.util.Date;

public class Contacto {

    //**********ATRIBUTOS*********
    //Al ser private, no se puede acceder a ellos desde fuera de las clase
    private int id; //Valor 0 por defecto
    private String nombres;
    private String fechaNacimiento; //Valor Null por defecto
    private long telefono;//Valor 0 por defecto
    private char tipo; //(A)migo, (E)nemigo, (F)amiliar y (T)rabajo
    private boolean tieneCoche;

    //***********CONSTRUCTORES**********
    public Contacto (){ //Constructor por defecto, si no hay otro constructor no hace falta ponerlo
    }
    
    public Contacto(int id, String nombres, String fecha, long telefono, char tipo, boolean tieneCoche) {
        this.id = id;
        this.nombres = nombres;
        this.fechaNacimiento = fecha;
        //parsear un String a Date
        this.telefono = telefono;
        this.tipo = tipo;
        this.tieneCoche = tieneCoche;
    }
    
    
    //**********GETTERS Y SETTERS**********
    
    public int getId (){
        return id;
    }
    
    public void setId (int id){
        this.id=id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFecha() {
        return fechaNacimiento;
    }

    public void setFecha(String fecha) {
        this.fechaNacimiento = fecha;
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
