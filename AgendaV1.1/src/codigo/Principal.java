package codigo;

import java.util.Scanner;

public class Principal {

    public static final int MAX_CONTACTOS = 10;
    public static int ocupacion = 0;
    public static int siguienteID = 0;

    public static int[] ids;
    public static String[] nombres;
    public static String[] fechas;
    public static long[] telefonos;
    public static char[] tipos;

    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        boolean salir = false;
        
        cargarDatos();
        
        do{
            System.out.println("AGENDA  CONTACTOS");
            System.out.println("(A)lta");
            System.out.println("(B)aja");
            System.out.println("(L)istar");
            System.out.println("(D)etalle");
            System.out.println("(E)ditar");
            System.out.println("(S)alir");
            System.out.println("(O)cupacion");
            System.out.print("Selecciona una opción: ");
            String seleccionMenu=teclado.nextLine();
            
            switch (seleccionMenu) {
                case "A": case "a":
                    nuevoContacto();
                break;    
                case "B": case "b":
                    borrarContacto();
                break;    
                case "L": case "l":
                    listarContactos();
                break;    
                case "D": case "d":
                    detalleContacto();
                break; 
                case "E": case "e":
                    editarContacto();
                break;   
                case "S": case "s":
                    salir=true;
                break;    
                case "O": case "o":
                    System.out.println("ocupacón: "+ocupacion);
                    System.out.println("siguienteId: "+siguienteID);
                break;    
                default:
                    System.out.println("Opción seleccionada incorrecta");
                break;    
            }
        }while(salir!=true);
    }

    private static void cargarDatos() {
        
        ids = new int[MAX_CONTACTOS];
        nombres = new String[MAX_CONTACTOS];
        fechas = new String[MAX_CONTACTOS];
        telefonos = new long[MAX_CONTACTOS]; 
        tipos = new char[MAX_CONTACTOS];
        
        ids [ocupacion] = siguienteID;
        nombres [ocupacion] = "Ana Lopez";
        fechas [ocupacion] = "12/02/1999";
        telefonos [ocupacion] = 677256325;
        tipos [ocupacion] = 'f';
        ocupacion++;
        siguienteID++;
        
        ids [ocupacion] = siguienteID;
        nombres [ocupacion] = "Luis Vila";
        fechas [ocupacion] = "23/06/2001";
        telefonos [ocupacion] = 676123456;
        tipos [ocupacion] = 'a';
        ocupacion++;
        siguienteID++;
        
        ids [ocupacion] = siguienteID;
        nombres [ocupacion] = "Pablo Vecino";
        fechas [ocupacion] = "22/07/1985";
        telefonos [ocupacion] = 981447744;
        tipos [ocupacion] = 'e';
        ocupacion++;
        siguienteID++;
    }

    private static void nuevoContacto() {
        Scanner teclado=new Scanner(System.in);
        
        ids[ocupacion]=siguienteID;
        System.out.print("Nombre: ");
        nombres[ocupacion]=teclado.nextLine();
        System.out.print("Fecha nacimiento: ");
        fechas[ocupacion]=teclado.nextLine();
        System.out.print("Teléfono: ");
        String strTelefono=teclado.nextLine();
        telefonos[ocupacion]=Long.parseLong(strTelefono);
        System.out.print("Tipo: ");
        String strTipo=teclado.nextLine();
        tipos[ocupacion]=strTipo.charAt(0);
        
        ocupacion++;
        siguienteID++;
    }

    private static void borrarContacto() {
        Scanner teclado=new Scanner(System.in);
        
        System.out.print("Que contacto quieres borrar (ID): ");
        String strEntero=teclado.nextLine();
        int contactoABorrar = Integer.parseInt(strEntero);
        
        for (int i = 0; i < ocupacion; i++) {
            if (contactoABorrar==ids[i]) {
                for (int j = i; j < ocupacion; j++) {
                    ids [j] = ids [j+1];
                    nombres [j] = nombres [j+1];
                    fechas [j] = fechas [j+1];
                    telefonos [j] = telefonos [j+1];
                    tipos [j] = tipos [j+1];
                }
                ocupacion--;
                return;
            }   
        }
    }

    private static void listarContactos() {
        for (int i = 0; i < ocupacion; i++) {
            System.out.println("ID: "+ids[i]);
            System.out.println("Nombre: "+nombres[i]);
            System.out.println(" ");
        }
    }

    private static void detalleContacto() {
        
        Scanner teclado=new Scanner(System.in);
        
        System.out.print("De que ID quieres ver el detalle?: ");
        String strEntero=teclado.nextLine();
        int detalleID=Integer.parseInt(strEntero);
        
        for (int i = 0; i < ocupacion; i++) {
            if (detalleID==ids[i]){
                System.out.println("ID: "+ids[i]);
                System.out.println("Nombre: "+nombres[i]);
                System.out.println("Fecha Nacimiento: "+fechas[i]);
                System.out.println("Telefono: "+telefonos[i]);
                System.out.println("Tipo: "+(tipos[i]=='a'?"amigo":tipos[i]=='e'?"enemigo":tipos[i]=='f'?"familiar":"trabajo"));/*mayor=(x>y)?x:y; if ternario*/
                return;
            }
        }
    }

    private static void editarContacto() {
        Scanner teclado=new Scanner(System.in);
        
        System.out.print("Que contacto(ID) quieres editar: ");
        String strEntero=teclado.nextLine();
        int editarId=Integer.parseInt(strEntero);
        
        for (int i = 0; i < ocupacion; i++) {
            if (editarId==ids[i]) {
                System.out.println("(N)ombre");
                System.out.println("(F)echa de nacimiento");
                System.out.println("(T)elefono");
                System.out.println("Ti(p)o");
                System.out.print("Que campo quieres editar?: ");
                String editaCampo=teclado.nextLine();
                
                switch(editaCampo) {
                    case "N": case "n":
                        System.out.print("Nombre: ");
                        nombres[i]=teclado.nextLine();
                        return;
                    case "F": case "f":
                        System.out.print("Fecha de nacimiento: ");
                        fechas[i]=teclado.nextLine();
                        return;
                    case "T": case "t":
                        System.out.print("Telefono: ");
                        String strLong=teclado.nextLine();
                        telefonos[i]=Long.parseLong(strLong);
                        return;
                    case "P": case "p":
                        System.out.print("Tipo: ");
                        String strTipo=teclado.nextLine();
                        tipos[i]=strTipo.charAt(0);
                        return;
                    default:
                        System.out.println("Campo incorrecto");
                    return;
                }
            }
        }
        System.out.println("ID incorrecto");
        return;
    }
}
