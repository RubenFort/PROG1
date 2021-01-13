package codigo;

public class Vivienda implements Comparable<Vivienda>{
    
    private int añoCompra;
    private double superficie;
    private String nifPropietario;

    public Vivienda(int anoCompra, double superficie, String nifPropietario) {
        this.añoCompra = anoCompra;
        this.superficie = superficie;
        this.nifPropietario = nifPropietario;
    }

    public String getNifPropietario() {
        return nifPropietario;
    }

    public void setNifPropietario(String nifPropietario) {
        this.nifPropietario = nifPropietario;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getAñoCompra() {
        return añoCompra;
    }

    public void setAñoCompra(int añoCompra) {
        this.añoCompra = añoCompra;
    }
    
    //compareTo basado en año compra sin devolver distancia(int)
    /*    @Override
    public int compareTo(Vivienda o) {
    if (this.añoCompra > o.añoCompra){
    return 1;
    } else if (this.añoCompra == o.añoCompra) {
    return 0;
    } else {
    return -1;
    }
    }*/

    //compareTo basado en año compra devolviendo distancia(int)
    /*    @Override
    public int compareTo(Vivienda o) {
    return this.añoCompra - o.añoCompra;
    }*/
    
    //compareTo basado en superficie compra devolviendo distancia(int)
    /*    @Override
    public int compareTo(Vivienda o) {
    return (int)Math.round(this.superficie - o.superficie);
    }*/
    
    //compareTo basado en superficie compra sin devolver la distancia(int)
    /*    @Override
    public int compareTo(Vivienda o) {
    if (this.superficie > o.superficie){
    return 1;
    } else if (this.superficie < o.superficie) {
    return -1;
    } else {
    return 0;
    }
    }*/
    
    //compareTo basado en superficie compra sin devolver la distancia(int) realizado con Math.signum
    @Override
    public int compareTo(Vivienda o) {
        return (int)Math.signum(this.superficie - o.superficie);
    }
    
    //Equals basado en año compra devolviendo boleano
    /*    @Override
    public int hashCode() {
    int hash = 5;
    hash = 13 * hash + this.añoCompra;
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
    final Vivienda other = (Vivienda) obj;
    if (this.añoCompra != other.añoCompra) {
    return false;
    }
    return true;
    }*/

    @Override
    public String toString() {
        return "Vivienda{" + "a\u00f1oCompra=" + añoCompra + ", superficie=" + superficie + ", nifPropietario=" + nifPropietario + '}';
    }
    
    //Equals basado en superficie devolviendo boleano
    /*    @Override
    public int hashCode() {
    int hash = 3;
    hash = 67 * hash + (int) (Double.doubleToLongBits(this.superficie) ^ (Double.doubleToLongBits(this.superficie) >>> 32));
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
    final Vivienda other = (Vivienda) obj;
    if (Double.doubleToLongBits(this.superficie) != Double.doubleToLongBits(other.superficie)) {
    return false;
    }
    return true;
    }*/
}
