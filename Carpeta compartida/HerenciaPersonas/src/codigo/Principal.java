package codigo;

//Aquí, por ahora no va nada. Después probaremos las clases que vamos a crear.

import java.util.Date;
import java.util.Vector;
import modelo.Administracion;
import modelo.Alumno;
import static modelo.Departamento.TECNOLOGÏA;
import modelo.Direccion;
import modelo.Empleado;
import modelo.Mantenimiento;
import modelo.NivelAdministracion;
import modelo.Oficio;
import modelo.Persona;
import modelo.Tutor;


public class Principal {

    public static void main(String[] args) {
        
//        //No se puede crear(instanciar) un objeto Persona por ser una clase abstracta
//        Persona p0 = new Persona("32111222K", "Rey", "Varela", "Eva");
//        System.out.println(p0.getNombreOficial());
//        System.out.println("------------------------------------------------------");
        
        //Creamos un objeto Alumno y mostramos su "nombre oficial"
        Alumno a0 = new Alumno("2233322H", "Lois", "Perez", "Anacleto", "DAM", 1);
        System.out.println(a0.getNombreOficial());
        System.out.println("------------------------------------------------------");
        
        //Creamos un objeto Tutor y mostramos su "nombre oficial" y su "salario"
        Tutor t0 = new Tutor("32333333Y", "Fernandez", "Martinez", "Manuel", TECNOLOGÏA);
        System.out.println(t0.getNombreOficial());
        System.out.println("Salario antes ser director de departamento y de tutorizar a Anacleto: " + t0.getSalario());
        t0.agregaAlumnoTutorizado(a0);
        System.out.println("Salario antes de ser director de departamento y despues de  tutorizar a Anacleto: " + t0.getSalario());
        t0.setDireccionDepartamento(true);
        System.out.println("Salario despues de ser director de departamento y despues de  tutorizar a Anacleto: " + t0.getSalario());
        
        System.out.println("------------------------------------------------------");
        
        //Creamos un objeto Administracion y mostramos su "salario"
        Administracion k0 = new Administracion("32444444A", "Ruiz", "Sola", "Juana", NivelAdministracion.JEFE_GRUPO);
        System.out.println(k0.getNombreOficial());
        System.out.println("Salario: " + k0.getSalario());
        System.out.println("------------------------------------------------------");
        
        //Creamos un objeto Mantenimeinto y mostramos su "salario"
        Mantenimiento m0 = new Mantenimiento("45123123H", "Garcia", "Perez", "Pepe", Oficio.ELECTRICIDAD);
        System.out.println(m0.getNombreOficial());
        System.out.println("Salario sin horas extras: " + m0.getSalario());
        m0.setHorasExtraRealizadas(10);
        System.out.println("Salario con 10 horas extras: " + m0.getSalario());
        System.out.println("------------------------------------------------------");
        
        Direccion d0 = new Direccion("45677889N", "Rey", "Juarez", "Elvira", NivelAdministracion.JEFE_SERVICIO, 1234);
        System.out.println(d0.getNombreOficial());
        System.out.println("Salario: " + d0.getSalario());
        System.out.println("------------------------------------------------------");
        
        int i;
        
        Date ahora = new Date();
        
        Persona p0,p1;
        p0 = a0;
        p1 = t0;
        
        System.out.println(p0.getNombreOficial());
        System.out.println(p1.getNombreOficial());
        System.out.println("------------------------------------------------------");
        
        Empleado e0, e1, e2, e3;
        //No puedo instanciar variable Empleado porque es una clase "abstract"
        e0 = k0;//Asignamos un objeto de la clase administracion
        e1 = m0;//Asignamos un objeto de la clase mantenimiento
        e2 = t0;//Asignamos un objeto de la clase tutor
        e3 = d0;//Asignamos un objeto de la clase direccion
        System.out.println("El salario de " + e0.getNombreOficial() + " es " + e0.getSalario());
        System.out.println("El salario de " + e1.getNombreOficial() + " es " + e1.getSalario());
        System.out.println("El salario de " + e2.getNombreOficial() + " es " + e2.getSalario());
        System.out.println("El salario de " + e3.getNombreOficial() + " es " + e3.getSalario());
        System.out.println("------------------------------------------------------");
        
        Vector<Persona> peronasColegio = new Vector();
        peronasColegio.add(a0);
        peronasColegio.add(t0);
        peronasColegio.add(k0);
        peronasColegio.add(m0);
        peronasColegio.add(d0);
        
        //Recorremos el Vector y cada persona solicita días libres y vemos lo que se constesta
        for(Persona p: peronasColegio) {
            System.out.println(p.getNombreOficial() + " solicita hoy libre y se le contesta " + p.pideDiaLibre(ahora));
        }
        
    }
    
}
