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
            c0.setMatricula("C1234AB");
            c0.setMarcaModelo("Seat-Ibiza");
            c0.setAñoCompra(1990);
            c0.setConsumo(15.4);
            c0.setEnPropiedad(true);
        
        c1 = new Coche();
            c1.setMatricula("B1523CB");
            c1.setMarcaModelo("Seat-Arona");
            c1.setAñoCompra(2018);
            c1.setConsumo(6.5);
            c1.setEnPropiedad(false);   
            
        c2 = new Coche();
            c2.setMatricula("12234BDC");
            c2.setMarcaModelo("Toyota-Auris");
            c2.setAñoCompra(2019);
            c2.setConsumo(4.0);
            c2.setEnPropiedad(true);
        
        //mostramos info de los coches
        System.out.println("==========Coche c0==========");
        System.out.println("Matricula: " + c0.getMatricula());
        System.out.println("Marca y modelo: " + c0.getMarcaModelo());
        System.out.println("Año de compra: " + c0.getAñoCompra());
        System.out.println("Consumo: " + c0.getConsumo());
        System.out.println("Propiedad: " + c0.isEnPropiedad());
        
        System.out.println("==========Coche c1==========");
        System.out.println("Matricula: " + c1.getMatricula());
        System.out.println("Marca y modelo: " + c1.getMarcaModelo());
        System.out.println("Año de compra: " + c1.getAñoCompra());
        System.out.println("Consumo: " + c1.getConsumo());
        System.out.println("Propiedad: " + c1.isEnPropiedad());
        
        System.out.println("==========Coche c2==========");
        System.out.println("Matricula: " + c2.getMatricula());
        System.out.println("Marca y modelo: " + c2.getMarcaModelo());
        System.out.println("Año de compra: " + c2.getAñoCompra());
        System.out.println("Consumo: " + c2.getConsumo());
        System.out.println("Propiedad: " + c2.isEnPropiedad());
    }

}
