package vista;

import modelo.Agenda;
import modelo.Contacto;

public class PruebasAgenda {

    private static Agenda agendaPruebas;

    public static void main(String[] args) {

        //Creamos una Agenda de CAPACIDAD 3
        System.out.println("-------------------------------------------------");
        System.out.println("Creamos una Agenda de CAPACIDAD 3");
        agendaPruebas = new Agenda(3);

        //Listamos la agenda, que ahora debe estar vacía
        System.out.println("-------------------------------------------------");
        System.out.println("Listamos la agenda, que ahora debe estar vacía");
        listaAgenda();

        //Añadimos 3 contactos
        System.out.println("-------------------------------------------------");
        System.out.println("Añadimos 3 contactos");
        if (agendaPruebas.addContacto(new Contacto("Adelina", "12/07/1900", 981212223, 'F', true))) {
            System.out.println("Contacto SÍ añadido");
        } else {
            System.out.println("Agenda llena. Contacto NO añadido");
        }

        if (agendaPruebas.addContacto(new Contacto("Juana", "22/08/1960", 786765565, 'A', false))) {
            System.out.println("Contacto SÍ añadido");
        } else {
            System.out.println("Agenda llena. Contacto NO añadido");
        }

        if (agendaPruebas.addContacto(new Contacto("Antonio", "13/09/1970", 666555444, 'E', true))) {
            System.out.println("Contacto SÍ añadido");
        } else {
            System.out.println("Agenda llena. Contacto NO añadido");
        }

        //Listamos la agenda
        System.out.println("-------------------------------------------------");
        System.out.println("Listamos la agenda, que ahora debe tener 3 contactos");
        listaAgenda();

        //Intentamos dar de alta un  nuevo contacto (debería devolver false) por estar llena
        System.out.println("-------------------------------------------------");
        System.out.println("Intentamos dar de alta un  nuevo contacto (debería devolver false) por estar llena");
        if (agendaPruebas.addContacto(new Contacto("Contacto fallo", "12/07/1900", 981212223, 'F', true))) {
            System.out.println("Contacto SÍ añadido");
        } else {
            System.out.println("Agenda llena. Contacto NO añadido");
        }

        //Borramos un contacto
        System.out.println("-------------------------------------------------");
        System.out.println("Borramos el contacto con id:1");
        if (agendaPruebas.deleteContactoById(1)) {
            System.out.println("Contacto borrado correctamente");
        } else {
            System.out.println("Fallo al borrar el contacto");
        }

        //Listamos la agenda, que ahora debería tener sólo 2 contactos (El 0 y el 2)
        System.out.println("-------------------------------------------------");
        System.out.println("Listamos la agenda, que ahora debería tener sólo 2 contactos (El 0 y el 2");
        listaAgenda();

        //Intentamos dar de alta un  nuevo contacto (debería devolver true) por no estar llena
        System.out.println("-------------------------------------------------");
        System.out.println("Intentamos dar de alta un  nuevo contacto (debería devolver true) por no estar llena");
        if (agendaPruebas.addContacto(new Contacto("Nuevo contacto", "03/04/1960", 987777777, 'F', true))) {
            System.out.println("Contacto SÍ añadido");
        } else {
            System.out.println("Agenda llena. Contacto NO añadido");
        }
    }

    private static void listaAgenda() {

        Contacto[] contenido = agendaPruebas.getAllContactos();

        if (contenido.length > 0) {
            /*
            Contacto c;
            for (int i = 0; i < contenido.length; i++) {
            c = contenido[i];
            System.out.println(c.getId() + " " + c.getNombre());
            }
             */
            for (Contacto c : contenido) {
                System.out.println(c.getId() + " " + c.getNombre());
            }

        } else {
            System.out.println("La agenda está vacía");
        }

    }

}
