package vista;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Tipo;
import modelo.Usuario;

public class Principal {

    /*Para que un objeto sea global lo declaramos aquí (antes del main),
    también se podría inicializar pero es más recomendable hacerlo en el main */
    public static Agenda miAgenda;
    public static Usuario miUsuario;

    public static void main(String[] args) throws IOException {

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

        registraActicidad(salir);

        System.out.println(" " + miUsuario.getUsuario() + " " + miUsuario.getContrasena());

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
                    registraActicidad(salir);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!salir);
    }

    private static void loguearse() throws FileNotFoundException {

        boolean log = false;
        Connection connection = null;
        Statement sentencia;
        ResultSet datos;

        System.out.println("Bienvenido a la Agenda de Contactos");
        System.out.println("Procedamos a su identificación\n");
        do {

            Scanner teclado = new Scanner(System.in);
            String linea;
            String bdUser;
            String bdClave;
            Usuario u;
            int indice;

            //Pedimos usuario y contraseña
            System.out.print("Usuario: ");
            String strUser = teclado.nextLine();
            System.out.print("Contraseña: ");
            String strClave = teclado.nextLine();

            try {
                //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1234abc.");
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //Crear una sentencia (statement)
                sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

                //Crear una consulta (query), ejecutarla y recuperar los datos (ResultSet)
                datos = sentencia.executeQuery("SELECT * FROM usuario");

                //Recorre el ResultSet recuperando las filas (registros) y a partir de ellas las columnas
                //Guardamos los datos de los usuarios autorizados en la agenda
                while (datos.next()) {
                    bdUser = datos.getString("usu"); //Buscamos en columna usuario
                    bdClave = datos.getString("clave"); //Buscamos en columna clave

                    miAgenda.addUsuario(new Usuario(bdUser, bdClave));

                }

            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Comprobamos que los datoos introducidos por teclado coinciden
            //o no con los datos que hay en la BBDD
            indice = miAgenda.compruebaUsuario(strUser, strClave);
            //Si los datos coinciden cambia el valor de log y entramos en la
            //agenda. Si no, se repite el while y nos vuelve a pedir usuario
            //y contraseña
            if (indice != -1) {
                miUsuario = new Usuario(strUser, strClave);
                log = true;
            } else {
                System.out.println("Usuario o contraseña (o ambos) incorrecto\n");
            }

        } while (log != true);

    }

    private static void cargarContactos() {

        Connection connection = null;
        Statement sentencia;
        ResultSet datos;
        int siguienteId;

        try {
            //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1234abc.");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Leemos tabla regID
        try {
            //Crear una sentencia (statement)
            sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

            //Crear una consulta (query), ejecutarla y recuperar los datos (ResultSet)
            datos = sentencia.executeQuery("SELECT * FROM regid");

            //Recorre el ResultSet recuperando las filas (registros) y a partir de ellas las columnas
            //Guardamos los datos de los usuarios autorizados en la agenda
            while (datos.next()) {
                siguienteId = datos.getInt("siguienteId"); //Buscamos en columna siguienteId
                miAgenda.setSiguienteID(siguienteId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Leemos tabla contacto
        try {
            Contacto c;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            //Crear una sentencia (statement)
            sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

            //Crear una consulta (query), ejecutarla y recuperar los datos (ResultSet)
            datos = sentencia.executeQuery("SELECT * FROM contacto");

            //Recorre el ResultSet recuperando las filas (registros) y a partir de ellas las columnas
            //Guardamos los datos de los usuarios autorizados en la agenda
            while (datos.next()) {
                int IdBD = datos.getInt("id"); //Buscamos en columna siguienteId
                String nombreBD = datos.getString("nombre"); //Buscamos en columna siguienteId
                Date fechaNacimientoBD = datos.getDate("fechaNacimiento"); //Buscamos en columna siguienteId
                long telefonoBD = datos.getLong("telefono"); //Buscamos en columna siguienteId
                String strTipo = datos.getString("tipo"); //Buscamos en columna siguienteId
                boolean tieneConcheBD = datos.getBoolean("tieneCoche"); //Buscamos en columna siguienteId

                Tipo tipoBD = Tipo.valueOf(strTipo);

                c = new Contacto(IdBD, nombreBD, fechaNacimientoBD, telefonoBD, tipoBD, tieneConcheBD);

                if (miAgenda.addContactoFromBD(c) == false) {
                    System.out.println("No se pueden añadir contactos a la agenda");
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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
        String strTipo;
        boolean tieneCoche;
        boolean cargaOk;
        Date fechaNacimiento = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        Statement sentencia;

        /*Pedimos los campos necesariaros que forman un contacto, excepto el Id
        que lo coloca el programa automáticamente.
        También parseamos y tratamos las variables que sean necesarias para
        que cumplan con las condiciones de casa campo.*/
        try {
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            System.out.print("Fecha Nacimiento (dd/mm/aaaa): ");
            linea = teclado.nextLine();
            char barra1 = linea.charAt(2);
            char barra2 = linea.charAt(5);
            int longitudCadena = linea.length();
            if ((barra1 != '/') || (barra2 != '/') || (longitudCadena != 10)) {
                System.out.println("Formato de fecha incorrecto");
                return;
            }
            fechaNacimiento = sdf.parse(linea);

            System.out.print("Teléfono: ");
            linea = teclado.nextLine();
            telefono = Long.parseLong(linea);

            System.out.print("Tipo(Amigo|Enemigo|Familia|Trabajo): ");
            strTipo = teclado.nextLine().toUpperCase();
            tipo = Tipo.valueOf(strTipo);

            System.out.print("¿Tiene coche? (true|false): ");
            linea = teclado.nextLine();
            tieneCoche = Boolean.parseBoolean(linea);
        } catch (Exception e) {
            System.out.println("Datos erroneos");
            return;
        }
        int sigIdBD = miAgenda.getSiguienteID();
        try {
            //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1234abc.");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Crear una sentencia (statement)
            sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

            /*//Crear una consulta (query), ejecutarla y recuperar los datos (ResultSet)
                sentencia.executeUpdate("DELETE FROM contacto WHERE id = 11");
             */
            long tmpFecha = fechaNacimiento.getTime();
            
            Date fechaNacimientoSQL = new java.sql.Date(tmpFecha);
            
            PreparedStatement pst = connection.prepareStatement("INSERT INTO contacto (id, nombre, telefono, tipo, tieneCoche, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setInt(1, sigIdBD);
            pst.setString(2, nombre);
            pst.setLong(3, telefono);
            pst.setString(4, strTipo);
            pst.setBoolean(5, tieneCoche);
            pst.setDate(6, (java.sql.Date) fechaNacimientoSQL);
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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
        Connection connection = null;
        Statement sentencia;
        ResultSet datos;;

        try {
            System.out.print("Qué contacto quieres borrar?:");
            linea = teclado.nextLine();
            idABorrar = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Formato contacto incorrecto");
            return;
        }

        try {
            //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1234abc.");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Crear una sentencia (statement)
            sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

            /*//Crear una consulta (query), ejecutarla y recuperar los datos (ResultSet)
                sentencia.executeUpdate("DELETE FROM contacto WHERE id = 11");
             */
            PreparedStatement pst = connection.prepareStatement("DELETE FROM contacto WHERE id = ?");

            pst.setInt(1, idABorrar);
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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
        Connection connection = null;
        Statement sentencia;

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

            try {
                //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1234abc.");
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (seleccion) {
                case 'n':
                case 'N':
                    System.out.print("Nuevo nombre: ");
                    linea = teclado.nextLine();
                    modificar.setNombre(linea);
                    try {
                        //Crear una sentencia (statement)
                        sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

                        PreparedStatement pst = connection.prepareStatement("UPDATE contacto SET nombre = ? WHERE id = ?");
                        pst.setString(1, linea);
                        pst.setInt(2, idBuscado);
                        pst.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    
                    long tmpFecha = fechaDeNacimiento.getTime();
            
                    Date fechaNacimientoSQL = new java.sql.Date(tmpFecha);
                    
                    try {
                        //Crear una sentencia (statement)
                        sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

                        PreparedStatement pst = connection.prepareStatement("UPDATE contacto SET fechaNacimiento = ? WHERE id = ?");
                        pst.setDate(1, (java.sql.Date) fechaNacimientoSQL);
                        pst.setInt(2, idBuscado);
                        pst.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
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
                    try {
                        //Crear una sentencia (statement)
                        sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

                        PreparedStatement pst = connection.prepareStatement("UPDATE contacto SET telefono = ? WHERE id = ?");
                        pst.setLong(1, nuevoTelefono);
                        pst.setInt(2, idBuscado);
                        pst.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        //Crear una sentencia (statement)
                        sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

                        PreparedStatement pst = connection.prepareStatement("UPDATE contacto SET tipo = ? WHERE id = ?");
                        pst.setString(1, linea);
                        pst.setInt(2, idBuscado);
                        pst.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 'c':
                case 'C':
                    System.out.print("Nuevo tiene coche: ");
                    linea = teclado.nextLine();
                    boolean nuevoTieneCoche = Boolean.parseBoolean(linea);
                    modificar.setTieneCoche(nuevoTieneCoche);
                    try {
                        //Crear una sentencia (statement)
                        sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);

                        PreparedStatement pst = connection.prepareStatement("UPDATE contacto SET tieneCoche = ? WHERE id = ?");
                        pst.setBoolean(1, nuevoTieneCoche);
                        pst.setInt(2, idBuscado);
                        pst.execute();

                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    System.out.println("La opción seleccionada no existe");
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }

    private static void guardarContactos() {

        Connection connection = null;
        Statement sentencia;
        int guardarId;

        try {
            //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1234abc.");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        guardarId = miAgenda.getSiguienteID();

        try {
            //Crear una sentencia (statement)
            sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);
            PreparedStatement pstDelete = connection.prepareStatement("DELETE FROM regid");
            pstDelete.execute();
            PreparedStatement pstInsert = connection.prepareStatement("INSERT INTO regid (siguienteId) VALUES (?)");
            pstInsert.setInt(1, guardarId);
            pstInsert.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void registraActicidad(boolean b) {

        try {
            FileWriter escritor = new FileWriter("actividad.txt", true);
            Date ahora = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");
            String accion;

            if (b == false) {
                accion = "entrar";
            } else {
                accion = "salir";
            }

            escritor.write(miUsuario.getUsuario() + " " + sdf.format(ahora) + " " + accion + "\n");
            escritor.close();
        } catch (IOException iOException) {
            System.out.println("No se pudo registrar la accion");
        }
    }

}
