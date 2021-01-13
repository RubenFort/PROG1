package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Tipo;

public class Principal {
    
    /*Para que un objeto sea global lo declaramos aquí (antes del main),
    también se podría inicializar pero es más recomendable hacerlo en el main */
    public static Date fechas;
    public static Contacto contactos;
    public static Agenda miAgenda;

    public static void main(String[] args){
        
        miAgenda=new Agenda ();//Inicializamos el objeto, es global porque está inicializado antes del main.
        boolean salir = false;
        String opcion;
        Scanner teclado = new Scanner(System.in);
        
        try {
            //Cargamos datos al arrancar
            cargarContactos();
        } catch (ParseException parseException) {
            System.out.println("No se han podido cargar contactos. La agenda se inicia vacía");
        }

        do {
            System.out.println("==== AGENDA DE CONTACTOS ====");
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)lista");
            System.out.println("(D)etalle");
            System.out.println("(M)odificar");
//            System.out.println("(I)Buscar contacto por Tipo");
            System.out.println("(E)Buscar contacto por Telefono");
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
                case "M":
                case "m":
                      modificarContacto();
                    break;
//                case "I":
//                case "i":
//                    buscarPorTipo();
//                    break;
//                case "T":
//                case "t":
//                    buscarPorTelefono();
//                    break;
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

    private static void cargarContactos() throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
            miAgenda.addContacto(new Contacto("Pepe Couto", sdf.parse("12/11/2000"), 676558996, Tipo.AMIGO, true));
            miAgenda.addContacto(new Contacto("Luis Pérez", sdf.parse("01/05/1994"), 981212333, Tipo.ENEMIGO, false));
            miAgenda.addContacto(new Contacto("Juan Leis", sdf.parse("12/11/2000"), 981256567, Tipo.FAMILIA, true));
            miAgenda.addContacto(new Contacto("Ana Vila", sdf.parse("22/04/2016"), 657656454, Tipo.TRABAJO, false));
        
    }

    private static void listarContactos() {
        for (Contacto c : miAgenda.getAllContactos()) {
            System.out.println(c.getId() + " " + c.getNombre());
        }
    }

    private static void mostrarDetalle() {
        
        Scanner teclado = new Scanner(System.in);
        String linea;
        int idBuscado;
        Contacto contactoDetalle;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaContacto;
        
        //Pedimos el id del contacto buscado
            try {
                System.out.print("De qué contacto quieres información?:");
                linea = teclado.nextLine();
                idBuscado = Integer.parseInt(linea);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Formato de busqueda de contacto incorrecta");
                return;
            }
        
        contactoDetalle = miAgenda.getContactoById(idBuscado);

        if (contactoDetalle != null) {
            System.out.println("");
            System.out.println("ID: " + contactoDetalle.getId());
            System.out.println("Nombre: " + contactoDetalle.getNombre());
            System.out.println("Fecha de nacimiento: " + sdf.format(contactoDetalle.getFechaNacimiento()));
            System.out.println("Telefono: " + contactoDetalle.getTelefono());
            System.out.println("Tipo: " + contactoDetalle.getTipo());
            System.out.println("Propiedad: " + contactoDetalle.isTieneCoche());
            System.out.println("");
        } else {
            System.out.println("El contacto seleccionado no existe");
        }
    }

    private static void nuevoContacto(){
        
        Scanner teclado = new Scanner(System.in);
        String linea;
        String nombre;
        long telefono;
        Tipo tipo;
        boolean tieneCoche;
        boolean cargaOk;
        Date fechaNacimiento = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Nombre:");
            nombre = teclado.nextLine();
            
            System.out.print("Fecha Nacimiento (dd/mm/aaaa)");
            linea = teclado.nextLine();
            fechaNacimiento = sdf.parse(linea);
            
            System.out.print("Teléfono:");
            linea = teclado.nextLine();
            telefono = Long.parseLong(linea);
            
            System.out.print("Tipo(Amigo|Enemigo|Familia|Trabajo):");
            linea = teclado.nextLine().toUpperCase();
            tipo = Tipo.valueOf(linea);
            
            System.out.print("¿Tiene coche? (true|false):");
            linea = teclado.nextLine();
            tieneCoche = Boolean.parseBoolean(linea);
        } catch (Exception e) {
            System.out.println("Datos erroneos");
            return;
        }

        cargaOk=miAgenda.addContacto(new Contacto(nombre, fechaNacimiento, telefono, tipo, tieneCoche));
        
        if (cargaOk == true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        int idABorrar = 0;
        String linea;
        boolean borradoOk;
        
        //Pedimos el id del contacto a borrar
        
        try {
            System.out.print("Qué contacto quieres borrar?:");
            linea = teclado.nextLine();
            idABorrar = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Formato contacto incorrecto");
            return;
        }

        borradoOk=miAgenda.deleteContactoById(idABorrar);
        
        if (borradoOk == true) {
            System.out.println("Contacto borrado");
        } else {
            System.out.println("El contacto seleccionado no existe");
        }
    }

//    private static void buscarPorTelefono() {
//        Scanner teclado = new Scanner(System.in);
//        String linea;
//        long telefonoBuscado = 0;
//        Contacto contactoDevuelto;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        
//        System.out.print("De qué contacto quieres información (telefono)?:");
//        linea = teclado.nextLine();
//        try {
//            telefonoBuscado = Long.parseLong(linea);
//        } catch (NumberFormatException numberFormatException) {
//            System.out.println("Formato de telefono incorrecto");
//            return;
//        }
//        
//        contactoDevuelto=miAgenda.getContactosByTelefono(telefonoBuscado);
//
//        System.out.println("");
//            System.out.println("ID: " + contactoDevuelto.getId());
//            System.out.println("Nombre: " + contactoDevuelto.getNombre());
//            System.out.println("Fecha de nacimiento: " + sdf.format(contactoDevuelto.getFechaNacimiento()));
//            System.out.println("Telefono: " + contactoDevuelto.getTelefono());
//            System.out.println("Tipo: " + contactoDevuelto.getTipo());
//            System.out.println("Propiedad: " + contactoDevuelto.isTieneCoche());
//            System.out.println("");
//        
//    }

    private static void modificarContacto(){
        Scanner teclado = new Scanner(System.in);
        String linea;
        int idBuscado = 0;
        Contacto modificar;
        char seleccion;
        long nuevoTelefono = 0;
        Tipo nuevoTipo;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDeNacimiento = null;
        
        System.out.print("Que contacto quieres modificar: ");
        linea = teclado.nextLine();
        
        try {
            idBuscado = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Formato de ID buscado incorrecto");
            return;
        }

        modificar = miAgenda.getContactoById(idBuscado);
        
        if (modificar == null) {
            System.out.println("El contacto seleccionado no existe");
        } else {
            System.out.print("Que campo quieres modificar: (N)ombre, (F)echa de Nacimiento, (T)elefono, T(i)po, Tiene (c)oche: ");
            linea = teclado.nextLine();
            seleccion = linea.charAt(0);
            
            switch (seleccion){
                case 'n':
                case 'N':
                    System.out.print("Nuevo nombre: ");
                    linea = teclado.nextLine();
                    modificar.setNombre(linea);
                    break;
                case 'f':
                case 'F':
                    System.out.print("Nueva fecha: ");
                    linea = teclado.nextLine();
                    try {
                        fechaDeNacimiento = sdf.parse(linea);
                    } catch (ParseException parseException) {
                        System.out.println("Formato de fecha incorrecto");
                        return;
                    }
                    modificar.setFechaNacimiento(fechaDeNacimiento);
                    break;
                case 't':
                case 'T':
                    System.out.print("Nuevo Telefono: ");
                    linea = teclado.nextLine();
                    try {
                        nuevoTelefono = Long.parseLong(linea);
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Formato de telefono incorrecto");
                        return;
                    }
                    modificar.setTelefono(nuevoTelefono);
                    break;
                case 'i':
                case 'I':
                    System.out.print("Nuevo Tipo (Amigo|Enemigo|Familia|Trabajo): ");
                    linea = teclado.nextLine().toUpperCase();
                    try {
                        nuevoTipo = Tipo.valueOf(linea);
                    } catch (Exception e) {
                        System.out.println("Formato de tipo incorrecto");
                        return;
                    }
                    modificar.setTipo(nuevoTipo);
                    break;
                case 'c':
                case 'C':
                    System.out.print("Nuevo tiene coche: ");
                    linea = teclado.nextLine();
                    boolean nuevoTieneCoche = Boolean.parseBoolean(linea);
                    modificar.setTieneCoche(nuevoTieneCoche);
                    break;
                default:
                    System.out.println("La opción seleccionada no existe"); 
            } 
        }
    }
    
    //    private static void buscarPorTipo() {
//        Scanner teclado = new Scanner(System.in);
//        String linea;
//        char tipoBuscado;
//        Contacto [] contactosDevueltos;
//
//        //Pedimos el id del contacto buscado
//        System.out.print("De qué contacto quieres información(tipo)?:");
//        linea = teclado.nextLine();
//        tipoBuscado = linea.charAt(0);
//        
//        contactosDevueltos=miAgenda.getContactosByTipo(tipoBuscado);
//        
//        for (Contacto c : contactosDevueltos) {
//            
//            System.out.println("");
//            System.out.println("ID: " + c.getId());
//            System.out.println("Nombre: " + c.getNombre());
//            System.out.println("Fecha de nacimiento: " + c.getFechaNacimiento());
//            System.out.println("Telefono: " + c.getTelefono());
//            System.out.println("Tipo: " + (c.getTipo()=='A'?"Amigo":
//                    c.getTipo()=='E'?"Enemigo":
//                    c.getTipo()=='F'?"Familia":
//                    c.getTipo()=='T'?"Trabajo":"Tipo desconocido"));
//            System.out.println("Propiedad: " + c.isTieneCoche());
//            System.out.println("");
//            
//        }
//        
//    }
    
}
