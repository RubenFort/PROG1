package vista;

import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;

public class Principal {
    
    /*Para que un objeto sea global lo declaramos aquí (antes del main),
    también se podría inicializar pero es más recomendable hacerlo en el main */
    public static Contacto contactos;
    public static Agenda miAgenda;

    public static void main(String[] args) {
        
        miAgenda=new Agenda ();//Inicializamos el objeto, es global porque está inicializado antes del main.
        boolean salir = false;
        String opcion;
        Scanner teclado = new Scanner(System.in);
        /////
        //Cargamos datos al arrancar
        cargarContactos();

        do {
            System.out.println("==== AGENDA DE CONTACTOS ====");
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)lista");
            System.out.println("(D)etalle");
            System.out.println("Buscar contacto por T(i)po");
            System.out.println("Buscar contacto por (T)elefono");
            System.out.println("(S)alir");
            System.out.println("");
            System.out.print("Opción?:");
            opcion = teclado.nextLine();
            switch (opcion) {
                case "A":
                case "a":
                      nuevoContacto();
                    break;
                case "B":
                case "b":
                     borrarContacto();
                    break;
                case "D":
                case "d":
                      mostrarDetalle();
                    break;
                case "I":
                case "i":
                    buscarPorTipo();
                    break;
                case "T":
                case "t":
                    buscarPorTelefono();
                    break;
                case "L":
                case "l":
                    listarContactos();
                    break;
                case "S":
                case "s":
                    System.out.println("Has elegido Salir");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!salir);
    }

    private static void cargarContactos() {

        boolean cargaOk;

        //Introducimos unos contactos de pruebas
        contactos = new Contacto("Pepe Couto", "12/09/1999", 676558996, 'A', true);
        cargaOk = miAgenda.addContacto(contactos);
        if (cargaOk == true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto");
        }

        contactos = new Contacto("Luis Pérez", "21/01/1965", 981212333, 'A', false);
        cargaOk = miAgenda.addContacto(contactos);
        if (cargaOk == true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto");
        }

        contactos = new Contacto("Juan Leis", "12/03/1980", 981256567, 'F', true);
        cargaOk = miAgenda.addContacto(contactos);
        if (cargaOk == true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto");
        }

        contactos = new Contacto("Ana Vila", "11/07/1966", 657656454, 'E', false);
        cargaOk = miAgenda.addContacto(contactos);
        if (cargaOk == true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto");
        }
    }

    private static void listarContactos() {
        Contacto[] listarArray = new Contacto[miAgenda.getCAPACIDAD()];
        listarArray = miAgenda.getAllContactos();
        for (int i = 0; i < listarArray.length; i++) {
            System.out.println("ID " + listarArray[i].getId() + "  Nombre " + listarArray[i].getNombre());
        }
    }

    private static void mostrarDetalle() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        int idBuscado;

        //Pedimos el id del contacto buscado
        System.out.print("De qué contacto quieres información?:");
        linea = teclado.nextLine();
        idBuscado = Integer.parseInt(linea);
        Contacto contactoDetalle;

        contactoDetalle = miAgenda.getContactoById(idBuscado);

        if (contactoDetalle == null) {
            System.out.println("El contacto seleccionado no existe");
        } else {
            System.out.println("");
            System.out.println("ID: " + contactoDetalle.getId());
            System.out.println("Nombre: " + contactoDetalle.getNombre());
            System.out.println("Fecha de nacimiento: " + contactoDetalle.getFechaNacimiento());
            System.out.println("Telefono: " + contactoDetalle.getTelefono());
            System.out.println("Tipo: " + (contactoDetalle.getTipo()=='A'?"Amigo":
                    contactoDetalle.getTipo()=='E'?"Enemigo":
                    contactoDetalle.getTipo()=='F'?"Familia":
                    contactoDetalle.getTipo()=='T'?"Trabajo":"Tipo desconocido"));
            System.out.println("Propiedad: " + contactoDetalle.isTieneCoche());
            System.out.println("");
        }
    }

    private static void nuevoContacto() {
        
        Scanner teclado = new Scanner(System.in);
        String linea;
        String nombre;
        String fechaNacimiento;
        long telefono;
        char tipo;
        boolean tieneCoche;
        boolean cargaOk;

        System.out.print("Nombre:");
        nombre = teclado.nextLine();

        System.out.print("Fecha Nacimiento:");
        fechaNacimiento = teclado.nextLine();

        System.out.print("Teléfono:");
        linea = teclado.nextLine();
        telefono = Long.parseLong(linea);

        System.out.print("Tipo(A|E|F|T):");
        linea = teclado.nextLine();
        tipo = linea.charAt(0);

        System.out.print("¿Tiene coche? (true|false):");
        linea = teclado.nextLine();
        tieneCoche = Boolean.parseBoolean(linea);

        Contacto c = new Contacto(nombre, fechaNacimiento, telefono, tipo, tieneCoche);
        
        cargaOk=miAgenda.addContacto(c);
        
        if (cargaOk == true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        int idABorrar;
        String linea;
        Contacto c;

        //Pedimos el id del contacto a borrar
        System.out.print("Qué contacto quieres borrar?:");
        linea = teclado.nextLine();
        idABorrar = Integer.parseInt(linea);
        boolean borradoOk;
        
        borradoOk=miAgenda.deleteContactoById(idABorrar);
        
        if (borradoOk == true) {
            System.out.println("Contacto borrado");
        } else {
            System.out.println("No se pudo borrar el contacto");
        }
    }

    private static void buscarPorTipo() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        char tipoBuscado;
        Contacto [] contactosDevueltos;

        //Pedimos el id del contacto buscado
        System.out.print("De qué contacto quieres información(tipo)?:");
        linea = teclado.nextLine();
        tipoBuscado = linea.charAt(0);
        
        contactosDevueltos=miAgenda.getContactosByTipo(tipoBuscado);
        
        for (Contacto c : contactosDevueltos) {
            
            System.out.println("");
            System.out.println("ID: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Fecha de nacimiento: " + c.getFechaNacimiento());
            System.out.println("Telefono: " + c.getTelefono());
            System.out.println("Tipo: " + (c.getTipo()=='A'?"Amigo":
                    c.getTipo()=='E'?"Enemigo":
                    c.getTipo()=='F'?"Familia":
                    c.getTipo()=='T'?"Trabajo":"Tipo desconocido"));
            System.out.println("Propiedad: " + c.isTieneCoche());
            System.out.println("");
            
        }
        
    }

    private static void buscarPorTelefono() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        long telefonoBuscado;
        Contacto contactoDevuelto;
        
        System.out.print("De qué contacto quieres información (telefono)?:");
        linea = teclado.nextLine();
        telefonoBuscado = Long.parseLong(linea);
        
        contactoDevuelto=miAgenda.getContactosByTelefono(telefonoBuscado);

        //Pedimos el id del contacto buscado
        
        System.out.println("");
            System.out.println("ID: " + contactoDevuelto.getId());
            System.out.println("Nombre: " + contactoDevuelto.getNombre());
            System.out.println("Fecha de nacimiento: " + contactoDevuelto.getFechaNacimiento());
            System.out.println("Telefono: " + contactoDevuelto.getTelefono());
            System.out.println("Tipo: " + (contactoDevuelto.getTipo()=='A'?"Amigo":
                    contactoDevuelto.getTipo()=='E'?"Enemigo":
                    contactoDevuelto.getTipo()=='F'?"Familia":
                    contactoDevuelto.getTipo()=='T'?"Trabajo":"Tipo desconocido"));
            System.out.println("Propiedad: " + contactoDevuelto.isTieneCoche());
            System.out.println("");
        

    }
}
