package codigo;

import java.util.Scanner;

public class Principal {

    public static final int MAX_VIAJES = 32;
    public static int ocupacion = 0;
    public static int siguienteId = 0;

    public static int[] ids;
    public static String[] destinos;
    public static String[] fechas;
    /*  public static int[] dia;
    public static int[] mes;
    public static int[] ano;*/
    public static int[] precios;
    public static char[] tipos;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String opcion;
        boolean salir = false;

        cargarDatos();

        do {
            System.out.println("AGENDA DE VIAJES");
            System.out.println("(N)uevo Viaje: ");
            System.out.println("(L)istar Viajes: ");
            System.out.println("(D)etalle de viaje: ");
            System.out.println("(B)orrar Viaje: ");
            System.out.println("(S)alir: ");
            System.out.println("(O)cupacion");
            System.out.println("");
            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextLine();

            switch (opcion) {
                case "N":
                case "n":
                    nuevoViaje();
                    break;
                case "L":
                case "l":
                    listarDatos();
                    break;
                case "D":
                case "d":
                    mostrarDetalle();
                    break;
                case "B":
                case "b":
                    borrarViaje();
                    break;
                case "S":
                case "s":
                    salir = true;
                    break;
                case "O":
                case "o":
                    System.out.println("Ocupacion: " + ocupacion);
                    System.out.println("Siguiente ID: " + siguienteId);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (salir != true);
    }

    private static void cargarDatos() {
        System.out.println("cargra");

        ids = new int[MAX_VIAJES];
        destinos = new String[MAX_VIAJES];
        fechas = new String[MAX_VIAJES];
        precios = new int[MAX_VIAJES];
        tipos = new char[MAX_VIAJES];

        ids[ocupacion] = siguienteId;
        destinos[ocupacion] = "Japón";
        fechas[ocupacion] = "12/02/20021";
        precios[ocupacion] = 3050;
        tipos[ocupacion] = 'i';
        ocupacion++;
        siguienteId++;

        ids[ocupacion] = siguienteId;
        destinos[ocupacion] = "Turkia";
        fechas[ocupacion] = "23/11/2022";
        precios[ocupacion] = 1850;
        tipos[ocupacion] = 'i';
        ocupacion++;
        siguienteId++;

        ids[ocupacion] = siguienteId;
        destinos[ocupacion] = "Malaga";
        fechas[ocupacion] = "02/08/2020";
        precios[ocupacion] = 475;
        tipos[ocupacion] = 'n';
        ocupacion++;
        siguienteId++;

        ids[ocupacion] = siguienteId;
        destinos[ocupacion] = "Lugo";
        fechas[ocupacion] = "07/09/2020";
        precios[ocupacion] = 150;
        tipos[ocupacion] = 'l';
        ocupacion++;
        siguienteId++;
    }

    private static void nuevoViaje() {
        Scanner teclado = new Scanner(System.in);

        ids[ocupacion] = siguienteId;

        System.out.print("Destino del viaje: ");
        destinos[ocupacion] = teclado.nextLine();
        System.out.println("Fecha: ");
        fechas[ocupacion] = teclado.nextLine();
        System.out.println("Precio: ");
        precios[ocupacion] = teclado.nextInt();
        System.out.println("Tipo: ");
        teclado.nextLine();

        String strTipo = teclado.nextLine();
        tipos[ocupacion] = strTipo.charAt(0);

        ocupacion++;
        siguienteId++;

    }

    private static void listarDatos() {
        for (int i = 0; i < ocupacion; i++) {
            System.out.println("ID: " + ids[i] + " Destino: " + destinos[i]);
        }
    }

    private static void mostrarDetalle() {
        Scanner teclado = new Scanner(System.in);
        int buscado;

        System.out.print("Que Contacto(ID) quieres ver?: ");
        buscado = teclado.nextInt();

        for (int i = 0; i < ocupacion; i++) {
            if (buscado == ids[i]) {
                System.out.println("ID: " + ids[i]);
                System.out.println("Destino: " + destinos[i]);
                System.out.println("Fecha: " + fechas[i]);
                System.out.println("Precio: " + precios[i]);
                System.out.println("Tipo: " + tipos[i]);
                return;
            }
        }
        System.out.println("El contacto no está en la agenda");
    }

    private static void borrarViaje() {

        Scanner teclado = new Scanner(System.in);
        int borrado;

        System.out.print("Que contacto quieres borrar?: ");
        borrado = teclado.nextInt();

        for (int i = 0; i < ocupacion; i++) {
            if (borrado == ids[i]) {
                for (int j = i; j < ocupacion; j++) {
                    ids[i] = ids[i + 1];
                    destinos[i] = destinos[i + 1];
                    fechas[i] = fechas[i + 1];
                    precios[i] = precios[i + 1];
                    tipos[i] = tipos[i + 1];
                    ocupacion--;
                }
            }
        }
    }
}
