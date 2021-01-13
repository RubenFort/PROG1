package codigo;

import java.util.List;

public interface DAO {  //CRUD Create(insert) Read Update Delete 
    
    public boolean insert(Contacto c);
    
    public boolean delete(Contacto c);
    
    public boolean update(Contacto c);
    
    public List<Contacto> getAllContactos();
    
    public List<Contacto> getByTipo();
    
    public Contacto getById(Contacto c);
    public Contacto getById(int id);
    
} 