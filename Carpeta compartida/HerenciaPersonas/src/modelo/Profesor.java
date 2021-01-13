package modelo;

import java.util.Vector;

public class Profesor extends Empleado{

    private Departamento departamento;
    private Vector<Asignatura> asignaturasImpartidas;
    private boolean direccionDepartamento;
    private static final int COMPLEMENTO_DIRECCION = 400;

    public Profesor(String NIF, String apellido1, String apellido2, String nombre, Departamento departamento) {
        super(NIF, apellido1, apellido2, nombre);
        this.departamento = departamento;
        asignaturasImpartidas = new Vector<>();
    }

    public void setDireccionDepartamento(boolean direccionDepartamento) {
        this.direccionDepartamento = direccionDepartamento;
    }

    @Override
    public double getSalario() {
        double salario = super.getSalario();
        if (direccionDepartamento) {
            salario += COMPLEMENTO_DIRECCION;
        }
        return salario; 
    }
    
    
    
}
