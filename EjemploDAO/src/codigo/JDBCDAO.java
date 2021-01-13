
package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCDAO implements DAO{
    
    private final String cadenaConexion = "jdbc:mysql://nombreMaquina:3306/nombreBBDD";
    private Connection conexion;

    public JDBCDAO() throws SQLException {
        //Establecer la conexion con la BD
        conexion = DriverManager.getConnection(cadenaConexion, "user", "paswword");
    }
    
    
    @Override
    public boolean insert(Contacto c) {
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate("");
                
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contacto> getAllContactos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contacto> getByTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contacto getById(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contacto getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
