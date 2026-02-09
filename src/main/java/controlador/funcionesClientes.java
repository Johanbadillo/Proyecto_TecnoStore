package controlador;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Clientes;
import modelo.persona;
import vista.MenuClientes;

public class funcionesClientes {

    GestionClientes gc = new GestionClientesImpl();
    MenuClientes mc = new MenuClientes();

    public void ftRegistro() {
        persona p = new persona();
        System.out.println("Ingresa el nombre de la Persona");
        p.setNombre(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el numero de identificacion de la Persona");
        p.setIdentificacion(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el correo de la Persona");
        p.setCorreo(new Scanner(System.in).nextLine());
        System.out.println("Ingresa los telefonos de la Persona");
        p.setTelefono(new Scanner(System.in).nextLine());
        gc.agregar_Clientes(p);
        mc.menu();
    }

    public void ftActualizacion() {
        Validaciones v = new Validaciones();
        System.out.println("Ingresa el id del cliente que quieres Actualizar");
        
        int id = new Scanner(System.in).nextInt();
        Clientes cl = gc.buscar(id);
        if (cl != null) {
            System.out.println(cl);
            int op = v.validacion(1, 4, """
                    *********************************
                    Que es lo que deseas Actualizar. 
                                                              
                    1.   Nombre de cliente.
                    2.   Numero de Identificacion.
                    3.   Correo registrado del cliente.
                    4.   Telefonos del Cliente.
                    *********************************
                               """);
            switch (op) {
                case 1:
                    System.out.println("Ingresa el nuevo Nombre del Cliente");
                    cl.setNombre(new Scanner(System.in).nextLine());
                    break;
                case 2:
                    System.out.println("Ingresa el nuevo Numero de identificacion del Cliente");
                    cl.setIdentificacion(new Scanner(System.in).nextLine());
                    break;
                case 3:
                    System.out.println("Ingresa el nuevo correo del Cliente");
                    cl.setCorreo(new Scanner(System.in).nextLine());
                    break;
                case 4:
                    System.out.println("Ingresa el nuevo Telefono del Cliente");
                    cl.setTelefono(new Scanner(System.in).nextLine());
                    break;
            }
            gc.actualizar_Clientes(cl, id);
        } else {
            System.out.println("No se ha encontrado el cliente");
        }
        mc.menu();
    }

    public void ftEliminacion() {
        System.out.println("Ingresa el id del cliente que deseas eliminar");
        int id = new Scanner(System.in).nextInt();
        Clientes cl = gc.buscar(id);
        if (cl != null) {
            System.out.println(cl);
            gc.eliminar_Clientes(id);
        }else{
            System.out.println("No se encontro el cliente");
        }
        
        mc.menu();
    }

    public void ftListar() {
        ArrayList<Clientes> clientes = gc.visualizar_Clientes();
        for (Clientes cl : clientes) {
            System.out.println(cl);
        }
        mc.menu();
    }

    public void ftBuscar() {
        System.out.println("Ingresa el id del cliente que deseas visualizar");
        String busqueda = new Scanner(System.in).nextLine();
        try {
            int id = Integer.parseInt(busqueda.trim());
            Clientes cl = gc.buscar(id);
            if (cl != null) {
                System.out.println(cl);
            } else {
                System.out.println("No se ha encontrado el cliente al que deseas visualizar!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error porfavor Ingrese solo numeros");
        }
        mc.menu();
    }
}
