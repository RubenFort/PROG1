package modelo;

import java.util.Vector;

//Esta clase no es especializable porque tiene la palabra "final", no puede tener
//subclases
public final class Tutor extends Profesor{
    
    private double complementoPorAlumno;
    private Vector<Alumno> alumnosTutorizados;

    public Tutor(String NIF, String apellido1, String apellido2, String nombre, Departamento departamento) {
        super(NIF, apellido1, apellido2, nombre, departamento);
        this.complementoPorAlumno = 10;
        alumnosTutorizados = new Vector<>();
    }

    public void agregaAlumnoTutorizado(Alumno alumno) {
        alumnosTutorizados.add(alumno);
    }
    
    @Override
    public double getSalario() {
        
        double salario = super.getSalario();
        salario += 10*alumnosTutorizados.size();
        
        return salario;
    }

    
    
}
