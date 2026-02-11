package vista;

import controlador.GestionReportes;
import controlador.GestionVentas;
import controlador.GestionVentasImpl;
import controlador.Validaciones;
import java.util.List;
import modelo.Celulares;
import modelo.TopCelular;

public class Reportes {

    GestionVentas gv = new GestionVentasImpl();
    GestionReportes gr = new GestionReportes();

    private void top() {
        List<TopCelular> top3 = gr.obtenerTop3CelularesMasVendidos();
        for (TopCelular top : top3) {
            System.out.println(top);
        }
        menu();
    }

    private void stockBajo() {
        List<Celulares> lista = gr.obtenerCelularesBajoStock();

        System.out.println("""
                    =====================================
                      CELULARES CON STOCK BAJO (<= 5)
                    =====================================
                    """);
        if (lista.isEmpty()) {
            System.out.println("No hay celulares con stock bajo.");
        } else {
            for (Celulares c : lista) {
                System.out.println(c);
            }
        }
        menu();
    }

    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 6, """
                               --------------------------------------------
                               Reportes.
                               --------------------------------------------
                               1.   Top Celulares Mas Vendidos
                               2.   Celulares Casi Agotados.
                               3.   Ventas Por Mes.
                               4.   Reporte de Venta(Archivo).
                               5.   Regresar al Menu anterior....
                               --------------------------------------------
                               """);
        switch (op) {
            case 1:
                top();
                break;
            case 2:
                stockBajo();
                break;
            case 3:

                break;
            case 4:
                gv.exportarBackup();
                menu();
                break;

            case 5:
                System.out.println("Regresando al menu anterior...");
                Menu m = new Menu();
                m.Menu_principal();
                break;
        }
    }
}
