package vista;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import agenda.Agenda;
import agenda.Contacto;
import agenda.Tipo;

public class Principal {

    private static Agenda agenda;

    public static void main(String[] args) {

        boolean salir = false;
        String opcion;
        Scanner teclado = new Scanner(System.in);

        //Cargamos datos al arrancar dede el fichero contactos.txt
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
                    guardarContactos();
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

        try {
            String linea;
            Contacto c;

            //Creamos la agenda
            agenda = new Agenda();

            //Construímos un Scanner para leer el fichero de contactos
            Scanner lector = new Scanner(new FileReader("contactos.txt"));

            //Leemos una 1ª línea que es el siguienteID y se lo pasamos a la agenda
            String strSiguienteID = lector.nextLine();
            int siguienteID = Integer.parseInt(strSiguienteID);
            agenda.setSiguienteID(siguienteID);

            //Leemos líneas (registros) hasta agotar el fichero y con cada una de ellas
            //construímos un contacto y lo añadimos a la agenda
            while (lector.hasNextLine()) {
                linea = lector.nextLine();
                c = new Contacto(linea);
                if (!agenda.addContactoFromFile(c)) {
                    System.out.println("No se pueden añadir contactos a la agenda");
                    break;
                }
            }

            //Cerrar el Scanner
            lector.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido abrir el fichero de contactos. La agenda se abrirá vacía");
        } catch (NumberFormatException ex) {
            System.out.println("Error al leer del fichero de contactos. Fichero mal formado");
        }

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

    @SuppressWarnings("ConvertToTryWithResources")
    private static void guardarContactos() {
        try {
            //Creamos un FileWriter apuntando al fichero contactos.txt que si ya
            //existe lo abre para escribir y si no existe los cfea y lo abre
            FileWriter escritor = new FileWriter("contactos.txt");

            //Escribimos sigienteID al fichero
            escritor.write(agenda.getSiguienteID() + "\n");

            //Recorremos toda la agenda extrayendo los contantos y
            //los escribimos al fichero
            for (Contacto c : agenda.getAllContactos()) {
                escritor.write(c.toRegistro() + "\n");
            }

            //Cerrar el FileWriter
            escritor.close();

        } catch (IOException ex) {
            System.out.println("No se puede escribir el fichero de contactos");
        }
    }

}
