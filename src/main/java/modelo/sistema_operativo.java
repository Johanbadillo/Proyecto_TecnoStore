package modelo;

public class sistema_operativo {

    private int id;
    private String nombre;

    public sistema_operativo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public sistema_operativo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return """
              -----------------
               Sistema operativo
               -----------------
               ID:      %s
               Nombre:  %s
               """.formatted(id, nombre);
    }

}
