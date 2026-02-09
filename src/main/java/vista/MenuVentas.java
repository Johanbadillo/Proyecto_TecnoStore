package vista;

import controlador.Validaciones;

public class MenuVentas {

    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 6, """
                               --------------------------------------------
                               Bienevido al Menu Ventas.
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
