package vista;

import controlador.Validaciones;
import controlador.funcionesClientes;

public class MenuClientes {

    static funcionesClientes fc = new funcionesClientes();

    private void registro() {
        fc.ftRegistro();
    }

    private void actualizacion() {
        fc.ftActualizacion();
    }

    private void eliminacion() {
        fc.ftEliminacion();
    }

    private void buscar() {
        fc.ftBuscar();
    }

    private void listar() {
        fc.ftListar();
    }

    public void menu() {
        int op = 0;
        Validaciones v = new Validaciones();
        op = v.validacion(1, 6, """
                               --------------------------------------------
                               Bienevido al Menu Clientes.
                               Aqui podras hacer la gestion de tus clientes
                               --------------------------------------------
                               1.   Registrar Cliente nuevo.
                               2.   Actualizar Informacion de Cliente.
                               3.   Eliminacion de Cliente.
                               4.   Visualizacion de Clientes.
                               5.   Busqueda Individual de Cliente.
                               6.   Regresar al Menu anterior....
                               --------------------------------------------
                               """);
        switch (op) {
            case 1:
                registro();
                break;
            case 2:
                actualizacion();
                break;
            case 3:
                eliminacion();
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
