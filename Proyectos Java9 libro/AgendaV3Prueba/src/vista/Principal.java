package vista;

import modelo.Agenda;
import modelo.Contacto;
import java.util.Scanner;

public class Principal {
    
    public static Agenda miAgenda;
    public static Contacto [] contactos;
    
    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        String seleccion;
        boolean salir=false;
        miAgenda= new Agenda();
        
        cargarContactos();
        
        do {            
            System.out.println("******AGENDA DE CONTACTOS******");
            System.out.println("");
            System.out.println("(A)ñadir contacto");
            System.out.println("(B)orrar contacto");
            System.out.println("(L)istar contactos");
            System.out.println("(D)etalle contactos");
            System.out.println("(S)alir");
            System.out.println("");
            System.out.print("Selecciona una opción: ");
            seleccion = teclado.nextLine();
            
            switch (seleccion) {
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
                case "S":
                case "s":
                    salir=true;
                    break;
                default:
                    System.out.println("La opción seleccionada no existe");
            }
        } while (salir!=true);
        
    }

    private static void cargarContactos() {
        
        boolean operacionOK;
        contactos = new Contacto[miAgenda.getCAPACIDAD()];
        
        contactos[0] = new Contacto("Ruben Lopez", "12/03/2003", 677456454, 'A', true);
        operacionOK=miAgenda.addContacto(contactos[0]);        
        if (operacionOK==true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
        
        contactos[1] = new Contacto("Ana Vila", "28/12/1998", 676223522, 'A', false);
        operacionOK=miAgenda.addContacto(contactos[1]);
        if (operacionOK==true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
        
        contactos[2] = new Contacto("Pepu Hernandez", "08/08/1980", 676114114, 'F', false);
        operacionOK=miAgenda.addContacto(contactos[2]);
        if (operacionOK==true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
        
        contactos[3] = new Contacto("Luis Pitís", "04/10/2015", 984232658, 'T', true);
        operacionOK=miAgenda.addContacto(contactos[3]);
        if (operacionOK==true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
    }
    
    private static void nuevoContacto() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        Contacto contactoNuevo = new Contacto ();
        boolean operacionOK;
        
        System.out.print("Nombre: ");
        linea = teclado.nextLine();
        contactoNuevo.setNombre(linea);
        System.out.print("Fecha de nacimiento: ");
        linea = teclado.nextLine();
        contactoNuevo.setFechaNacimiento(linea);
        System.out.print("Teléfono: ");
        linea = teclado.nextLine();
        long telefonoNuevo=Long.parseLong(linea);
        contactoNuevo.getFechaNacimiento();
        System.out.print("Tipo (A|E|T|F): ");
        linea = teclado.nextLine();
        char tipoNuevo = linea.charAt(0);
        contactoNuevo.getTipo();
        System.out.print("Coche en propiedad (true|false): ");
        linea = teclado.nextLine();
        boolean propiedadNuevo=Boolean.parseBoolean(linea);
        contactoNuevo.setTipo(tipoNuevo);
        
        operacionOK=miAgenda.addContacto(contactoNuevo);
        
        if (operacionOK==true) {
            System.out.println("Contacto cargado");
        } else {
            System.out.println("No se pudo cargar el contacto, agenda llena");
        }
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner (System.in);
        String linea;
        int borrarID;
        boolean operacionOK;
        
        System.out.print("Que contacto quieres borrar(ID)?: ");
        linea=teclado.nextLine();
        borrarID=Integer.parseInt(linea);
        
        operacionOK=miAgenda.dropContacto(borrarID);
        
        if (operacionOK==true) {
            System.out.println("Contacto borrado");
        } else {
            System.out.println("No se pudo borrar el contacto");
        }
        
    }

    private static void listarContactos() {
        
        Contacto [] c;
        c=miAgenda.getAllContactos();
        
        for (int i = 0; i < c.length; i++) {
            System.out.println("");
            System.out.println("ID: " + c[i].getId() + "  Nombre: " + c[i].getNombre());
        }
        System.out.println("");
    }

    private static void detalleContacto() {
        Scanner teclado=new Scanner (System.in);
        int detalleId;
        String linea;
        boolean operacionOK;
        Contacto contactoMostrado;
        
        System.out.print("Que contacto quieres ver (ID): ");
        linea=teclado.nextLine();
        detalleId = Integer.parseInt(linea);
        
        contactoMostrado=miAgenda.getContactoById(detalleId);
        
        if(contactoMostrado==null){
            System.out.println("El contacto no existe");
        } else {
            System.out.println("");
            System.out.println("ID: "+contactoMostrado.getId());
            System.out.println("Nombre: "+contactoMostrado.getNombre());
            System.out.println("Fecha de Nacimiento: "+contactoMostrado.getFechaNacimiento());
            System.out.println("Telefono: "+contactoMostrado.getTelefono());
            System.out.println("Tipo: "+(contactoMostrado.getTipo()=='A'?"Amigo":
                    contactoMostrado.getTipo()=='E'?"Enemigo":
                    contactoMostrado.getTipo()=='F'?"Familia":
                    contactoMostrado.getTipo()=='T'?"Trabajo":"Desconocido"));
            System.out.println("Coche en propiedad: "+contactoMostrado.isTieneCoche());
            System.out.println("");
        }
    }

}
