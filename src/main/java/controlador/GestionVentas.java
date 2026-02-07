package controlador;

import java.util.ArrayList;
import modelo.Ventas;

public interface GestionVentas {

    void agregar_venta();

    void actualizar_venta();

    void eliminar_venta();

    ArrayList<Ventas> visualizar_venta();

    Ventas buscar(int id);
}
