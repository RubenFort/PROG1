
package codigo;


public class Principal {
    
    public static void main(String[] args) {
        
        //**********METODOS DE LA CLASE String**********
        
        //int compareTo(String anotherString)
        
        String prueba="cadena";
        
        int cadenasIguales = prueba.compareTo("cadena");
        if (cadenasIguales==0){
            System.out.println("Las cadenas son iguales");
        } else  {
            System.out.println("Las cadenas son distintas");
        }
        
        //int compareToIgnoreCase(String str)
        
        cadenasIguales = prueba.compareToIgnoreCase("CADena");
        if (cadenasIguales==0){
            System.out.println("Las cadenas son iguales (se ignoran mayuscula y minusculas)");
        } else  {
            System.out.println("Las cadenas son distintas (aun ignorando mayusculas y minusculas)");
        }
        
        //String concat(String str)
        
        String cadenasConcatenadas = prueba.concat("Otra Cadena");
        System.out.println("Concatenando las dos cadenas el resultado es: "+cadenasConcatenadas);
        
        //boolean startsWith(String prefix)
        
        boolean empiezaPorHola = "HolaMundo".startsWith("Hola");
        System.out.println("HolaMundo empieza por 'Hola': "+empiezaPorHola);
        
        empiezaPorHola = "AdiosMundo".startsWith("Hola");
        System.out.println("HolaMundo empieza por 'Adios': "+empiezaPorHola);
        
        //boolean endsWith(String prefix)
        
        boolean acabaPorMundo = "HolaMundo".endsWith("Mundo");
        System.out.println("HolaMundo acaba por 'Mundo': "+acabaPorMundo);
        acabaPorMundo = "HolaMundo".endsWith("world");
        System.out.println("HolaMundo acaba por 'World': "+acabaPorMundo);
        
        //int indexOf(String str)
        
        int inicioCadenaBuscada  = "Aqui es donde buscamos".indexOf("donde");
        System.out.println("La palabra buscada 'donde' empieza en el indice: "+inicioCadenaBuscada);
        
        //String substring(int beginIndex)
        
        String extraccion = "abcdefghi".substring(3);
        System.out.println("La cadena a partir del indice 3 queda así: "+extraccion);
        String otraExtraccion = "abcdefgh".substring(3, 6);
        System.out.println("La cadena entre el indice 3 y el 6 (no incluido) queda así: "+otraExtraccion);
        
    }
    
}
