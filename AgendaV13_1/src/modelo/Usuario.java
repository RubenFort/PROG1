package modelo;

import java.util.Objects;

public class Usuario {
    
    //Atributos
    private String usuario;
    private String contrasena;
    
    //Constructores
    public Usuario(){
    
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contrasena = contraseña;
    }

    public Usuario(String clave) {
        String[] campos = clave.split("#");
        
        this.usuario = campos[0];
        this.contrasena = campos[1];   
    }
    
    //Metodos
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    //Reescribimos el método equals 
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
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }

}
