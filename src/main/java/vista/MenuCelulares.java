package vista;

import controlador.GestionCelulares;
import controlador.GestionCelularesImpl;
import controlador.GestionMarca;
import controlador.GestionMarcaImpl;
import controlador.GestionSistemaOperativos;
import controlador.GestionSistemaOperativosImpl;
import controlador.Validaciones;
import modelo.Celulares;

public class MenuCelulares {
    
    GestionCelulares gcel= new GestionCelularesImpl();
    GestionMarca gm = new GestionMarcaImpl();
    GestionSistemaOperativos gsio = new GestionSistemaOperativosImpl();
    
    private void registrar(){
        Celulares cel = new Celulares();
        System.out.println("Ingresa ");
    }
    private void actualizar(){
        
    }
    private void eliminar(){
        
    }
    private void listar(){
        
    }
    private void buscar(){
        
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
