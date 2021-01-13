package codigo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Principal {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        //Construímos un ObjectOutputStream que escriba al FileOutputStream que lee del fichero "datos.dat
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.dat"));
        
        //Volcamos unos primitivos, unos objetos de clases de la API de Java y un Coche
        boolean bs = true;
        int is = 2000;
        String ss = "Hola Mundo";
        Date ds = new Date(100, 8, 10); // 10 de Septiempre de 2000
        Coche cs = new Coche("C5555FG", new Date(110, 5, 5),"44567890J",100000);
     
        oos.writeBoolean(bs);
        oos.writeInt(is);
        oos.writeObject(ss);
        oos.writeObject(ds);
        oos.writeObject(cs);
        
        oos.close();
        
        //------------------------------------------------------------------------------------------
        
        
        //Construímos un ObjectInputStream vinculado al FileInputStream conectado al fichero
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datos.dat"));
        
        boolean be;
        int ie;
        String se;
        Date de;
        Coche ce;
        
        be = ois.readBoolean();
        ie = ois.readInt();
        se = (String)ois.readObject();
        de = (Date)ois.readObject();
        ce = (Coche)ois.readObject();
        
        ois.close();
        
        System.out.println("El booleano: " + be);
        System.out.println("El entero: " + ie);
        System.out.println("El String: " + se);
        System.out.println("El Date: " + de);
        System.out.println("El Coche: " + ce);
        
        
    }

}
