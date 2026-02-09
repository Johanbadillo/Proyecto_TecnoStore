package vista;

import controlador.GestionMarca;
import controlador.GestionMarcaImpl;
import controlador.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.marca;

public class MenuMarca {

    GestionMarca gm = new GestionMarcaImpl();

    private void registrar() {
        marca mr = new marca();
        System.out.println("Ingrese el nombre de la nueva marca");
        mr.setNombre(new Scanner(System.in).nextLine());
        gm.agregar_Marca(mr);
        menu();
    }

    public void actualizar() {
        System.out.println("Ingresa el id de la marca que deseas Actualizar");
        int id = new Scanner(System.in).nextInt();
        marca mr = gm.buscar(id);
        if (mr != null) {
            System.out.println(mr);
            System.out.println("Ingresa el nuevo Nombre de la marca");
            mr.setNombre(new Scanner(System.in).nextLine());
            gm.actualizar_marca(mr, id);
        } else {
            System.out.println("No se Encontro Ninguna marca Con ese ID!");
        }
        menu();
    }

    public void eliminar() {
        System.out.println("Ingrese el id de la marca que desees eliminar");
        int id = new Scanner(System.in).nextInt();
        marca mr = gm.buscar(id);
        if (mr != null) {
            System.out.println(mr);
            gm.eliminar_marca(id);
        } else {
            System.out.println("No existe la marca");
        }
        menu();
    }

    public void listar() {
        ArrayList<marca> marcas = gm.visualizar_marca();
        for (marca mr : marcas) {
            System.out.println(mr);
        }
        menu();
    }

    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 5, """
                               --------------------------------------------
                               Bienvenido al Menu Marca.
                               Aqui podras hacer la gestion de tus Marcas
                               --------------------------------------------
                               1.   Registrar una Marca Nueva.
                               2.   Actualizar Informacion de tus Marcas.
                               3.   Eliminacion de una Marca.
                               4.   Visualizacion de tus Marcas.
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
