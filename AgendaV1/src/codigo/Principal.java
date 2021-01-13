package codigo;

import java.util.Scanner;

public class Principal {

    private static final int MAX_CONTACTOS = 10;
    private static int ocupacion = 0;
    private static int siguienteID = 0;

    private static int[] ids;
    private static String[] nombres;
    private static String[] fechasDeNacimiento;
    private static long[] telefonos;
    private static char[] tipos;

    public static void main(String[] args) {

        boolean salir = false;
        Scanner teclado = new Scanner(System.in);
        String opcion;

        //Cargamos datos al arrancar
        cargarContactos();

        System.out.println("AGENDA DE CONTACTOS");

        do {
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)istar todos");
            System.out.println("(D)etalle");
            System.out.println("(S)alir");
            System.out.println(" ");
            System.out.print("Elije una opcion: ");
            opcion = teclado.nextLine();

            switch (opcion) {
                case "A":
                    nuevoContacto();
                    break;
                case "B":
                    System.out.println("Borrar contacto");
                    break;
                case "L":
                    listarContactos();
                    break;
                case "D":
                    mostrarDetalle();
                    break;
                case "S":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (salir != true);
    }

    private static void cargarContactos() {

        //Creamos los arrays
        ids = new int[MAX_CONTACTOS];
        nombres = new String[MAX_CONTACTOS];
        fechasDeNacimiento = new String[MAX_CONTACTOS];
        telefonos = new long[MAX_CONTACTOS];
        tipos = new char[MAX_CONTACTOS]; //(A)migo, (E)nemigo, (F)amilia, (T)rabajo

        //Introducimos unos contactos de pruebas
        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Eva Rey";
        fechasDeNacimiento[ocupacion] = "20/02/1999";
        telefonos[ocupacion] = 981212223;
        tipos[ocupacion] = 'A';
        ocupacion++;
        siguienteID++;

        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Pepe Lopez";
        fechasDeNacimiento[ocupacion] = "15/07/1993";
        telefonos[ocupacion] = 986456985;
        tipos[ocupacion] = 'E';
        ocupacion++;
        siguienteID++;

        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Elisa Martinez";
        fechasDeNacimiento[ocupacion] = "02/11/2001";
        telefonos[ocupacion] = 677123456;
        tipos[ocupacion] = 'T';
        ocupacion++;
        siguienteID++;

        ids[ocupacion] = siguienteID;
        nombres[ocupacion] = "Pablo Vila";
        fechasDeNacimiento[ocupacion] = "30/04/1989";
        telefonos[ocupacion] = 676336655;
        tipos[ocupacion] = 'F';
        ocupacion++;
        siguienteID++;
    }

    private static void listarContactos() {
        for (int i = 0; i < ocupacion; i++) {
            System.out.println(ids[i] + " " + nombres[i]);
        }
        System.out.println("");
    }

    private static void mostrarDetalle() {
        Scanner teclado = new Scanner(System.in);
        int idBuscado;
        
        System.out.print("ID del contacto a imprimir: ");
        idBuscado = teclado.nextInt();

        for (int i = 0; i < ocupacion; i++) {
            if (ids[i]==idBuscado){
                System.out.println("ID: "+ids[i]);
                System.out.println("Nombre: "+nombres[i]);
                System.out.println("Fecha de nacimiento: "+fechasDeNacimiento[i]);
                System.out.println("Teléfono: "+telefonos[i]);
                System.out.println("Tipo: "+tipos[i]);
                System.out.println("");
                return;
            }
        }
        System.out.println("El ID "+idBuscado+" no está en la agenda.");
        System.out.println("");
    }
    
    private static void nuevoContacto() {
    
        Scanner teclado=new Scanner(System.in);
        
        ids[ocupacion]=siguienteID;
        
        System.out.println("ALTA DE CONTACTO");
        
        System.out.print("Nombre: ");
        nombres[ocupacion]=teclado.nextLine();
        System.out.print("Fecha de Nacimiento: ");
        fechasDeNacimiento[ocupacion]=teclado.nextLine();
        System.out.print("Tipo: A|E|F|T: ");
        String strTipo=teclado.nextLine();
        tipos[ocupacion]=strTipo.charAt(0);
        System.out.print("Telefono: ");
        telefonos[ocupacion]=teclado.nextLong();
        System.out.println("");
        
        ocupacion++;
        siguienteID++;
    
    }
    
}
