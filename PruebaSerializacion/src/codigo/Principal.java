package codigo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Principal {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        //Declaramos un OutputStream especializado sobre un array de byes
        ByteArrayOutputStream baos =  new ByteArrayOutputStream();
        
        //Construimos un ObjectOutputStream que escriba al ByteArrayOutputStream anterior
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        
        //Volcamos unos primitivos, unos objetos de clases de la API de Java y un Coche
        boolean bs = true;
        int is = 2000;
        String ss = "Hola mundo";
        Date ds = new Date(100, 8, 10);//(+1900, 0-11, 1-31) - 10 de Septiembre de 2000
        Coche cs = new Coche("C5555FG", "456456456D", 100000, new Date(110, 5, 5));
        
        oos.writeBoolean(bs);
        oos.writeInt(is);
        oos.writeObject(ss);
        oos.writeObject(ds);
        oos.writeObject(cs);
        
        //Recuperamos el array de bytes subyacente en el ByteArrayOutputStream
        byte[] resultadoDeLaSerializacion = baos.toByteArray();
        //Mostramos el array de bytes por pantalla 
        for(byte b : resultadoDeLaSerializacion) {
            System.out.print(b + " ");
        }
        
        //---------------------------------------------------------------------------------------
        
        //Construimos un ByteArrayInputStream que va a leer del array de bytes anterior
        ByteArrayInputStream bais = new ByteArrayInputStream(resultadoDeLaSerializacion);
        
        //Construimos un ObjectInputStream vinculado al flujo anterior "bais"
        ObjectInputStream ois = new ObjectInputStream(bais);
        
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
        
        System.out.println("El booleano: " + be);
        System.out.println("El entero: " + ie);
        System.out.println("El String: " + se);
        System.out.println("El Date: " + de);
        System.out.println("El Coche : " + ce);
        
    }
    
}
