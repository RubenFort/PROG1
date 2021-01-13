/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

public class Pais {
    
    private String codigo;
    private String nombre;
    private int poblacion;

    public Pais(String codigo, String nombre, int poblacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Pais{" + "codigo=" + codigo + ", nombre=" + nombre + ", poblacion=" + poblacion + '}';
    }
    
}
