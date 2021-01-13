package codigo;

import java.util.Scanner;

public class Principal {

    private static Garage miGarage;

    public static void main(String[] args) {
        
        miGarage = new Garage(10);
        boolean salir=false;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        cargarDatos();
        
        do{
            System.out.println("(L)istar coches");
            System.out.println("(M)ostrar detalle");
            System.out.println("(S)alir");
            System.out.println("");
            System.out.print("Selecciona una apción: ");
            cadena=teclado.nextLine();
            
            switch (cadena){
                case "L": case"l":
                    mostrarListaCoches();
                    break;
                case "M": case"m":
                    showDetalle();
                    break;
                case"S": case"s":
                    salir=true;
                    break;

            }
            
        }while(salir=true);
        
    }

    private static void cargarDatos() {

        boolean añadir;
        
        Coche c0, c1, c2;

        c0 = new Coche("1234AFG", "Seat Leon", 1999, 5.5, true);

        c1 = new Coche("5885AFF", "Seat Ibiza", 1985, 6.1, true);
        c2 = new Coche("2323Dpo", "Mini", 2012, 7.8, false);
        añadir = miGarage.añadirCoche(c0);

        if (añadir == false) {
            System.out.println("Garage llena");
        } else {
            System.out.println("Coche en garage");
        }
        añadir = miGarage.añadirCoche(c1);

        if (añadir == false) {
            System.out.println("Garage llena");
        } else {
            System.out.println("Coche en garage");
        }
        añadir = miGarage.añadirCoche(c2);

        if (añadir == false) {
            System.out.println("Garage llena");
        } else {
            System.out.println("Coche en garage");
        }
    }

    private static void mostrarListaCoches(){
        int ocupacion=miGarage.getOcupacion();
                
        System.out.println("Ocupacion: "+ocupacion);
        
        Coche[] todosLosCoches=new Coche[ocupacion]; 
        todosLosCoches=miGarage.getListaCoches();
        System.out.println("***********Mostrar lista************");
        for (int i = 0; i < ocupacion; i++) {
            System.out.println("Matricula: "+todosLosCoches[i].getMatricula());
            System.out.println("Marca y Modelo: "+todosLosCoches[i].getMarcaModelo());
            System.out.println("");
        }
    }
    
    private static void showDetalle() {
        
        Coche cocheDetalle=new Coche();
        
        cocheDetalle=miGarage.mostrarDetalle("5885AFF");
        System.out.println("**************Mostrar Detalle*************");
        System.out.println("Matricula: "+cocheDetalle.getMatricula());
        System.out.println("Marca y modelo: "+cocheDetalle.getMarcaModelo());
        System.out.println("Año de compra: "+cocheDetalle.getAnoCompra());
        System.out.println("Consuno: "+cocheDetalle.getConsumo());
        System.out.println("Propieda: "+cocheDetalle.getEnRpopiedad());
        
    }
    
   
    
}
    

