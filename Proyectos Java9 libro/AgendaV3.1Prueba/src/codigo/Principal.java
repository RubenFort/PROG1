package codigo;

import java.util.Scanner;

public class Principal {

    public static Agenda miAgenda;

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner (System.in);
        String seleccion;
        boolean salir = false;
        miAgenda = new Agenda();
        
        cargarDatos();
        
        do {            
            System.out.println("AGENDA DE CONTACTOS");
            System.out.println("");
            System.out.println("(A)ñadir contacto");
            System.out.println("(B)orrar contacto");
            System.out.println("(L)istar contactos");
            System.out.println("(D)etalle contacto");
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
                    salir = true;
                    break;
                
                default:
                    System.out.println("Selección incorrecta");
                
            }
        } while (salir!=true);

    }

    private static void cargarDatos() {
        
        if(miAgenda.addContacto(new Contacto("Pepe", "02/02/2020", 987654321, 'A', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        if(miAgenda.addContacto(new Contacto("Luis", "23/09/1985", 676256325, 'F', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        if(miAgenda.addContacto(new Contacto("Ana", "11/04/2001", 677123123, 'T', false))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
        if(miAgenda.addContacto(new Contacto("Maria", "16/11/1995", 981252634, 'A', true))){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
 
    }

    private static void nuevoContacto() {
        
        Contacto nuevoContacto = new Contacto();
        String linea;
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        linea = teclado.nextLine();
        nuevoContacto.setNombre(linea);
        
        System.out.print("Fecha de Nacimiento: ");
        linea = teclado.nextLine();
        nuevoContacto.setFechaNacimiento(linea);
        
        System.out.print("Telefono: ");
        linea =  teclado.nextLine();
        long nuevoTelefono = Long.parseLong(linea);
        nuevoContacto.setTelefono(nuevoTelefono);
        
        System.out.print("Tipo (A|E|T|F): ");
        linea = teclado.nextLine();
        char nuevoTipo = linea.charAt(0);
        nuevoContacto.setTipo(nuevoTipo);
        
        System.out.print("Tiene coche (true|false): ");
        linea = teclado.nextLine();
        boolean enPropiedad = Boolean.parseBoolean(linea);
        nuevoContacto.setTieneCoche(enPropiedad);
        
        if (miAgenda.addContacto(nuevoContacto)){
            System.out.println("Contacto guardado");
        } else {
            System.out.println("No se pudo guardar el contacto, agenda llena");    
        }
        
    }

    private static void listarContactos() {
        Contacto [] todos;
        
        todos=miAgenda.getAllContactos();
        
        System.out.println("");
        for (int i = 0; i < todos.length; i++) {
            System.out.println("ID: " + todos[i].getId()+"  Nombre: " + todos[i].getNombre());
        }
        System.out.println("");
    }

    private static void detalleContacto() {
        Contacto imprimeContacto;
        Scanner teclado = new Scanner(System.in);
        String linea;
        
        System.out.print("Que contacto quieres imprimir: ");
        linea=teclado.nextLine();
        int idBuscado=Integer.parseInt(linea);
        
        imprimeContacto=miAgenda.getContactoById(idBuscado);
        
        System.out.println("");
        if(imprimeContacto==null){
            System.out.println("El contacto solicitado no está en la agenda");
        } else {
            System.out.println("ID: " + imprimeContacto.getId());
            System.out.println("Nombre: " + imprimeContacto.getNombre());
            System.out.println("Fecha de nacimiento: " + imprimeContacto.getFechaNacimiento());
            System.out.println("Telefono: " + imprimeContacto.getTelefono());
            System.out.println("Tipo: " + (imprimeContacto.getTipo()=='A'?"Amigo":
                    imprimeContacto.getTipo()=='E'?"Enemigo":
                    imprimeContacto.getTipo()=='T'?"Trabajo":
                    imprimeContacto.getTipo()=='F'?"Familia":"Tipo desconocido"));
            System.out.println("Tiene Coche: " + imprimeContacto.isTieneCoche());
        }
    }

    private static void borrarContacto() {
        Contacto imprimeContacto;
        Scanner teclado = new Scanner(System.in);
        String linea;
        boolean operacionOk;
        
        System.out.print("Que contacto quieres borrar: ");
        linea=teclado.nextLine();
        int idBuscado=Integer.parseInt(linea);
        
        operacionOk=miAgenda.deleteContactoById(idBuscado);
        
        if(operacionOk==true){
                System.out.println("Contacto borrado");
        } else {
            System.out.println("No se pudo borrar el contacto");    
        }
    }
    
}
