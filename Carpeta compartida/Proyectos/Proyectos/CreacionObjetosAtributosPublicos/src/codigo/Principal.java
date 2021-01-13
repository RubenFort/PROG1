package codigo;

public class Principal {

    public static void main(String[] args) {

        //Declaramos unas cuantas variables de la clase Coche
        Coche c0, c1, c2;

        //Mostramos los coches antes de construírlos
        //System.out.println(c0); La variable no apunta a ningún coche
        //Construímos obejtos (instanciamos) de la clase coche y guardamos sus referencias
        //en las variables anteriormente declaradas
        c0 = new Coche();
        c0.matricula = "C1234AB";
        c0.marcaModelo = "Seat-Ibiza";
        c0.añoCompra = 1990;
        c0.consumo = 15.4;
        c0.enPropiedad = true;

        c1 = new Coche();
        c1.matricula = "1234ABC";
        c1.marcaModelo = "Fiat-500";
        c1.añoCompra = 2019;
        c1.consumo = 5.5;
        c1.enPropiedad = false;

        c2 = new Coche();

        //Mostramos información de los coches
        System.out.println("------ Coche c0 -------");
        System.out.println("Matrícula: " + c0.matricula);
        System.out.println("Marca-Modelo: " + c0.marcaModelo);
        System.out.println("Año de Compra: " + c0.añoCompra);
        System.out.println("Consumo: " + c0.consumo);
        System.out.println("En propiedad: " + c0.enPropiedad);
        System.out.println("-------------------------------------");

        System.out.println("------ Coche c1 -------");
        System.out.println("Matrícula: " + c1.matricula);
        System.out.println("Marca-Modelo: " + c1.marcaModelo);
        System.out.println("Año de Compra: " + c1.añoCompra);
        System.out.println("Consumo: " + c1.consumo);
        System.out.println("En propiedad: " + c0.enPropiedad);
        System.out.println("-------------------------------------");

    }

}
