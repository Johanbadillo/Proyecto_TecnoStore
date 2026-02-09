package vista;

import controlador.GestionSistemaOperativos;
import controlador.GestionSistemaOperativosImpl;
import controlador.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.sistema_operativo;

public class MenuSistemasOperativos {

    GestionSistemaOperativos gsio = new GestionSistemaOperativosImpl();

    private void registrar() {
        sistema_operativo sio = new sistema_operativo();
        System.out.println("Ingrese el nombre de nuevo Sistema Operativo");
        sio.setNombre(new Scanner(System.in).nextLine());
        gsio.agregar_SistemaOperativo(sio);
        menu();
    }

    public void actualizar() {
        System.out.println("Ingresa el id del sistema que deseas Actualizar");
        int id = new Scanner(System.in).nextInt();
        sistema_operativo sio = gsio.buscar(id);
        if (sio != null) {
            System.out.println(sio);
            System.out.println("Ingresa el nuevo Nombre del Sistema Operativo");
            sio.setNombre(new Scanner(System.in).nextLine());
            gsio.actualizar_SistemaOperativo(sio, id);
        } else{
            System.out.println("No se Encontro Ningun Sistema Operativo Con ese ID!");
        }
        menu();
    }

    public void eliminar() {
        System.out.println("Ingrese el id del Sistema Operativo que desees eliminar");
        int id = new Scanner(System.in).nextInt();
        sistema_operativo sio = gsio.buscar(id);
        System.out.println(sio);
        gsio.eliminar_SistemaOperativo(id);
        menu();
    }

    public void listar() {
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
                               Bienvenido al Menu de Sistemas Operativos.
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
