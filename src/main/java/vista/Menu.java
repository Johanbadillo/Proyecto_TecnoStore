package vista;

import controlador.GestionReportes;
import controlador.Validaciones;
import java.util.List;
import modelo.Celulares;

public class Menu {

    Validaciones v = new Validaciones();

    public void stockBajo() {
        GestionReportes gr = new GestionReportes();
        List<Celulares> lista = gr.obtenerCelularesBajoStock();

        System.out.println("""
                           --- ALERTA DE STOCK BAJO ---
                    """);
        if (lista.isEmpty()) {
            System.out.println("No hay celulares con stock bajo.");
        } else {
            lista.stream().forEach(System.out::println);
            int opp = v.validacion(1, 2, "Deseas guardar el archivo de los celulares casi agotados?\n1. SI\n2.  NO");
            if (opp == 1) {
                gr.exportarBackupStockBajo();
            } else if(opp==2) {
                System.out.println("Operacion Cancelada");
                Menu_principal();
            }
        }
        Menu_principal();
    }

    public void Menu_principal() {
        int op = 0;
        op = v.validacion(1, 7, """
                               --------------------------------------------
                               Bienvenido a Tecno Store 
                               tu aliado para la gestion de tu tienda.
                               --------------------------------------------
                               1.   Gestionar Clientes.
                               2.   Gestionar Celulares
                               3.   Gestionar Ventas.
                               4.   Gestion marcas.
                               5.   Gestion Sistemas Operativos.
                               6.   Reportes.
                               7.   Salir.
                               --------------------------------------------
                               """);
        switch (op) {
            case 1:
                MenuClientes mc = new MenuClientes();
                mc.menu();
                break;
            case 2:
                MenuCelulares mcel = new MenuCelulares();
                mcel.menu();
                break;
            case 3:
                MenuVentas mv = new MenuVentas();
                mv.menu();
                break;
            case 4:
                MenuMarca mm = new MenuMarca();
                mm.menu();
                break;
            case 5:
                MenuSistemasOperativos mso = new MenuSistemasOperativos();
                mso.menu();
                break;
            case 6:
                Reportes r = new Reportes();
                r.menu();
                break;
            case 7:
                System.out.println("Gracias Por usar nuestro Sistema de gestion!");
                break;
        }
    }
}
