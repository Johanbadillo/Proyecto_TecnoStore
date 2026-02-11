package controlador;

import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Ventas;

public interface GestionVentas {

    void agregar_venta(Ventas v);

    void actualizar_venta(Ventas v,int id);

    void eliminar_venta(int id);
    
    void eliminar_detalles(int id);

    ArrayList<Ventas> visualizar_venta();
    
    ArrayList<DetalleVenta> buscar_detalles(int id);

    Ventas buscar(int id);

    void agregar_detalle_venta(DetalleVenta dv);
    
    void exportarBackup();
    
}
