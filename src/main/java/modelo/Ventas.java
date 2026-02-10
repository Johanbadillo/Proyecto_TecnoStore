package modelo;

import java.util.Date;

public class Ventas {
    private int id;
    private Clientes cliente;
    private Date fecha;
    private double total;

    public Ventas(int id, Clientes cliente, Date fecha, double total) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }

    public Ventas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return """
               -----------------------------------
               Cliente:     %s
               Fecha:       %s
               Total:       %s
               """.formatted(cliente, fecha, total);
    }
}
