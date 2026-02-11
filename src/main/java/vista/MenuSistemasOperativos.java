package vista;

import controlador.GestionSistemaOperativos;
import controlador.GestionSistemaOperativosImpl;
import controlador.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.sistema_operativo;

public class MenuSistemasOperativos {

    GestionSistemaOperativos gsio = new GestionSistemaOperativosImpl();
    
    public sistema_operativo auxValidacion() {
        sistema_operativo sio = null;
        while (sio == null) {
            System.out.println("Ingrese El id del Sistema Operativo");
            String busqueda = new Scanner(System.in).nextLine();
            try {
                int id = Integer.parseInt(busqueda.trim());
                sio = gsio.buscar(id);
                if (sio != null) {
                    System.out.println(sio);
                    return sio;
                } else {
                    System.out.println("No se Encontro Ningun Sistema Operativo Con ese ID!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error porfa ingrese solo numeros");
            }
        }
        return null;
    }

    private void registrar() {
        sistema_operativo sio = new sistema_operativo();
        System.out.println("Ingrese el nombre de nuevo Sistema Operativo");
        sio.setNombre(new Scanner(System.in).nextLine());
        gsio.agregar_SistemaOperativo(sio);
        menu();
    }

    private void actualizar() {
        sistema_operativo sio =auxValidacion();
        if (sio != null) {
            System.out.println("Ingresa el nuevo Nombre del Sistema Operativo");
            sio.setNombre(new Scanner(System.in).nextLine());
            gsio.actualizar_SistemaOperativo(sio, sio.getId());
        }
        menu();
    }

    private void eliminar() {
        sistema_operativo sio =auxValidacion();
        if (sio != null) {
            gsio.eliminar_SistemaOperativo(sio.getId());
        }
        menu();
    }

    private void listar() {
        ArrayList<sistema_operativo> sistema_operativos = gsio.visualizar_SistemaOperativo();
        for (sistema_operativo sio : sistema_operativos) {
            System.out.println(sio);
        }
        menu();
    }

    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 5, """
                               ---------------------------------------------------------
                               Menu de Sistemas Operativos.
                               Aqui podras hacer la gestion de tus Sistemas operativos
                               ---------------------------------------------------------
                               1.   Registrar un Nuevo Sistema Operativo.
                               2.   Actualizar Informacion del Sistema Operativo.
                               3.   Eliminacion de un Sistema Operativo.
                               4.   Visualizacion de Los Sistemas Operativos.
                               5.   Regresar al Menu anterior....
                               --------------------------------------------
                               """);
        switch (op) {
            case 1:
                registrar();
                break;
            case 2:
                actualizar();
                break;
            case 3:
                eliminar();
                break;
            case 4:
                listar();
                break;
            case 5:
                System.out.println("Regresando al menu anterior...");
                Menu m = new Menu();
                m.Menu_principal();
                break;
        }
    }
}
