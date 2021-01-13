
package pruebasint;


public class PruebasInt {
    
    //Variables con el mismo valor, pero distinto formato
    public static void main(String[] args) {
        
        int numDecimal = 203;
        int binario = 0b11001011;
        int hexadecimal = 0xCB;
        int octal = 0313;
        int separadores = 20_3;
        
        
    //Mostramos variables con el mismo valor, pero habiendo usado distintos sistemas numéricos para darles el valor
        System.out.println("decimal :"+ numDecimal+"\nbinario: "+binario+"\nhexadecimal: "+hexadecimal+
                "\noctal: "+octal+"\nseparadores: "+separadores+"\ndouble: "+203d+"\nfloat: "+203f+"\nlong: "+203l);
    }
    
}
