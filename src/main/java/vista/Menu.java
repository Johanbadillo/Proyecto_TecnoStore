package vista;

import controlador.Validaciones;

public class Menu {

    public void Menu_principal() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 6, """
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
