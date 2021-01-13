package codigo;

import java.util.Scanner;

public class Principal {

    public static final int MAX_CONTACTOS = 10;
    public static int ocupacion = 0;
    public static int siguienteID = 0;

    private static Contacto[] contactos;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        //Cargamos datos
        cargarDatos();

        do {
            System.out.println("AGENDA  CONTACTOS");
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)istar");
            System.out.println("(D)etalle");
            System.out.println("(E)ditar");
            System.out.println("(S)alir");
            System.out.println("(O)cupacion");
            System.out.print("Selecciona una opción: ");
            String seleccionMenu = teclado.nextLine();

            switch (seleccionMenu) {
                case "A":
                case "a":
                    nuevoContacto();
                    break;
                case "B":
                case "b":
                    borrarContacto();
                    break;
                case "L":
                case "l":
                    listarContactos();
                    break;
                case "D":
                case "d":
                    detalleContacto();
                    break;
                case "E":
                case "e":
                    editarContacto();
                    break;
                case "S":
                case "s":
                    salir = true;
                    break;
                case "O":
                case "o":
                    System.out.println("ocupacón: " + ocupacion);
                    System.out.println("siguienteId: " + siguienteID);
                    break;
                default:
                    System.out.println("Opción seleccionada incorrecta");
                    break;
            }
        } while (salir != true);
    }

    private static void cargarDatos() {

        //Creamos los arrays
        contactos = new Contacto[MAX_CONTACTOS];

        //Introducimos unos constactos de prueba;
        contactos[ocupacion] = new Contacto(siguienteID, "Ruben", "10/05/1999", 677454645, 'A', true);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Luis", "22/08/2005", 677223223, 'E', true);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Ana", "04/1/1982", 981789456, 'T', false);
        ocupacion++;
        siguienteID++;
        
    }

    private static void nuevoContacto() {
        Scanner teclado = new Scanner(System.in);
        String linea;

        contactos[ocupacion] = new Contacto();

        contactos[ocupacion].setId(siguienteID);
        System.out.print("Nombre: ");
        linea = teclado.nextLine();
        //String nombre = linea;
        contactos[ocupacion].setNombres(linea);
        System.out.print("Fecha nacimiento: ");
        linea = teclado.nextLine();
        //String fechaNacimiento = linea;
        contactos[ocupacion].setFecha(linea);
        System.out.print("Teléfono: ");
        linea = teclado.nextLine();
        long telefonoNuevo = Long.parseLong(linea);
        contactos[ocupacion].setTelefono(telefonoNuevo);
        System.out.print("Tipo, (A)migo (E)nemigo (F)amiliar (T)rabajo): ");
        linea = teclado.nextLine();
        char tipoNuevo = linea.charAt(0);
        contactos[ocupacion].setTipo(tipoNuevo);
        System.out.print("Tiene coche (true o false): ");
        linea = teclado.nextLine();
        boolean tieneCocheNuevo = Boolean.parseBoolean(linea);
        contactos[ocupacion].setTieneCoche(tieneCocheNuevo);
        
        //---------------------Otro método de introducir los datos, usando el CONSTRUCTOR-----------------------
        //contactos[ocupacion]= new Contacto(siguienteID, nombre, fechaNacimiento, telefonoNuevo, tipoNuevo, tieneCocheNuevo);
   
        ocupacion++;
        siguienteID++;
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        int idBorrado;
        
        System.out.print("Que contacto quieres borrar (ID): ");
        String strEntero = teclado.nextLine();
        idBorrado = Integer.parseInt(strEntero);
        
        
        if (idBorrado<0 || idBorrado>=ocupacion) {
            System.out.println("El contacto buscado es incorrecto");
            return;
        }

        for (int i = 0; i < ocupacion; i++) {
            if (idBorrado == contactos[i].getId()) {
                for (int j = i+1; j < ocupacion; j++) {
                    contactos[j-1] = contactos[j];
                }
                ocupacion--;
                return;
            }
        }
        System.out.println("El contacto buscado es incorrecto");
    }

    private static void listarContactos() {
        for (int i = 0; i < ocupacion; i++) {
            System.out.println("ID: " + contactos[i].getId()+"  Nombre: " + contactos[i].getNombres());
        }
    }

    private static void detalleContacto() {

        Scanner teclado = new Scanner(System.in);
        String linea;
        int idBuscado;

        System.out.print("De que ID quieres ver el detalle?: ");
        linea = teclado.nextLine();
        idBuscado = Integer.parseInt(linea);
        
        if (idBuscado<0 || idBuscado>=ocupacion) {
            System.out.println("El contacto buscado es incorrecto");
            return;
        }

        for (int i = 0; i < ocupacion; i++) {
            if (idBuscado == contactos[i].getId()) {
                System.out.println("ID: " + contactos[i].getId());
                System.out.println("Nombre: " + contactos[i].getNombres());
                System.out.println("Fecha Nacimiento: " + contactos[i].getFecha());
                System.out.println("Telefono: " + contactos[i].getTelefono());
                System.out.println("Tipo: " + (contactos[i].getTipo() == 'A' ? "Amigo" : contactos[i].getTipo()
                        == 'E' ? "Enemigo" : contactos[i].getTipo() == 'F' ? "Familiar" : contactos[i].getTipo()
                        == 'T' ? "Trabajo" : "Tipo desconocido"));/*mayor=(x>y)?x:y; if ternario*/
                System.out.println("Tiene Coche: " + contactos[i].isTieneCoche());
                System.out.println("");
                return;
            }
        }
         System.out.println("El contacto buscado es incorrecto");
    }

    private static void editarContacto() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Que contacto(ID) quieres editar: ");
        String strEntero = teclado.nextLine();
        int editarId = Integer.parseInt(strEntero);

        for (int i = 0; i < ocupacion; i++) {
            if (editarId == contactos[i].getId()) {
                System.out.println("(N)ombre");
                System.out.println("(F)echa de nacimiento");
                System.out.println("(T)elefono");
                System.out.println("Ti(p)o");
                System.out.println("T(i)ene coche");
                System.out.print("Que campo quieres editar?: ");
                String editaCampo = teclado.nextLine();

                switch (editaCampo) {
                    case "N":
                    case "n":
                        System.out.print("Nombre: ");
                        String cadena = teclado.nextLine();
                        contactos[i].setNombres(cadena);

                        return;
                    case "F":
                    case "f":
                        System.out.print("Fecha de nacimiento: ");
                        cadena = teclado.nextLine();
                        contactos[i].setFecha(cadena);
                        return;
                    case "T":
                    case "t":
                        System.out.print("Telefono: ");
                        String strLong = teclado.nextLine();
                        long editarTelefono = Long.parseLong(strLong);
                        contactos[i].setTelefono(editarTelefono);
                        return;
                    case "P":
                    case "p":
                        System.out.print("Tipo: ");
                        String strTipo = teclado.nextLine();
                        char editarTipo = strTipo.charAt(0);
                        contactos[i].setTipo(editarTipo);
                        return;
                    case "I":
                    case "i":
                        System.out.print("Tiene coche (true|false): ");
                        String strTieneCoche = teclado.nextLine();
                        boolean editarTieneCoche = Boolean.parseBoolean(strTieneCoche);
                        contactos[i].setTieneCoche(editarTieneCoche);
                        return;
                    default:
                        System.out.println("Campo incorrecto");
                        return;
                }
            }
        }
        System.out.println("ID incorrecto");
    }
}
