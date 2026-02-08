package vista;

import controlador.Validaciones;
import controlador.funcionesClientes;

public class MenuClientes {

    private void registro() {
        funcionesClientes fc = new funcionesClientes();
        fc.ftRegistro();
    }

    private void actualizacion() {
        funcionesClientes fc = new funcionesClientes();
        fc.ftActualizacion();
    }

    private void eliminacion() {
        funcionesClientes fc = new funcionesClientes();
        fc.ftEliminacion();
    }

    private void buscar() {
        funcionesClientes fc = new funcionesClientes();
        fc.ftBuscar();
    }

    private void listar() {
        funcionesClientes fc = new funcionesClientes();
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
