
package codigo;


public class Principal {

    public static void main(String[] args) {
        
        //Creamos una fecha a dia de hoy y la mostramos
        System.out.println("Creamos una fecha a dia de hoy y la mostramos");
        Fecha ahora = new Fecha(13, 3, 2020);
        System.out.println("Ahora es: "+ahora);
        //System.out.println("Ahora es: "+ahora.getDia() +"/"+ahora.getMes()+"/"+ahora.getAño());
        System.out.println("");
        
        //Le modificamos el dia y lo mostramos
        System.out.println("Le modificamos el dia y lo mostramos");
        ahora.setDia(18);
        System.out.println("Ahora es: "+ahora);
        //System.out.println("Ahora es: "+ahora.getDia() +"/"+ahora.getMes()+"/"+ahora.getAño());
        System.out.println("");
    }
    
}
