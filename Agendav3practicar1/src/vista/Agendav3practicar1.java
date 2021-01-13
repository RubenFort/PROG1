
package vista;

import modelo.Contacto;
import modelo.Agenda;
import java.util.Scanner;

public class Agendav3practicar1 {

    public static Agenda  miAgenda = new Agenda ();
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String seleccion;
        boolean salir = false;
        
        cargarDatos();
        
        do {            
            
            System.out.println("AGENDA DE CONTACTOS");
            System.out.println("");
            System.out.println("(A)ñadir");
            System.out.println("(B)orrar");
            System.out.println("(L)istar");
            System.out.println("(D)etalle");
            System.out.println("Buscar por (T)ipo");
            System.out.println("Buscar por  t(E)lefono");
            System.out.println("(D)etalle");
            
            System.out.println("(O)cupacion");
            System.out.println("(S)alir");
            System.out.println("");
            System.out.print("Selecciona opción: ");
            seleccion=teclado.nextLine();
            
            switch(seleccion) {
                case "A": case "a":
                    nuevoContacto();
                    break;
                
                case "B": case "b":
                    borrarContacto();
                    break;
                
                case "L": case "l":
                    listarContactos();
                    break;
                
                case "T": case "t":
                   buscarPorTipo();
                    break;
                    
                case "E": case "e":
                   buscarPorTelefono();
                    break;
                    
                case "D": case "d":
                   detalleContacto();
                    break;
                    
                case "O": case "o":
                   System.out.println("Ocupacion: "+miAgenda.getOcupacion());
                   System.out.println("Siguiente ID: "+miAgenda.getSiguienteId());
                    break;
                
                case "S": case "s":
                    salir=true;
                    break;
                
                default:
                    System.out.println("selección incorrecta");
            }
            
        } while (salir!=true);
        
    }
    
    private static void cargarDatos() {
        
        boolean operacionOk;
        
        if (operacionOk = miAgenda.addContacto(new Contacto("Luis", "02/02/2002", 677456456, 'A', true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        
        if (operacionOk = miAgenda.addContacto(new Contacto("Pepe", "02/02/2020", 987654321, 'F', true))) {
            System.out.println("Contacto guardado");
        } else  {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        if (operacionOk = miAgenda.addContacto(new Contacto("Ana", "11/04/2001", 677123123, 'T', false))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        if (operacionOk = miAgenda.addContacto(new Contacto("Maria", "16/11/1995", 981252634, 'A', true))) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
    }
    
    private static void nuevoContacto() {
        
        Scanner teclado = new Scanner(System.in);
        String linea;
        Contacto c = new Contacto();
        
        System.out.println("");
        
        System.out.print("Nombre: ");
        linea=teclado.nextLine();
        c.setNombre(linea);
        
        System.out.print("Fecha de nacimiento: ");
        linea=teclado.nextLine();
        c.setFechaNacimiento(linea);
        
        System.out.print("Telefono: ");
        linea=teclado.nextLine();
        long nuevoTelefono = Long.parseLong(linea);
        c.setTelefono(nuevoTelefono);
        
        System.out.print("Tipo (A|E|F|T): ");
        linea=teclado.nextLine();
        char nuevoTipo = linea.charAt(0);
        c.setTipo(nuevoTipo);
        
        System.out.print("Tiene coche (true|false): ");
        linea=teclado.nextLine();
        boolean nuevoPropiedad = Boolean.parseBoolean(linea);
        c.setTieneCoche(nuevoPropiedad);
        
        if (miAgenda.addContacto(c)) {
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        System.out.println("");
    }

    private static void borrarContacto() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        
        System.out.print("Que contacto quieres borrar (ID)?: ");
        linea=teclado.nextLine();
        int borrarId = Integer.parseInt(linea);
        
        if (miAgenda.deleteContactoById(borrarId)) {
            System.out.println("Contacto borrado");
        } else {
            System.out.println("No se pudo borrar el contacto");
        }
                
    }

    private static void listarContactos() {

        Contacto [] todosLosContactos;
        
        todosLosContactos=miAgenda.getAllContactos();
        
        for (int i = 0; i < todosLosContactos.length; i++) {
            System.out.println("");
            System.out.println("ID: "+todosLosContactos[i].getId()+"   Nombre: "+todosLosContactos[i].getNombre());
        }
        System.out.println("");
    }

    private static void detalleContacto() {
        Scanner teclado = new Scanner(System.in);
        String linea;
        Contacto detalleContacto;
        
        System.out.print("Que contacto quieres ver (ID)?: ");
        linea=teclado.nextLine();
        int borrarId = Integer.parseInt(linea);
        
        detalleContacto=miAgenda.getContactoById(borrarId);
        
        System.out.println("");
        if (detalleContacto==null) {
            System.out.println("Contacto inexistente");
            System.out.println("");
        } else {
            System.out.println("ID: "+detalleContacto.getId());
            System.out.println("Nombre: "+detalleContacto.getNombre());
            System.out.println("Telefono: "+detalleContacto.getTelefono());
            System.out.println("Fecha de nacimiento: "+detalleContacto.getFechaNacimiento());
            System.out.println("Tipo: "+(detalleContacto.getTipo()=='A'?"Amigo":
                    detalleContacto.getTipo()=='E'?"Enemigo":
                    detalleContacto.getTipo()=='T'?"Trabajo":
                    detalleContacto.getTipo()=='F'?"Familia":"Tipo desconocido"));
            System.out.println("Coche en propiedad: "+detalleContacto.isTieneCoche());
            System.out.println("");
        }
        
    }

    private static void buscarPorTipo() {
        Scanner teclado=new Scanner(System.in);
        Contacto [] contactosPorTipo;
        String linea;
        char buscarTipo;
        
        System.out.print("Tipo del contacto/s que quieres buscar: ");
        linea=teclado.nextLine();
        buscarTipo=linea.charAt(0);
        
        contactosPorTipo=miAgenda.getContactosByTipo(buscarTipo);
        
        if (contactosPorTipo==null){
            System.out.println("No hay contactos con ese tipo ");
        } else {
            System.out.println("");
            for (int i = 0; i < contactosPorTipo.length; i++) {
                System.out.println("ID: "+contactosPorTipo[i].getId());
                System.out.println("Nombre: "+contactosPorTipo[i].getNombre());
                System.out.println("Telefono: "+contactosPorTipo[i].getTelefono());
                System.out.println("Fecha de nacimiento: "+contactosPorTipo[i].getFechaNacimiento());
                System.out.println("Tipo: "+(contactosPorTipo[i].getTipo()=='A'?"Amigo":
                        contactosPorTipo[i].getTipo()=='E'?"Enemigo":
                        contactosPorTipo[i].getTipo()=='T'?"Trabajo":
                        contactosPorTipo[i].getTipo()=='F'?"Familia":"Tipo desconocido"));
                System.out.println("Coche en propiedad: "+contactosPorTipo[i].isTieneCoche());
                System.out.println("");
            }
        }
        
    }

    private static void buscarPorTelefono() {
        Scanner teclado=new Scanner(System.in);
        Contacto [] contactosPorTelefono;
        String linea;
        long buscarTelefono;
        
        System.out.print("Tipo del contacto/s que quieres buscar: ");
        linea=teclado.nextLine();
        buscarTelefono=Long.parseLong(linea);
        
        contactosPorTelefono=miAgenda.getContactosByTelefono(buscarTelefono);
        
        if (contactosPorTelefono==null){
            System.out.println("No hay contactos con ese telefono ");
        } else {
            System.out.println("");
            for (int i = 0; i < contactosPorTelefono.length; i++) {
                System.out.println("ID: "+contactosPorTelefono[i].getId());
                System.out.println("Nombre: "+contactosPorTelefono[i].getNombre());
                System.out.println("Telefono: "+contactosPorTelefono[i].getTelefono());
                System.out.println("Fecha de nacimiento: "+contactosPorTelefono[i].getFechaNacimiento());
                System.out.println("Tipo: "+(contactosPorTelefono[i].getTipo()=='A'?"Amigo":
                        contactosPorTelefono[i].getTipo()=='E'?"Enemigo":
                        contactosPorTelefono[i].getTipo()=='T'?"Trabajo":
                        contactosPorTelefono[i].getTipo()=='F'?"Familia":"Tipo desconocido"));
                System.out.println("Coche en propiedad: "+contactosPorTelefono[i].isTieneCoche());
                System.out.println("");
            }
        }
    }
}
