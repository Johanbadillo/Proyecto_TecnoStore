package vista;

import controlador.GestionCelulares;
import controlador.GestionCelularesImpl;
import controlador.GestionMarca;
import controlador.GestionMarcaImpl;
import controlador.GestionSistemaOperativos;
import controlador.GestionSistemaOperativosImpl;
import controlador.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Celulares;
import modelo.marca;
import modelo.sistema_operativo;

public class MenuCelulares {

    Validaciones v = new Validaciones();
    GestionCelulares gcel = new GestionCelularesImpl();
    GestionMarca gm = new GestionMarcaImpl();
    GestionSistemaOperativos gsio = new GestionSistemaOperativosImpl();
    MenuMarca mm = new MenuMarca();
    MenuSistemasOperativos msio = new MenuSistemasOperativos();

    public Celulares auxValidacion() {
        Celulares cel = null;
        while (cel == null) {
            System.out.println("Ingrese El id del Celular");
            String busqueda = new Scanner(System.in).nextLine();
            try {
                int id = Integer.parseInt(busqueda.trim());
                cel = gcel.buscar(id);
                if (cel != null) {
                    System.out.println(cel);
                    return cel;
                } else {
                    System.out.println("No se Encontro Ninguna Celular Con ese ID!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error porfa ingrese solo numeros");
            }
        }
        return null;
    }

    private void registrar() {
        Celulares cel = new Celulares();
        System.out.println("""
                           ===================
                           Marcas
                           ===================""");
        ArrayList<marca> marcas = gm.visualizar_marca();
        for (marca mr : marcas) {
            System.out.println(mr);
        }
        marca mr = mm.auxValidacion();
        cel.setId_marca(mr);
        System.out.println("Ingresa el modelo del celular");
        cel.setModelo(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el precio del celular");
        cel.setPrecio(new Scanner(System.in).nextDouble());
        System.out.println("Ingresa la cantidad de celulares disponibles");
        cel.setStock(new Scanner(System.in).nextInt());
        System.out.println("""
                           ===================
                           Sistemas Operativos
                           ===================
                           """);
        ArrayList<sistema_operativo> sistema_operativos = gsio.visualizar_SistemaOperativo();
        for (sistema_operativo sio : sistema_operativos) {
            System.out.println(sio);
        }
        sistema_operativo sio = msio.auxValidacion();
        cel.setId_sistema_operativo(sio);
        int op = v.validacion(1, 3, """
                           ==========================================
                           Ingresa el numero de la gama del celular
                           ==========================================
                           1.   Alta    2.   Media  3.   Baja
                           """);
        switch (op) {
            case 1:
                cel.setGama("alta");
                break;
            case 2:
                cel.setGama("media");
                break;
            case 3:
                cel.setGama("baja");
                break;
        }
        gcel.agregar_celulares(cel);
        menu();
    }

    private void actualizar() {
        Celulares cel = auxValidacion();
        if (cel != null) {
            int op = v.validacion(1, 7, """
                               ===============================
                               Que es lo que deseas Actualizar
                               ===============================
                               Porfa Ingresa el numero de la opcion.
                               
                               1.   La marca del celular.
                               2.   El modelo del celular.
                               3.   El precio del celular.
                               4.   La Disponibilidad del celular.
                               5.   El sistema operativo.
                               6.   La gama del celular.
                               7.Cancelar
                               """);
            switch (op) {
                case 1:
                    System.out.println("""
                           ===================
                           Marcas
                           ===================
                           """);
                    ArrayList<marca> marcas = gm.visualizar_marca();
                    for (marca mr : marcas) {
                        System.out.println(mr);
                    }
                    marca mr = mm.auxValidacion();
                    cel.setId_marca(mr);
                    break;
                case 2:
                    System.out.println("Ingresa el nuevo modelo del celular");
                    cel.setModelo(new Scanner(System.in).nextLine());
                    break;
                case 3:
                    System.out.println("Ingresa el nuevo precio del celular");
                    cel.setPrecio(new Scanner(System.in).nextDouble());
                    break;
                case 4:
                    System.out.println("Ingresa la nueva cantidad de celulares disponibles");
                    cel.setStock(new Scanner(System.in).nextInt());
                    break;
                case 5:
                    System.out.println("""
                           ===================
                           Sistemas Operativos
                           ===================
                           """);
                    ArrayList<sistema_operativo> sistema_operativos = gsio.visualizar_SistemaOperativo();
                    for (sistema_operativo sio : sistema_operativos) {
                        System.out.println(sio);
                    }
                    sistema_operativo sio = msio.auxValidacion();
                    cel.setId_sistema_operativo(sio);
                    break;
                case 6:
                    int oop = v.validacion(1, 3, """
                           ==========================================
                           Ingresa el numero de la gama del celular
                           ==========================================
                           1.   Alta    2.   Media  3.   Baja
                           """);
                    switch (oop) {
                        case 1:
                            cel.setGama("alta");
                            break;
                        case 2:
                            cel.setGama("media");
                            break;
                        case 3:
                            cel.setGama("baja");
                            break;
                    }
                    break;
                case 7:
                    menu();
                    break;
            }
            gcel.actualizar_celulares(cel, cel.getId());
        } else {
            System.out.println("No existe un celular con este id!");
        }
        menu();
    }

    private void eliminar() {
        Celulares cel = auxValidacion();
        if (cel != null) {
            gcel.eliminar_celulares(cel.getId());
        }
        menu();
    }

    private void listar() {
        ArrayList<Celulares> celular = gcel.visualizar_celulares();
        for (Celulares cel : celular) {
            System.out.println(cel);
        }
        menu();
    }

    private void buscar() {
        Celulares cel = auxValidacion();
        menu();
    }

    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 6, """
                               --------------------------------------------
                               Bienevido al Menu Celulares.
                               Aqui podras hacer la gestion de tus Celulares
                               --------------------------------------------
                               1.   Registrar Celular nuevo.
                               2.   Actualizar Informacion de tus Celulares.
                               3.   Eliminacion de Celular.
                               4.   Visualizacion de Celulares.
                               5.   Busqueda Individual de Celular.
                               6.   Regresar al Menu anterior....
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
                buscar();
                break;
            case 6:
                System.out.println("Regresando al menu anterior...");
                Menu m = new Menu();
                m.Menu_principal();
                break;
        }
    }
}
