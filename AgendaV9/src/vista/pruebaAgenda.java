package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Tipo;

public class pruebaAgenda {

    private static Agenda miAgenda;
    Contacto[] contactosLista;
    Contacto nuevoContacto;

    public static void main(String[] args) throws ParseException  {
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
        
//---------------------- Creamos una agenda de CAPACIDAD 3 ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Creamos una agenda de CAPACIDAD 3 ");
        miAgenda = new Agenda(3);

//---------------------- Listamos la agenda vacia ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Listamos la agenda vacia ");
        listaAgenda();

//---------------------- Añadimos 3 contactos ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Añadimos 3 contactos ");
 
        if (miAgenda.addContacto(new Contacto("Pepe", sdf.parse("12/11/2000"), 676558996, Tipo.AMIGO, true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo añadir el contacto");
        }
        
        if (miAgenda.addContacto(new Contacto("Ana", sdf.parse("01/05/1994"), 677389574, Tipo.ENEMIGO, true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo añadir el contacto");
        }
        
        if (miAgenda.addContacto(new Contacto("Luis", sdf.parse("22/04/2016"), 981456654, Tipo.FAMILIA, false))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo añadir el contacto");
        }
        

//---------------------- Listamos la agenda ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("// Listamos la agenda con 3 contactos ");
        System.out.println(" ");
        listaAgenda();

//---------------------- Intentamos dar de alta un nuevo contacto (devería de devolver false) ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Intentamos dar de alta un nuevo contacto (devería de devolver false)por estar la agenda llena ");

        if (miAgenda.addContacto(new Contacto("Alberto", sdf.parse("23/06/1956"), 986987877, Tipo.TRABAJO, false))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, la agenda está llena");
        }

//---------------------- Borramos un contacto ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Borramos el contacto con id:1 ");

        if (miAgenda.deleteContactoById(1)) {
            System.out.println("Contacto borrado correctamente");
        } else {
            System.out.println("No se pudo borrar el contacto");
        }

//---------------------- Listamos la agenda ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("// Listamos la agenda con 2 contactos, el 0 y el 2 ");
        listaAgenda();

//---------------------- Intentamos dar de alta un nuevo contacto (devería de devolver true+) ----------------------
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Intentamos dar de alta un nuevo contacto (devería de devolver true por no estar llena la agenda) ");

        if (miAgenda.addContacto(new Contacto("Jaime", sdf.parse("18/19/1998"), 677981232, Tipo.ENEMIGO, true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, la agenda está llena");
        }
        
        
 //---------------------- Intentamos buscar los contactos por su tipo ----------------------        
//        System.out.println("-----------------------------------------------------------------------------------");
//        System.out.println("// Intentamos buscar los contactos que se correspondan al tipo amigo");
//        
//        Contacto [] contactosDevueltos;
//        
//        contactosDevueltos=miAgenda.getContactosByTipo('A');
//        
//        for (Contacto c : contactosDevueltos) {
//            System.out.println("Id " + c.getId() + "  Nombre "
//                    + c.getNombre() + "  Tipo  " + c.getTipo());
//        }
        
 //---------------------- Intentamos buscar los contactos por su telefono ----------------------        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Intentamos buscar los contactos con el telefono 677981232");
        
         Contacto contactoDevuelto;
        
        contactoDevuelto=miAgenda.getContactosByTelefono(677981232);

        //Pedimos el id del contacto buscado

            System.out.println("Id " + contactoDevuelto.getId() + "  Nombre "
                    + contactoDevuelto.getNombre() + "  Telefono  " + contactoDevuelto.getTelefono());

        
                Scanner teclado = new Scanner (System.in);
                
                
        //Probamos la clase fecha        
//        Fecha [] fechas = new Fecha [10];
//        
//        fechas[0]=new Fecha(02, 07, 1985);
//        fechas[1]=new Fecha(26, 01, 2001);
//        fechas[2]=new Fecha(15, 06, 2007);
//        
//        System.out.println(""+fechas[0].getDia()+"/"+fechas[0].getMes()+"/"+fechas[0].getAño());
//        System.out.println(""+fechas[1].getDia()+"/"+fechas[1].getMes()+"/"+fechas[1].getAño());
//        System.out.println(""+fechas[2].getDia()+"/"+fechas[2].getMes()+"/"+fechas[2].getAño());
//        
//        //Se puede imprimir el
//        System.out.println(fechas[0]);
//        System.out.println(fechas[1]);
//        System.out.println(fechas[2]);
    }

    
    private static void listaAgenda() {
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Contacto[] listaVacia = miAgenda.getAllContactos();
        
        if (listaVacia.length > 0) {
//            Contacto c;
//            for (int i = 0; i < listaVacia.length; i++) {
//                c = listaVacia[i];
//                System.out.println(c.getId() + " " + c.getNombre() + " ");
            for (Contacto c : listaVacia) {//usamos un for each
                System.out.println(c.getId() + " " + c.getNombre() + " " + sdf2.format(c.getFechaNacimiento()));
            }
        } else {
            System.out.println("La agenda está vacía");
        }
    }
}
