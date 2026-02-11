package vista;

import controlador.GestionReportes;
import controlador.GestionVentas;
import controlador.GestionVentasImpl;
import controlador.Validaciones;
import java.util.List;
import java.util.Map;

public class Reportes {

    GestionVentas gv = new GestionVentasImpl();
    GestionReportes gr = new GestionReportes();

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
                List<Map<String, Object>> top = gr.obtenerTop3CelularesMasVendidos();

                if (top == null || top.isEmpty()) {
                    System.out.println("No hay ventas registradas todavía.");
                } else {
                    System.out.println("═══════════════════════════════════════════════");
                    System.out.println("          TOP 3 CELULARES MÁS VENDIDOS          ");
                    System.out.println("═══════════════════════════════════════════════");

                    int posicion = 1;
                    for (Map<String, Object> item : top) {
                        System.out.printf("%d) %-18s %-20s | %6d unidades | $%,d%n",
                                posicion++,
                                item.get("marca") + " " + item.get("modelo"),
                                "(" + item.get("gama") + ")",
                                item.get("unidades"),
                                item.get("totalVentas")
                        );
                    }
                    System.out.println("═══════════════════════════════════════════════");
                }
                menu();
                break;
            case 2:

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
