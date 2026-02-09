package controlador;

import java.util.ArrayList;
import modelo.Celulares;

public interface GestionCelulares {
    
    void agregar_celulares(Celulares cel);

    void actualizar_celulares(Celulares cel, int id);

    void eliminar_celulares(int id);

    ArrayList<Celulares> visualizar_celulares();

    Celulares buscar(int id);
}
