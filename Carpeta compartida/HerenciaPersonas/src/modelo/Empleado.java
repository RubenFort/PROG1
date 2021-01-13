package modelo;

import java.util.Date;

//El motivo por el que esta clase "se marca" como abstracta es que no quiero 
//permitir su instanciación (creacion de objetos)
public abstract class Empleado extends Persona{
    
    private Date fechaAlta; //Fecha de incio de actividad en la empresa
    private double salarioBase = 1500; //Cantidad mínima que todos cobran
    private String emailEmpresa;//Correo como empleado de la empresa
   

    public Empleado(String NIF, String apellido1, String apellido2, String nombre) {
        super(NIF, apellido1, apellido2, nombre);
    }
    
    public double getSalario() {
        return salarioBase;
    }

    @Override
    public boolean pideDiaLibre(Date dia) {
        //Por politica de esta empresa, SIEMPRE se deniega
        return false;
    }

}