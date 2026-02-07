package modelo;

public class DetalleVenta {
    private int id;
    private Ventas venta;
    private Celulares celular;
    private int cantidad;
    private double subtotal;

    public DetalleVenta(int id, Ventas venta, Celulares celular, int cantidad) {
        this.id = id;
        this.venta = venta;
        this.celular = celular;
        this.cantidad = cantidad;
        this.subtotal = celular.getPrecio() * cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Celulares getCelular() {
        return celular;
    }

    public void setCelular(Celulares celular) {
        this.celular = celular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return """
               -----------------------------------
               Celular:   %s
               Cantidad:  %s
               Subtotal:  %s
               """.formatted(celular,cantidad,subtotal);
    }
}
