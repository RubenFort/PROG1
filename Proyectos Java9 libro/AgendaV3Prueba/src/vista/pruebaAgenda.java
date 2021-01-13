package vista;

import modelo.Agenda;
import modelo.Contacto;
import oracle.jrockit.jfr.tools.ConCatRepository;

public class pruebaAgenda {
    
    
public static Agenda agendaPrueba;
public static Contacto [] contactos;
    
public static void main(String[] args ){
    
   //Crear agenda con 3 contactos
    System.out.println("---------------------------------------------------------------");
    System.out.println("Crear agenda con capacidad 3");
   agendaPrueba = new Agenda(3);
   
   //Listar agenda vacia
    System.out.println("---------------------------------------------------------------");
    System.out.println("Listar agenda");
    listarContactos();
    
    //Añadir 3 contactos a la agenda(devuelve true*3)
    System.out.println("---------------------------------------------------------------");
    System.out.println("Añade 3 contactos a la agenda");
    System.out.println("");
    if (agendaPrueba.addContacto(new Contacto("Ruben Lopez", "12/03/2003", 677456454, 'A', true))){
        System.out.println("Contacto añadido a la agenda");
    } else {
        System.out.println("No se pudo cargar el contacto, agenda llena");
    }
    
    if (agendaPrueba.addContacto(new Contacto("Ana Vila", "28/12/1998", 676223522, 'A', false))) {
        System.out.println("Contacto añadido a la agenda");
    } else {
        System.out.println("No se pudo cargar el contacto, agenda llena");
    }
    
    if (agendaPrueba.addContacto(new Contacto("Pepu Hernandez", "08/08/1980", 676114114, 'F', false))) {
        System.out.println("Contacto añadido a la agenda");
    } else {
        System.out.println("No se pudo cargar el contacto, agenda llena");
    }
    
    //Listar agenda
    System.out.println("---------------------------------------------------------------");
    System.out.println("Listar agenda");
    listarContactos();
    
    //Dar de alta un contacto(deveulve false, la agenda está llena)
    System.out.println("---------------------------------------------------------------");
    System.out.println("Añade 1 contacto a la agenda");
    System.out.println("");
    if(agendaPrueba.addContacto(new Contacto("Luis Pitís", "04/10/2015", 984232658, 'T', true))){
        System.out.println("Contacto añadido a la agenda");
    } else {
        System.out.println("No se pudo cargar el contacto, agenda llena");
    }
    
    //Borrar 1 contacto(true)
    System.out.println("---------------------------------------------------------------");
    System.out.println("Borra 1 contacto");
    System.out.println("");
    if(agendaPrueba.dropContacto(1)){
        System.out.println("Contacto borrado de la agenda");
    } else {
        System.out.println("No se pudo borrar el contacto, agenda vacía");
    }
    
    //Listo agenda
    System.out.println("---------------------------------------------------------------");
    System.out.println("Listar agenda");
    listarContactos();
    
    //Dar de alta un contacto(true)
    System.out.println("---------------------------------------------------------------");
    System.out.println("Añade 1 contacto1 a la agenda");
    System.out.println("");
    if (agendaPrueba.addContacto(new Contacto("Luisa Peloto", "27/07/1980", 656854951, 'T', false))) {
        System.out.println("Contacto añadido a la agenda");
    } else {
        System.out.println("No se pudo cargar el contacto, agenda llena");
    }
        System.out.println("---------------------------------------------------------------");
}

    private static void listarContactos() {
        Contacto [] lista = agendaPrueba.getAllContactos();
        System.out.println("");
        if (lista.length>0){
            for (Contacto contacto : lista) {
                System.out.println("ID: "+contacto.getId()+"  Nombre: "+contacto.getNombre());
            }
        }else{
            System.out.println("Agenda vacia");
        }
    }
        
    
}
