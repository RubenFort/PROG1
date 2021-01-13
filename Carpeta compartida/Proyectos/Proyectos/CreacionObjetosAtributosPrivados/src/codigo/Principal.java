package codigo;

public class Principal {

    public static void main(String[] args) {

        //Declaramos unas cuantas variables de la clase Coche
        Coche c0, c1, c2;

        //Mostramos los coches antes de construírlos
        //System.out.println(c0); La variable no apunta a ningún coche
        //Construímos obejtos (instanciamos) de la clase coche y guardamos sus referencias
        //en las variables anteriormente declaradas
        c0 = new Coche("C1234AB","Seat-Ibiza",1990,15.4,true);

        c1 = new Coche();
        c1.setMatricula("1234ABC");
        c1.setMarcaModelo("Fiat-500");
        c1.setAñoCompra(2019);
        c1.setConsumo(5.5);
        c1.setEnPropiedad(false);

        c2 = new Coche();

        //Mostramos información de los coches
        System.out.println("------ Coche c0 -------");
        System.out.println("Matrícula: " + c0.getMatricula());
        System.out.println("Marca-Modelo: " + c0.getMarcaModelo());
        System.out.println("Año de Compra: " + c0.getAñoCompra());
        System.out.println("Consumo: " + c0.getConsumo());
        System.out.println("En propiedad: " + c0.isEnPropiedad());
        System.out.println("-------------------------------------");

        System.out.println("------ Coche c1 -------");
        System.out.println("Matrícula: " + c1.getMatricula());
        System.out.println("Marca-Modelo: " + c1.getMarcaModelo());
        System.out.println("Año de Compra: " + c1.getAñoCompra());
        System.out.println("Consumo: " + c1.getConsumo());
        System.out.println("En propiedad: " + c1.isEnPropiedad());
        System.out.println("-------------------------------------");

    }

}
