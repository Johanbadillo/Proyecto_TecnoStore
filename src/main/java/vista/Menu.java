package vista;

import controlador.Validaciones;

public class Menu {

    public void Menu_principal() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 3, """
                               --------------------------------------------
                               Bienevido a Tecno Store 
                               tu aliado para la gestion de tu tienda.
                               --------------------------------------------
                               1.   Gestionar Clientes.
                               2.   Gestionar Ventas.
                               3.   Salir.
                               --------------------------------------------
                               """);
        switch (op) {
            case 1:
                MenuClientes mc = new MenuClientes();
                mc.menu();
                break;
            case 2:
                MenuVentas mv = new MenuVentas();
                mv.menu();
                break;
            case 3:
                System.out.println("Gracias Por usar nuestro Sistema de gestion!");
                break;
        }
    }
}
