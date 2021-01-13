package modelo;

import java.util.Vector;

public class Alumno extends Persona{
   
    //Estos atributos son los que tiene un alumno, además de los que hereda
    private String nombreCiclo;
    private String curso;
    
    private Tutor tutor;
    //Lista de asignaturas de las que está y/o estuvo matriculado
    //No forma parte del diagrama de herencia. Una clase "a mayores".. cómo Dirección
    private Vector<Asignatura> matriculas;  
    
}
