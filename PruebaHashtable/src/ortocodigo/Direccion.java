package ortocodigo;

class Direccion {
    
    private String cp;
    private String calle;
    private int numero;
    private int planta;
    private char letra;

    public Direccion(String cp, String calle, int numero, int planta, char letra) {
        this.cp = cp;
        this.calle = calle;
        this.numero = numero;
        this.planta = planta;
        this.letra = letra;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "Direccion{" + "cp=" + cp + ", calle=" + calle + ", numero=" + numero + ", planta=" + planta + ", letra=" + letra + '}';
    }
    
}
