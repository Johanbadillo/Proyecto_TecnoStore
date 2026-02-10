package controlador;

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
    
    public static String validateCorreo(String correo){
        while(!correo.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")){
            System.out.println("** correo no valido ***");
            System.out.println("Ingrese nuevamente el correo");
            correo = new Scanner(System.in).nextLine();
        }
        return correo;
        
    }
}
