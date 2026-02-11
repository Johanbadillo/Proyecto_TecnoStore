package vista;

import controlador.GestionCelulares;
import controlador.GestionCelularesImpl;
import controlador.GestionClientes;
import controlador.GestionClientesImpl;
import controlador.GestionVentas;
import controlador.GestionVentasImpl;
import controlador.Validaciones;
import controlador.funcionesClientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Celulares;
import modelo.Clientes;
import modelo.DetalleVenta;
import modelo.Ventas;

public class MenuVentas {

    Ventas v = new Ventas();
    GestionClientes gc = new GestionClientesImpl();
    GestionCelulares gcel = new GestionCelularesImpl();
    GestionVentas gv = new GestionVentasImpl();
    funcionesClientes fcl = new funcionesClientes();
    MenuCelulares mcel = new MenuCelulares();
    DetalleVenta dv = new DetalleVenta();
    Validaciones vd = new Validaciones();

    public Ventas auxValidacion() {
        v = null;
        while (v == null) {
            System.out.println("Ingrese El id de la venta");
            String busqueda = new Scanner(System.in).nextLine();
            try {
                int id = Integer.parseInt(busqueda.trim());
                v = gv.buscar(id);
                if (v != null) {
                    System.out.println(v);
                    ArrayList<DetalleVenta> detalles = gv.buscar_detalles(v.getId());
                    for (DetalleVenta dvn : detalles) {
                        System.out.println(dvn);
                    }
                    return v;
                } else {
                    System.out.println("No se Encontro Ninguna venta Con ese ID!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error porfa ingrese solo numeros");
            }
        }
        return null;
    }

    private void registrar() {
        Date fecha = Validaciones.validateFecha();
        v.setFecha(fecha);
        System.out.println("""
                           ===================
                           Clientes
                           ===================""");
        ArrayList<Clientes> clientes = gc.visualizar_Clientes();
        for (Clientes cl : clientes) {
            System.out.println(cl);
        }
        Clientes cl = fcl.auxValidacion();
        v.setCliente(cl);
        gv.agregar_venta(v);
        System.out.println("""
                           ===================
                           Celulares
                           ===================""");
        ArrayList<Celulares> celular = gcel.visualizar_celulares();
        for (Celulares cel : celular) {
            System.out.println(cel);
        }
        boolean MasCel = true;
        while (MasCel) {
            Celulares cel = mcel.auxValidacion();
            dv.setCelular(cel);
            System.out.println("Ingresa la Cantidad de Celulares que desean llevar");
            dv.setCantidad(new Scanner(System.in).nextInt());
            gv.agregar_detalle_venta(dv);
            System.out.println("Deseas Agregar mas Celulares a la Venta?\n1. si\n2. NO");
            int opt = new Scanner(System.in).nextInt();
            if (opt == 2) {
                MasCel = false;
            }
        }
        menu();
    }   

    private void actualizar() {
        v = auxValidacion();
        int opt = vd.validacion(1, 7, """
                ===============================
                Que es lo que deseas Actualizar
                ===============================
                
                1. La Fecha de la venta Registrada
                2. El cliente Registrado
                3. Salir
                                    """);
        switch (opt) {
            case 1:
                Date fecha = Validaciones.validateFecha();
                v.setFecha(fecha);
                break;
            case 2:
                System.out.println("""
                           ===================
                           Clientes
                           ===================""");
                ArrayList<Clientes> clientes = gc.visualizar_Clientes();
                for (Clientes cl : clientes) {
                    System.out.println(cl);
                }
                Clientes cl = fcl.auxValidacion();
                v.setCliente(cl);
                break;
            case 3:
                menu();
                break;
        }
        gv.actualizar_venta(v, v.getId());
        menu();
    }

    private void eliminar() {
        v = auxValidacion();
        gv.eliminar_detalles(v.getId());
        gv.eliminar_venta(v.getId());
        menu();
    }

    private void listar() {
        ArrayList<Ventas> venta = gv.visualizar_venta();
        for (Ventas vn : venta) {
            System.out.println(vn);
        }
        menu();
    }

    private void buscar() {
        auxValidacion();
        menu();
    }

    public void menu() {
        int op = 0;
        op = vd.validacion(1, 6, """
                               --------------------------------------------
                               Menu Ventas.
                               Aqui podras hacer la gestion de tus Ventas
                               --------------------------------------------
                               1.   Registrar Venta nueva.
                               2.   Actualizar Informacion de Venta.
                               3.   Eliminacion de Venta.
                               4.   Visualizacion de Ventas.
                               5.   Busqueda Individual de Venta.
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
