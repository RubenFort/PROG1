package vista;

import modelo.Agenda;
import modelo.Contacto;

public class pruebaAgenda {

    private static Agenda miAgenda;
    Contacto[] contactosLista;
    Contacto nuevoContacto;

    public static void main(String[] args) {

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
 
        if (miAgenda.addContacto(new Contacto("Pepe", "12/09/1999", 676558996, 'A', true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo añadir el contacto");
        }
        
        if (miAgenda.addContacto(new Contacto("Ana", "28/07/2005", 677389574, 'T', true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo añadir el contacto");
        }
        
        if (miAgenda.addContacto(new Contacto("Luis", "01/11/2002", 981456654, 'A', false))) {
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

        if (miAgenda.addContacto(new Contacto("Alberto", "21/03/1987", 986987877, 'T', false))) {
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

        if (miAgenda.addContacto(new Contacto("Jaime", "01/02/2003", 677981232, 'F', true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, la agenda está llena");
        }
        
        
 //---------------------- Intentamos buscar los contactos por su tipo ----------------------        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Intentamos buscar los contactos que se correspondan al tipo amigo");
        
        Contacto [] contactosDevueltos;
        
        contactosDevueltos=miAgenda.getContactosByTipo('A');
        
        for (Contacto c : contactosDevueltos) {
            System.out.println("Id " + c.getId() + "  Nombre "
                    + c.getNombre() + "  Tipo  " + c.getTipo());
        }
        
 //---------------------- Intentamos buscar los contactos por su telefono ----------------------        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("// Intentamos buscar los contactos que se correspondan al tipo amigo");
        
         Contacto contactoDevuelto;
        
        contactoDevuelto=miAgenda.getContactosByTelefono(677981232);

        //Pedimos el id del contacto buscado

            System.out.println("Id " + contactoDevuelto.getId() + "  Nombre "
                    + contactoDevuelto.getNombre() + "  Telefono  " + contactoDevuelto.getTelefono());

        
    }

    
    private static void listaAgenda() {
        Contacto[] listaVacia = miAgenda.getAllContactos();
        
        if (listaVacia.length > 0) {
//            Contacto c;
//            for (int i = 0; i < listaVacia.length; i++) {
//                c = listaVacia[i];
//                System.out.println(c.getId() + " " + c.getNombre() + " ");
            for (Contacto c : listaVacia) {//usamos un for each
                System.out.println(c.getId() + " " + c.getNombre() + " ");
            }
        } else {
            System.out.println("La agenda está vacía");
        }
    }
}
