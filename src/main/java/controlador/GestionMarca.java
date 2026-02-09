package controlador;

import java.util.ArrayList;
import modelo.marca;

public interface GestionMarca {

    void agregar_Marca(marca mr);

    void actualizar_marca(marca mr, int id);

    void eliminar_marca(int id);

    ArrayList<marca> visualizar_marca();

    marca buscar(int id);
}
