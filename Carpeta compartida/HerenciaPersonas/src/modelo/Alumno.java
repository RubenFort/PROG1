package modelo;

import java.util.Date;
import java.util.Vector;

//Al poner final en Alumno, no se podrían poner extends de Alumno
public final class Alumno extends Persona{
 
    //Estos atributos que vamos a ñadir aquí, son los que tiene un alumno
    //(además de los que hereda de persona)
    private String nombreCiclo;
    private int curso;
    private Vector<Date> diasLibreas;
    
    //No existe aún (lo añadiremos al diagrama) colgando de profesor
    //Por ahora (para que no esté dando error) la crearemos de forma independiente
    //Después "la colgaremos" de profesor
    private Tutor tutor; 
    //Lista de asignaturas de las que está y/o estuvo matriculado.
    //No forma parte del diagrama de herencia. Una clase "a mayores" .. cómo Direccion
    private Vector <Asignatura> matriculas;
   

    public Alumno(String NIF, String apellido1, String apellido2, String nombre, String nombreCiclo, int curso) {
        super(NIF, apellido1, apellido2, nombre);
        this.nombreCiclo = nombreCiclo;
        this.curso = curso;
        matriculas = new Vector<>();
        diasLibreas = new Vector<>();
    }
    
    //Al implementar el método abstracto pideDiaLibre(..) de Persona
    //ya pueden instaciar objetos de esta clase
    @Override
    public boolean pideDiaLibre(Date diaSolicitado) {
        diasLibreas.add(diaSolicitado);
        return true;
    }
    
}
