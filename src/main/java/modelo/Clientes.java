package modelo;

public class Clientes extends persona {
    
    public Clientes(int id, String nombre, String identificacion, String correo, String telefono) {
        super(id, nombre, identificacion, correo, telefono);
    }

    public Clientes() {
        
    }

    @Override
    public String toString() {
        return """ 
               -----------------------------------------
               Cliente
               -----------------------------------------
               Nombre:      %s
               C.C:         %S
               correo:      %s
               telefono:    %s
               """.formatted(getNombre(),getIdentificacion(),getCorreo(),getTelefono());
    }
}
