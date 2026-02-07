package vista;

import controlador.GestionClientes;
import controlador.GestionClientesImpl;
import controlador.Validaciones;
import java.util.Scanner;
import modelo.persona;

public class MenuClientes {
    
    GestionClientes gc=new GestionClientesImpl(); 
    
    private void registro(){
        persona p=new persona();
        System.out.println("Ingresa el nombre de la Persona");
        p.setNombre(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el numero de identificacion de la Persona");
        p.setIdentificacion(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el correo de la Persona");
        p.setCorreo(new Scanner(System.in).nextLine());
        System.out.println("Ingresa los telefonos de la Persona");
        p.setTelefono(new Scanner(System.in).nextLine());
        gc.agregar_Clientes(p);
        menu();
    }
    
    
    
    
    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 6, """
                               --------------------------------------------
                               Bienevido al Menu Clientes.
                               Aqui podras hacer la gestion de tus clientes
                               --------------------------------------------
                               1.   Registrar Cliente nuevo.
                               2.   Actualizar Informacion de Cliente.
                               3.   Eliminacion de Cliente.
                               4.   Visualizacion de Clientes.
                               5.   Busqueda Individual de Cliente.
                               6.   Regresar al Menu anterior....
                               --------------------------------------------
                               """);
        switch (op) {
            case 1:
                registro();
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                System.out.println("Regresando al menu anterior...");
                Menu m = new Menu();
                m.Menu_principal();
                break;
        }
    }
}
