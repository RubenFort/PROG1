package codigo;

import java.util.Scanner;

public class Principal {

    private static final int MAX_CONTACTOS = 10;
    private static int ocupacion = 0;
    private static int siguienteID = 0;

    private static int[] ids;
    private static String[] nombres;
    private static String[] fechasNacimiento;
    private static long[] telefonos;
    private static char[] tipos; //(A)migo,(E)nemigo,(F)amilia,(T)rabajo

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
        ids = new int[MAX_CONTACTOS];
        nombres = new String[MAX_CONTACTOS];
        fechasNacimiento = new String[MAX_CONTACTOS];
        telefonos = new long[MAX_CONTACTOS];
        tipos = new char[MAX_CONTACTOS];

        //Introducimos unos contactos de pruebas
        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Eva Rey";
        fechasNacimiento[ocupacion] = "20/02/1990";
        telefonos[ocupacion] = 981212223;
        tipos[ocupacion] = 'A';
        ocupacion++;
        siguienteID++;

        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Luis Pérez";
        fechasNacimiento[ocupacion] = "22/12/1980";
        telefonos[ocupacion] = 678767567;
        tipos[ocupacion] = 'E';
        ocupacion++;
        siguienteID++;

        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Evaristo Risto";
        fechasNacimiento[ocupacion] = "11/06/2000";
        telefonos[ocupacion] = 985675675;
        tipos[ocupacion] = 'F';
        ocupacion++;
        siguienteID++;

        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Juana Lana";
        fechasNacimiento[ocupacion] = "03/05/1950";
        telefonos[ocupacion] = 798786787;
        tipos[ocupacion] = 'E';
        ocupacion++;
        siguienteID++;

    }

    private static void listarContactos() {
        for (int i = 0; i < ocupacion; i++) {
            System.out.println(ids[i] + " " + nombres[i]);
        }
    }

    private static void mostrarDetalle() {
        Scanner teclado = new Scanner(System.in);
        int idBuscado;

        //Pedimos el id del contacto buscado
        System.out.print("De qué contacto quieres información?:");
        idBuscado = teclado.nextInt();

        //Recorremos el array de ids hasta encontrarlo o alcanzar el fin
        for (int i = 0; i < ocupacion; i++) {
            if (ids[i] == idBuscado) {
                System.out.println("ID: " + ids[i]);
                System.out.println("Nombre: " + nombres[i]);
                System.out.println("Fecha Nacimiento: " + fechasNacimiento[i]);
                System.out.println("Teléfono: " + telefonos[i]);
                System.out.println("Tipo: " + tipos[i]);
                return;
            }

            System.out.println("No hay un contacto con ID:" + idBuscado);
        }
    }

    private static void nuevoContacto() {
        Scanner teclado = new Scanner(System.in);

        ids[ocupacion] = siguienteID;

        System.out.print("Nombre:");
        nombres[ocupacion] = teclado.nextLine();

        System.out.print("Fecha Nacimiento:");
        fechasNacimiento[ocupacion] = teclado.nextLine();

        System.out.print("Teléfono:");
        telefonos[ocupacion] = teclado.nextLong();

        System.out.print("Tipo(A|E|F|T):");
        teclado.nextLine(); //Lectura para quitar el último INTRO del buffer
        String strTipo = teclado.nextLine();

        tipos[ocupacion] = strTipo.charAt(0);

        siguienteID++;
        ocupacion++;

    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        int idABorrar;
        int posicionABorrar;

        //Pedimos el id del contacto que se quiere borrar
        System.out.print("Qué contacto quieres borrar?:");
        idABorrar = teclado.nextInt();

        //Recorremos el array de ids hasta encontrarlo y copiamos
        //los siguientes (hasta el final) una posición hacia atrás
        for (int i = 0; i < ocupacion; i++) {
            if (ids[i] == idABorrar) {
                for (int j = i + 1; j < ocupacion; j++) {
                    ids[j-1] = ids[j];
                    nombres[j-1] = nombres[j];
                    fechasNacimiento[j-1] = fechasNacimiento[j];
                    telefonos[j-1] = telefonos[j];
                    tipos[j-1] = tipos[j];
                }
                ocupacion--;
                return;
            }

            System.out.println("No hay un contacto con ID:" + idABorrar);
        }

    }

}
