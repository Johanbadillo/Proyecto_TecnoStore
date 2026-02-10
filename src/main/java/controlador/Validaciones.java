package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validaciones {

    public int validacion(int valorMinimo, int valorMaximo, String mensaje) {
        boolean validar = false;
        int op = 0;
        do {
            try {
                System.out.println(mensaje);
                op = new Scanner(System.in).nextInt();
                while (op < valorMinimo || op > valorMaximo) {
                    System.out.println("Opcion no valida, ingresa nuevamente");
                    op = new Scanner(System.in).nextInt();
                }
                validar = true;
            } catch (Exception e) {
                System.out.println("Error porfavor Ingrese solo numeros");
            }
        } while (validar == false);
        return op;
    }

    public static String validateCorreo(String correo) {
        while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            System.out.println("** correo no valido ***");
            System.out.println("Ingrese nuevamente el correo");
            correo = new Scanner(System.in).nextLine();
        }
        return correo;

    }

    public static Date validateFecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd MM yyyy");
        formato.setLenient(false); // <- Esta linea de codigo hace que no acepte fechas invalidas y absurdas
        Date fecha = null;
        while (fecha == null) {
            System.out.println("Ingresa la Fecha en Formato(DD MM YYYY)");
            String fechaTexto = new Scanner(System.in).nextLine().trim();
            try {
                fecha = formato.parse(fechaTexto);
            } catch (ParseException e) {
                System.out.println("Ingresa un Formato de Fecha Valido");
            }
        }
        return fecha;
    }
}
