package codigo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    private static DAO datos;
    
    public static void main(String[] args) {
        
        try {
            //Ejemplo con JDBCAO
            datos = new JDBCDAO();
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BBDD");
        }
        
    }
    
}
