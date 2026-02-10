package controlador;

import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Ventas;

public interface GestionVentas {

    void agregar_venta(Ventas v);

    void actualizar_venta();

    void eliminar_venta();

    ArrayList<Ventas> visualizar_venta();

    Ventas buscar(int id);

    void agregar_detalle_venta(DetalleVenta dv);
}
