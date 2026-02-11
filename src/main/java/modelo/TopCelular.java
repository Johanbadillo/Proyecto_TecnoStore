package modelo;

public class TopCelular {
    private String marca;
    private String modelo;
    private String gama;
    private double precio;
    private int unidadesVendidas;

    public TopCelular(String marca, String modelo, String gama,
                      double precio, int unidadesVendidas) {
        this.marca = marca;
        this.modelo = modelo;
        this.gama = gama;
        this.precio = precio;
        this.unidadesVendidas = unidadesVendidas;
    }

    @Override
    public String toString() {
        return """
               Marca:               %s
               Modelo:              %s
               Gama:                %s
               Precio:              %s  
               Cantidad Vendida:    %s
               """.formatted(marca,modelo,gama,precio,unidadesVendidas);
    }
}

