package usuarios;

import java.util.Objects;

public class Usuario {

    private String user;
    private String password;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Usuario(String userPassword) throws RegistroUsuarioMalFormadoException{
        String[] trozos = userPassword.split(" ");

        try {
            this.user = trozos[0];
            this.password = trozos[1];
        } catch (Exception e) {
            throw new RegistroUsuarioMalFormadoException();
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.user);
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
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + '}';
    }
    
    
    

}
