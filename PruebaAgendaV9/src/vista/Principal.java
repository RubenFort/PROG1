package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.Agenda;
import java.util.Scanner;
import modelo.Contacto;
import modelo.Tipo;

public class Principal {

    public static Agenda miAgenda;
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner (System.in);
        String linea; 
        boolean salir = false;
        
        cargarContactos();
        
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

    private static void cargarContactos(){
        miAgenda = new Agenda();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            miAgenda.addContacto(new Contacto("Pepe Couto", sdf.parse("12/11/2000"), 676558996, Tipo.AMIGO, true));
            miAgenda.addContacto(new Contacto("Luis Pérez", sdf.parse("01/05/1994"), 981212333, Tipo.ENEMIGO, false));
            miAgenda.addContacto(new Contacto("Juan Leis", sdf.parse("12/11/2000"), 981256567, Tipo.FAMILIA, true));
            miAgenda.addContacto(new Contacto("Ana Vila", sdf.parse("22/04/2016"), 657656454, Tipo.TRABAJO, false));
        } catch (Exception e) {
            System.out.println("No se pudo cargar contactos");
        }
    }
 
    private static void listarContactos() {
        for (Contacto contacto : miAgenda.getAllContactos()) {
            System.out.println(contacto.getId() + " " + contacto.getNombre());
        }
    }    
    
    private static void detalleContacto() {
        Scanner teclado = new Scanner (System.in);
        String linea;
        int seleccion = 0;
        boolean idValido=false;
        Contacto mostrar;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Que contacto quieres ver:? ");
        linea=teclado.nextLine();
        try {
            seleccion = Integer.parseInt(linea);
            idValido=true;
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Formato de ID incorrecto");
        }
        
        if (idValido) {
            mostrar = miAgenda.getContactoById(seleccion);
            if(mostrar==null){
                System.out.println("ID fuera de rango");
            } else {
            System.out.println("ID: " + mostrar.getId());
            System.out.println("Nombre: " + mostrar.getNombre());
            System.out.println("Fecha: " + sdf.format(mostrar.getFecha()));
            System.out.println("Telefono: " + mostrar.getTelefono());
            System.out.println("Tipo: " + mostrar.getTipo());
            System.out.println("Tiene Conche: " + mostrar.isTieneCoche());                
            }
        }
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner (System.in);
        String linea;
        int idBuscado = 0;
        boolean idBorrar;
        
        System.out.println("Que ID quieres borrar: ");
        linea = teclado.nextLine();
        
        try {
            idBuscado = Integer.parseInt(linea);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("No hay un contacto con ID:" + linea);
        }
        
        idBorrar = miAgenda.dropContacto(idBuscado);
        
        if (idBorrar=false) {
            System.out.println("EL contacto no está en la lista");
        } else {
            System.out.println("Contacto borrado");
        }
    }

    private static void añadirContacto() {
        Scanner teclado = new Scanner (System.in);
        String linea, strNombre, strFecha;
        long telefono;
        Tipo tipo;
        boolean propiedad;
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Nombre: ");
            strNombre = teclado.nextLine();
            
            System.out.print("Fecha: ");
            strFecha = teclado.nextLine();
            
            System.out.print("Telefono: ");
            linea = teclado.nextLine();
            telefono = Long.parseLong(linea);
            
            System.out.print("Tipo: ");
            linea = teclado.nextLine();
            tipo = Tipo.valueOf(linea.toUpperCase());
            
            System.out.print("Tiene coche: ");
            linea = teclado.nextLine();
            propiedad = Boolean.parseBoolean(linea);
            
            miAgenda.addContacto(new Contacto(strNombre, sdf.parse(strFecha), telefono, tipo, propiedad));
        } catch (NumberFormatException | ParseException numberFormatException) {
            System.out.println("Datos erroneos");
        }

    }
    
    
}
