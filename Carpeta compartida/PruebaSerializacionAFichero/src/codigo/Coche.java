package codigo;

import java.io.Serializable;
import java.util.Date;

public class Coche implements Serializable{

    private String matricula;
    private Date fechaCompra;
    private String nifPropietario;
    private int kilometros;

    public Coche(String matricula, Date fechaCompra, String nifPropietario, int kilometros) {
        this.matricula = matricula;
        this.fechaCompra = fechaCompra;
        this.nifPropietario = nifPropietario;
        this.kilometros = kilometros;
    }

    
    
    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getNifPropietario() {
        return nifPropietario;
    }

    public void setNifPropietario(String nifPropietario) {
        this.nifPropietario = nifPropietario;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", fechaCompra=" + fechaCompra + ", nifPropietario=" + nifPropietario + ", kilometros=" + kilometros + '}';
    }
    
    

}
