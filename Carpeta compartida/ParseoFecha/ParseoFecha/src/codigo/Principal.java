package codigo;

public class Principal {

    public static void main(String[] args) {

        //Parseado de fecha usando el método substring();
        String strUnaFecha = "18/03/2020";

        int dia, mes, año;
        String strDia, strMes, strAño;

        strDia = strUnaFecha.substring(0, 2);
        strMes = strUnaFecha.substring(3, 5);
        strAño = strUnaFecha.substring(6);

        dia = Integer.parseInt(strDia);
        mes = Integer.parseInt(strMes);
        año = Integer.parseInt(strAño);

        Fecha unaFecha = new Fecha(dia, mes, año);
        System.out.println(unaFecha);
        System.out.println("---------------------------------------------------");
        
        
        //Parseado usando el método split()
        String[] trozos = strUnaFecha.split("/");
        dia = Integer.parseInt(trozos[0]);
        mes = Integer.parseInt(trozos[1]);
        año = Integer.parseInt(trozos[2]);

        Fecha otraFecha = new Fecha(dia, mes, año);
        System.out.println(otraFecha);
        
        
    }

}
