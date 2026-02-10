package modelo;

public class Celulares {

    private int id;
    private marca id_marca;
    private String modelo;
    private double precio;
    private int stock;
    private sistema_operativo id_sistema_operativo;
    private String gama;

    public Celulares(int id, marca id_marca, String modelo, sistema_operativo id_sistema_operativo, String gama, double precio, int stock) {
        this.id = id;
        this.id_marca = id_marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.id_sistema_operativo = id_sistema_operativo;
        this.gama = gama;
    }

    public Celulares() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public marca getId_marca() {
        return id_marca;
    }

    public void setId_marca(marca id_marca) {
        this.id_marca = id_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public sistema_operativo getId_sistema_operativo() {
        return id_sistema_operativo;
    }

    public void setId_sistema_operativo(sistema_operativo id_sistema_operativo) {
        this.id_sistema_operativo = id_sistema_operativo;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    @Override
    public String toString() {
        return """
               -----------------------------------------
                            Celulares
               -----------------------------------------
                ID:      %s
                Modelo:  %s
                Precio:  %s
                Gama:    %s 
                Stock:   %s   
                %s                           
                %s
               
               """.formatted(id, modelo, precio, gama,stock,getId_marca(), getId_sistema_operativo());
    }
}
