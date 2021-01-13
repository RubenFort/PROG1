
package utilidades;

public class Fecha {

    //ATRIBUTOS
    private int dia;
    private int mes;
    private int año;

    //CONSTRUCTORES
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public Fecha(String f) {
       String[] strFecha = f.split("/");
       dia = Integer.parseInt(strFecha[0]);
       mes = Integer.parseInt(strFecha[1]);
       año = Integer.parseInt(strFecha[2]);
    }
    
    //GETTERS Y SETTERS
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return (dia + "/" +mes+ "/" +año);
        //return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", a\u00f1o=" + año + '}';
    }

}
