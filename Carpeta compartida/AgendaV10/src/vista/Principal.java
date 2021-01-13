package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Tipo;

public class Principal {

    private static Agenda agenda;

    public static void main(String[] args) {

        boolean salir = false;
        String opcion;
        Scanner teclado = new Scanner(System.in);

        try {
            //Cargamos datos al arrancar
            cargarContactos();
        } catch (ParseException ex) {
            System.out.println("No se han podido cargar contactos. La agenda se inicia vacía");
        }

        do {
            System.out.println("==== AGENDA DE CONTACTOS ====");
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)lista");
            System.out.println("(D)etalle");
            System.out.println("(S)alir");
            System.out.println("");
            System.out.print("Opción?:");
            opcion = teclado.nextLine();
            switch (opcion) {
                case "A":
                    nuevoContacto();
                    break;
                case "B":
                    borrarContacto();
                    break;
                case "D":
                    mostrarDetalle();
                    break;
                case "L":
                    listarContactos();
                    break;
                case "S":
                    System.out.println("Has elegido Salir");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!salir);

    }

    private static void cargarContactos() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Creamos la agenda
        agenda = new Agenda();

        //Introducimos unos contactos de pruebas
        agenda.addContacto(new Contacto("Eva Rey", sdf.parse("12/07/1900"), 981212223, Tipo.AMIGO, true));
        agenda.addContacto(new Contacto("Luis Pérez", sdf.parse("22/03/1960"), 981212333, Tipo.AMIGO, false));
        agenda.addContacto(new Contacto("Juan Leis", sdf.parse("13/09/1970"), 981256567, Tipo.FAMILIAR, true));
        agenda.addContacto(new Contacto("Ana Dios", sdf.parse("11/05/1970"), 657656454, Tipo.ENEMIGO, false));

    }

    private static void listarContactos() {
        for (Contacto c : agenda.getAllContactos()) {
            System.out.println(c.getId() + " " + c.getNombre());
        }
    }

    private static void mostrarDetalle() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner teclado = new Scanner(System.in);
        String linea;
        int idBuscado = 0;
        boolean idValido;
        Contacto buscado;

        //Pedimos el id del contacto buscado
        do {
            System.out.print("De qué contacto quieres información?:");
            linea = teclado.nextLine();
            try {
                idBuscado = Integer.parseInt(linea);
                if (idBuscado < 0) {
                    System.out.println("No hay un contacto con ID:" + idBuscado);
                    idValido = false;
                } else {
                    idValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("No hay un contacto con ID:" + idBuscado);
                idValido = false;
            }
        } while (!idValido);

        buscado = agenda.getContactoById(idBuscado);

        if (buscado != null) {
            System.out.println("ID: " + buscado.getId());
            System.out.println("Nombre: " + buscado.getNombre());
            System.out.println("Fecha Nacimiento: " + sdf.format(buscado.getFechaNacimiento()));
            System.out.println("Teléfono: " + buscado.getTelefono());
            System.out.println("Tipo: " + buscado.getTipo());
            System.out.println("¿Tiene coche?: " + buscado.isTieneCoche());
        } else {
            System.out.println("No hay un contacto con ID:" + idBuscado);
        }

    }

    private static void nuevoContacto() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner teclado = new Scanner(System.in);
        String linea;
        String nombre;
        Date fechaNacimiento;
        long telefono;
        Tipo tipo;
        boolean tieneCoche;
        Contacto nuevo;

        try {
            System.out.print("Nombre:");
            nombre = teclado.nextLine();
            
            System.out.print("Fecha Nacimiento (dd/mm/aaaa):");
            linea = teclado.nextLine();
            fechaNacimiento = sdf.parse(linea);
            
            System.out.print("Teléfono:");
            linea = teclado.nextLine();
            telefono = Long.parseLong(linea);
            
            System.out.print("Tipo(AMIGO, ENEMIGO, FAMILIAR, TRABAJO):");
            linea = teclado.nextLine();
            tipo = Tipo.valueOf(linea.toUpperCase());
            
            System.out.println("¿Tiene coche? (true|false:");
            linea = teclado.nextLine();
            tieneCoche = Boolean.parseBoolean(linea);
            
            nuevo = new Contacto(nombre, fechaNacimiento, telefono, tipo, tieneCoche);
        } catch (Exception e) {
            System.out.println("Datos erróneos. No se puede dar de alta el contacto");
            return;
        }

        boolean fueAñadido = agenda.addContacto(nuevo);
        if (fueAñadido) {
            System.out.println("Se añadió a la agenda el nuevo contacto");
        } else {
            System.out.println("No se pudo añadir a la agenda el nuevo contacto");
        }

    }

    private static void borrarContacto() {

        Scanner teclado = new Scanner(System.in);
        int idABorrar = 0;
        String linea;

        //Pedimos el id del contacto a borrar
        try {
            System.out.print("Qué contacto quieres borrar?:");
            linea = teclado.nextLine();
            idABorrar = Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            System.out.println("No hay un contacto con ID:" + idABorrar);
            return;
        }

        //Si el id a borrar es inferior a 0 o mayor o igual que el siguiente
        //a asignar, es un error y se finaliza
        if (idABorrar < 0) {
            System.out.println("No hay un contacto con ID:" + idABorrar);
            return;
        }

        boolean seBorro = agenda.deleteContactoById(idABorrar);
        if (seBorro) {
            System.out.println("El contacto se borró de la agenda correctamente");
        } else {
            System.out.println("No hay un contacto con ID:" + idABorrar + " No se pudo borrar");
        }

    }

}
