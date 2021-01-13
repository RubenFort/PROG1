package codigo;

import java.io.Serializable;
import java.util.Date;

public class Coche implements Serializable{
    
    private String matricula;
    private String nifPropietario;
    private int kilometros;
    private Date fechaCompra;

    public Coche(String matricula, String nifPropietario, int kilometros, Date fechaCompra) {
        this.matricula = matricula;
        this.nifPropietario = nifPropietario;
        this.kilometros = kilometros;
        this.fechaCompra = fechaCompra;
    }
    
    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", nifPropietario=" + nifPropietario + ", kilometros=" + kilometros + ", fechaCompra=" + fechaCompra + '}';
    }
}
