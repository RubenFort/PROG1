package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;
import modelo.Tipo;

public class Principal {

    public static Agenda miAgenda;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String linea;
        boolean salir = false;

        cargarDatos();
        
        do {            
            System.out.println("(A)ñadir");
            System.out.println("(B)orrar");
            System.out.println("(L)istar");
            System.out.println("(D)etalle");
            System.out.println("(S)alir");
            System.out.print("Selecciona una opcion: ");
            linea = teclado.nextLine();
            
            switch (linea) {
                case "A":                
                case "a":
                    añadirContacto();
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
                case "S":                
                case "s":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!salir);

    }

    private static void cargarDatos() {
        miAgenda = new Agenda();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            miAgenda.addContacto(new Contacto("Pepe Luis", sdf.parse("02/11/1995"), 986326525, Tipo.AMIGO, true));
            miAgenda.addContacto(new Contacto("Alberto Lopez", sdf.parse("25/05/2002"), 677125852, Tipo.FAMILIA, false));
            miAgenda.addContacto(new Contacto("Juan Vila", sdf.parse("12/02/1987"), 676455884, Tipo.TRABAJO, false));
        } catch (ParseException e) {
            System.out.println("Datos no cargados, ERROR!!!");
        }
    }

    private static void listarContactos() {
        
        Contacto [] a=miAgenda.getAllContactos();
        
        for (Contacto contacto : a) {
            System.out.println("ID " + contacto.getId() + " " + contacto.getNombre());
        }
    }

    private static void detalleContacto() {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String linea;
        int idBuscado = 0;
        Contacto c;
        
        System.out.print("Detalle contacto: ");
        linea=teclado.nextLine();
        try {
            idBuscado = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(linea + " no es un número entero");
        }
        c=miAgenda.getContactoById(idBuscado);
        
        if(c==null){
            System.out.println("Contacto no existe");
        } else {
            System.out.println("" + c.getId());
            System.out.println("" + c.getNombre());
            System.out.println("" + sdf.format(c.getFechaNacimiento()));
            System.out.println("" + c.getTelefono());
            System.out.println("" + c.getTipo());
            System.out.println("" + c.isCoche());
        }
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String linea;
        int idBuscado = 0;
        boolean idBorrado;
        
        System.out.print("Borrar contacto: ");
        linea=teclado.nextLine();
        try {
            idBuscado = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(linea + " no es un número entero");
        }
        idBorrado=miAgenda.deleteContacto(idBuscado);
        
        if (idBorrado==true){
            System.out.println("Contacto borrado");
        } else {
            System.out.println("El Contacto seleccionado no existe");
        }
    }

    private static void añadirContacto() {
        Scanner teclado = new Scanner(System.in);
        String linea, nombre = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        long telefono = 0;
        Tipo tipo = null;
        boolean coche = false;
        
        try {
            System.out.println("Nombre: ");
            nombre = teclado.nextLine();
            
            System.out.println("Fecha: ");
            linea = teclado.nextLine();
            fecha = sdf.parse(linea);
            
            System.out.println("Telefono: ");
            linea = teclado.nextLine();
            telefono = Long.parseLong(linea);
            
            System.out.println("Tipo: ");
            linea = teclado.nextLine();
            tipo = Tipo.valueOf(linea.toUpperCase());
            
            System.out.println("Tiene coche: ");
            linea = teclado.nextLine();
            coche = Boolean.parseBoolean(linea);
        } catch (ParseException | NumberFormatException parseException) {
            System.out.println("Formato de datos incorrectos");
        }
        
        miAgenda.addContacto(new Contacto(nombre, fecha, telefono, tipo, coche));
        
    } 
}
