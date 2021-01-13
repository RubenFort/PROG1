package codigo;

public class Principal {

    public static void main(String[] args) {

        //Declaramos unas cuantas variables de la clase Coche
        Coche c0, c1, c2;
        
        /*mostramos los coches antes de construirlos
        System.out.println("Coche1: " + c0);
        System.out.println("Coche2: " + c1);
        System.out.println("Coche3: " + c2);
        LA VARIABLE NO APUNTA A NINGUN COCHE,NO SE PUEDE MOSTRAR!!!
        */
        
        //Construímos obejtos (instanciamos) de la clase coche y guardamos sus referencias
        //en las variables anteriormente declaradas
        c0 = new Coche();//esto deja de funcionar cuando los atributos son private(solo se pueden leer dentro de la clase)
            c0.matricula="C1234AB";
            c0.marcaModelo="Seat-Ibiza";
            c0.añoCompra=1990;
            c0.consumo=15.4;
            c0.enPropiedad= true;
        
        c1 = new Coche();
        c2 = new Coche();
        
        //mostramos info de los coches
        System.out.println("==========Coche c0==========");
        System.out.println("Matricula: " + c0.matricula);
        System.out.println("Marca y modelo: " + c0.marcaModelo);
        System.out.println("Año de compra: " + c0.añoCompra);
        System.out.println("Consumo: " + c0.consumo);
        System.out.println("Propiedad: " + c0.enPropiedad);
        
    }

}
