package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        Connection connection = null;
        Statement sentencia = null;
        ResultSet datos;
        String codigoPais;
        String nombrePais;
        int poblacion;
        Vector<Pais> paises = new Vector(); 
        
        try {
            //Obtener una conexión a la BBDD (máquina, servidor, esquema, usuario, contraseña)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "1234abc.");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        try {
            //Crear una sentencia (statement)
            sentencia = connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);
            
            //Crear una consulta (query), ejecutarla y recuperar los datos (ResultSet)
            datos = sentencia.executeQuery("SELECT * FROM country");
            
            //Recorre el ResultSet recuperando las filas (registros) y a partir de ellas las columnas
            while(datos.next()){
                codigoPais = datos.getString("Code");//Buscamos columna por nombre
                nombrePais = datos.getString(2);//Buscamos columna por número de columna, empieza en la columna 1
                poblacion = datos.getInt("Population");
                
                paises.add(new Pais(codigoPais, nombrePais, poblacion));
                
                System.out.println(codigoPais + "\t" + nombrePais + "\t" + poblacion);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }  
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("");
        
        //Mostramos los paises
        for(Pais p : paises) {
            System.out.println(p);
        }
        
        
        try {
            //Probamos una inserción en la tabla de paises
            //sentencia.executeUpdate("INSERT INTO country (code, Name, Population) VALUES ('ZZZ', 'Zigzaz', 22)");
            
            //Probamos una sentencia de actualizacion
            //sentencia.executeUpdate("UPDATE country SET population = 6666 WHERE code = 'ZZZ'");
            
            //Probamos una sentencia de borrado
            //sentencia.executeUpdate("DELETE FROM country WHERE code = 'ZZZ'");
            
            //Probamos una PreparedStatement
            //PreparedStatement pst = connection.prepareStatement("INSERT INTO country (code, Name, Population) VALUES (?, ?, ?)");
            PreparedStatement pst = connection.prepareStatement("DELETE FROM country WHERE code = ?");
            
            pst.setString(1, "ZZZ");
//            pst.setString(2, "Zigzaz");
//            pst.setInt(3, 4444);
            pst.execute();
                    
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Cerramos la conexion con el origen de datos
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
