package codigo;

import java.util.Date;
import java.util.Objects;

public class Trabajador {

    private String nif;
    private String nombre;
    private Date fechaNacimiento;
    private double salario;

    public Trabajador() {
    }
    
    //Constructor Dummy
    public Trabajador(String nif) {
        this.nif = nif;
    }

    public Trabajador(String nif, String nombre, Date fechaNacimiento, double salario) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    /* @Override
    public boolean equals(Object otro) { //manualamente

        Trabajador otroTrabajador;

        try {
            otroTrabajador = (Trabajador) otro;
            String nifOtro = otroTrabajador.getNif();
            String nifEste = this.nif;

            return nifEste.equals(nifOtro);
            
        } catch (Exception e) {
            return false;
        }

        //   return nif.equals(otro.getNif());
    }*/
    //creado automaticamente con el entorno
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
        Trabajador other = (Trabajador) obj;

        return this.nif.equals(other.getNif());

    }

}
