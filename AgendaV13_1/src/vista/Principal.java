package vista;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Tipo;
import modelo.Usuario;

public class Principal {

    /*Para que un objeto sea global lo declaramos aquí (antes del main),
    también se podría inicializar pero es más recomendable hacerlo en el main */
    public static Agenda miAgenda;

    public static void main(String[] args) {

        miAgenda = new Agenda();//Inicializamos el objeto, es global porque está inicializado antes del main.
        boolean salir = false;
        String opcion;
        Scanner teclado = new Scanner(System.in);

        try {
            loguearse();
        } catch (FileNotFoundException ex) {
            System.out.println("Error, no se pudieron cargar los usuarios");
        }
        cargarContactos();

        do {
            System.out.println("\n");
            System.out.println("****** AGENDA DE CONTACTOS ******");
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)lista");
            System.out.println("(D)etalle");
            System.out.println("(M)odificar");
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
                case "L":
                case "l":
                    listarContactos();
                    break;
                case "S":
                case "s":
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

    private static void loguearse() throws FileNotFoundException {

        boolean log = false;
        
        System.out.println("Bienvenido a la Agenda de Contactos");
        System.out.println("Procedamos a su identificación\n");
        do {

            try {
                Scanner teclado = new Scanner(System.in);
                String linea;
                Usuario u;
                int indice;
                
                //Cosntruimos un Scanner para leer el fichero de contactos
                Scanner lectorFicheroUsers = new Scanner(new FileReader("users.txt"));
                
                //Pedimos usuario y contraseña
                System.out.print("Usuario: ");
                String strUser = teclado.nextLine();
                System.out.print("Contraseña: ");
                String strClave = teclado.nextLine();
                
                //Leemos el fichero y guardamos los datos de los usuarios 
                //autorizados en la agenda
                while (lectorFicheroUsers.hasNextLine()) {
                    linea = lectorFicheroUsers.nextLine();
                    u = new Usuario(linea);
                    if (miAgenda.addUsuario(u) == false) {
                        System.out.println("Error al cargar usuario");
                        break;
                    }
                }
                
                //Cerramos fichero
                lectorFicheroUsers.close();
                
                //Comprobamos que los datoos introducidos por teclado coinciden
                //o no con los datos que había en el fichero
                indice = miAgenda.compruebaUsuario(strUser, strClave);
                
                //Si los datos coinciden cambia el valor de log y entramos en la
                //agenda. Si no, se repite el while y nos vuelve a pedir usuario
                //y contraseña
                if (indice != -1) {
                    log = true;
                } else {
                    System.out.println("Usuario o contraseña (o ambos) incorrecto\n");
                }

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Error, no se pudieron cargar los usuarios");
            }

        } while (log != true);

    }

    private static void cargarContactos() {

        try {
            String linea;
            Contacto c;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            //Cosntruimos un Scanner para leer el fichero de contactos
            Scanner lectorFichero = new Scanner(new FileReader("registro.txt"));
            //Leemos la 1ª linea que es el siguienteId y se lo pasamos a la agenda
            String strSiguienteId = lectorFichero.nextLine();
            int siguienteid = Integer.parseInt(strSiguienteId);
            miAgenda.setSiguienteID(siguienteid);
            //Leemos lineas hasta agotar el fichero y con cada una de ellos
            //construimos un contacto y lo añadimos a la agenda
            while (lectorFichero.hasNextLine()) {
                linea = lectorFichero.nextLine();
                c = new Contacto(linea);
                if (miAgenda.addContactoFromFile(c) == false) {
                    System.out.println("No se pueden añadir contactos a la agenda");
                    break;
                }
            }

            //Cerramos el escaner
            lectorFichero.close();;

        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el fichero, la agenda abrirá vacía");
        } catch (NumberFormatException ex) {
            System.out.println("Error al leer el fichero de contatctos. Fichero mal formado");
        }
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
        
        //Obtenemos el contacto buscado
        contactoDetalle = miAgenda.getContactoById(idBuscado);
        
        //Imprimimos en contacto
        if (contactoDetalle != null) {
            System.out.println("");
            System.out.println("ID: " + contactoDetalle.getId());
            System.out.println("Nombre: " + contactoDetalle.getNombre());
            System.out.println("Fecha de nacimiento: " + sdf.format(contactoDetalle.getFechaNacimiento()));
            System.out.println("Telefono: " + contactoDetalle.getTelefono());
            System.out.println("Tipo: " + contactoDetalle.getTipo());
            System.out.println("Propiedad: " + contactoDetalle.isTieneCoche());
        } else {
            System.out.println("El contacto seleccionado no existe");
        }
    }

    private static void nuevoContacto() {

        Scanner teclado = new Scanner(System.in);
        String linea;
        String nombre;
        long telefono;
        Tipo tipo;
        boolean tieneCoche;
        boolean cargaOk;
        Date fechaNacimiento = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        /*Pedimos los campos necesariaros que forman un contacto, excepto el Id
        que lo coloca el programa automáticamente.
        También parseamos y tratamos las variables que sean necesarias para
        que cumplan con las condiciones de casa campo.*/
        try {
            System.out.print("Nombre:");
            nombre = teclado.nextLine();

            System.out.print("Fecha Nacimiento (dd/mm/aaaa)");
            linea = teclado.nextLine();
            char barra1 = linea.charAt(2);
            char barra2 = linea.charAt(5);
            int longitudCadena = linea.length();
            if ((barra1 != '/') || (barra2 != '/') || (longitudCadena != 10)) {
                System.out.println("Formato de fecha incorrecto");
                return;
            }
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
        
        //Cargamos el contacto en la agenda
        cargaOk = miAgenda.addContacto(new Contacto(nombre, fechaNacimiento, 
                telefono, tipo, tieneCoche));

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
        
        //Borramos el contacto de la agenda
        borradoOk = miAgenda.deleteContactoById(idABorrar);

        if (borradoOk == true) {
            System.out.println("Contacto borrado");
        } else {
            System.out.println("El contacto seleccionado no existe");
        }
    }

    private static void modificarContacto() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        int idBuscado = 0;
        Contacto modificar;
        char seleccion;
        long nuevoTelefono = 0;
        Tipo nuevoTipo;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDeNacimiento = null;
        
        //Pedimos el Id del contacto que queremos modificar
        System.out.print("Que contacto quieres modificar: ");
        linea = teclado.nextLine();

        try {
            idBuscado = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Formato de ID buscado incorrecto");
            return;
        }
        
        //Recuperamos el contacto
        modificar = miAgenda.getContactoById(idBuscado);
        
        //Pedimos el campo que queremos modificar y lo modificamos cumpliendo
        //con las condicones de cada campo
        if (modificar == null) {
            System.out.println("El contacto seleccionado no existe");
        } else {
            System.out.print("Que campo quieres modificar: (N)ombre, "
                    + "(F)echa de Nacimiento, (T)elefono, T(i)po, Tiene (c)oche: ");
            linea = teclado.nextLine();
            seleccion = linea.charAt(0);

            switch (seleccion) {
                case 'n':
                case 'N':
                    System.out.print("Nuevo nombre: ");
                    linea = teclado.nextLine();
                    modificar.setNombre(linea);
                    break;
                case 'f':
                case 'F':
                    System.out.print("Nueva fecha(dd/mm/yyyy): ");
                    linea = teclado.nextLine();
                    char barra1 = linea.charAt(2);
                    char barra2 = linea.charAt(5);
                    int longitudCadena = linea.length();
                    if ((barra1 != '/') || (barra2 != '/') || (longitudCadena != 10)) {
                        System.out.println("Formato de fecha incorrecto");
                        return;
                    }
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

    private static void guardarContactos() {

        Contacto registrarContacto;

        try {

            //Creamos un FileWriter apuntando al fichero contactos.txt que si ya
            //existe lo abre y si no, lo crea
            FileWriter escritor = new FileWriter("registro.txt");

            //Escribimos siguienteId al fichero
            escritor.write(miAgenda.getSiguienteID() + "\n");

            //Recorremos la agenda extrayendo los contactos y los escribo en el 
            //fichero
            for (Contacto c : miAgenda.getAllContactos()) {
                escritor.write(c.toRegistro() + "\n");
            }

            //Cerramos fichero
            escritor.close();

        } catch (IOException ex) {
            System.out.println("No se pudo escribir el fichero de contactos");
        }
    }

}
