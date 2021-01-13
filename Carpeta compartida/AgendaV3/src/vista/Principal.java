package vista;

import java.util.Scanner;
import modelo.Contacto;

public class Principal {



    public static void main(String[] args) {

        boolean salir = false;
        String opcion;
        Scanner teclado = new Scanner(System.in);

        //Cargamos datos al arrancar
        cargarContactos();
        
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

    private static void cargarContactos() {

        //Creamos los arrays
        contactos = new Contacto[MAX_CONTACTOS];

        //Introducimos unos contactos de pruebas
        contactos[ocupacion] = new Contacto(siguienteID, "Eva Rey", "20/02/1990", 981212223, 'A', true);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Luis Pérez", "21/01/1965", 981212333, 'A', false);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Juan Leis", "12/03/1980", 981256567, 'F', true);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Ana Dios", "11/07/1966", 657656454, 'E', false);
        ocupacion++;
        siguienteID++;

    }

    private static void listarContactos() {
        Contacto c;
        for (int i = 0; i < ocupacion; i++) {
            c = contactos[i];
            System.out.println(c.getId() + " " + c.getNombre());
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
        Contacto c;

        if (idBuscado < 0 || idBuscado >= siguienteID) {
            System.out.println("No hay un contacto con ID:" + idBuscado);
            return;
        }

        //Recorremos el array de ids hasta encontrarlo o alcanzar el fin
        for (int i = 0; i < ocupacion; i++) {
            c = contactos[i];
            if (c.getId() == idBuscado) {
                System.out.println("ID: " + c.getId());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Fecha Nacimiento: " + c.getFechaNacimiento());
                System.out.println("Teléfono: " + c.getTelefono());
                System.out.println("Tipo: " + c.getTipo());
                System.out.println("¿Tiene coche?: " + c.isTieneCoche());
                return;
            }
        }
        System.out.println("No hay un contacto con ID:" + idBuscado);
    }

    private static void nuevoContacto() {

        Scanner teclado = new Scanner(System.in);
        String linea;
        String nombre;
        String fechaNacimiento;
        long telefono;
        char tipo;
        boolean tieneCoche;

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

        System.out.println("¿Tiene coche? (true|false:");
        linea = teclado.nextLine();
        tieneCoche = Boolean.parseBoolean(linea);

        contactos[ocupacion] = new Contacto(siguienteID, nombre, fechaNacimiento, telefono, tipo, tieneCoche);
        siguienteID++;
        ocupacion++;

    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        int idABorrar;
        int posicionABorrar;
        String linea;
        Contacto c;

        //Pedimos el id del contacto a borrar
        System.out.print("Qué contacto quieres borrar?:");
        linea = teclado.nextLine();
        idABorrar = Integer.parseInt(linea);

        //Si el id a borrar es inferior a 0 o mayor o igual que el siguiente
        //a asignar, es un error y se finaliza
        if (idABorrar < 0 || idABorrar >= siguienteID) {
            System.out.println("No hay un contacto con ID:" + idABorrar);
            return;
        }

        //Recorremos el array de ids hasta encontrarlo y copiamos
        //los siguientes (hasta el final) una posición hacia atrás
        for (int i = 0; i < ocupacion; i++) {
            c = contactos[i];
            if (c.getId() == idABorrar) {
                for (int j = i + 1; j < ocupacion; j++) {
                    contactos[j - 1] = contactos[j];
                }
                ocupacion--;
                return;
            }
        }
        System.out.println("No hay un contacto con ID:" + idABorrar);
    }

}
