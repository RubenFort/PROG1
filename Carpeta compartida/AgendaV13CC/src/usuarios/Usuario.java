package usuarios;

import java.util.Objects;

public class Usuario {

    //Atributos
    private String users;
    private String password;
    
    //Constructores
    public Usuario(String userPassword) throws RegistroUsuarioMalFormadoException {
        String[] trozos = userPassword.split(" ");
        
        try {
            this.users = trozos[0];
            this.password = trozos[1];
        } catch (Exception e) {
            //Excepción creada po nosotros. Es una especializacion de IllegalArgumentException
            throw new RegistroUsuarioMalFormadoException();
        }
    }
    
    public Usuario(String users, String password) {
        this.users = users;
        this.password = password;
    }
    
    //Getters & setters
    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    } 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.users);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        return true;
    }

}
