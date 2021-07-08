package pruebacuriosidades;

import java.util.LinkedList;

public class PruebaCuriosidades {

    static int count = 0;
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(10);
        System.out.println(list);
        
        //********************************
        
        if(count < 3){
            count++;
            main(null);
        } else {
            return;
        }
        System.out.println("Hello World");
        
        //***********************************
        
        try{
            System.out.println("A");
            badMethod();
            System.out.println("B");
        } catch (Exception ex) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
        
        //***********************************
        
        try{
            System.out.println("1");
            badMethod();
            System.out.println("2");
        } catch (Exception ex) {
            System.out.println("3");
        } catch (NullPointerException e) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
    }

    private static void badMethod() {
        throw new Error();
    }
}
