package modelo;

import java.io.Serializable;

public class Clientes extends persona implements Serializable{
    
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
               ID:          %s
               Nombre:      %s
               C.C:         %S
               correo:      %s
               telefono:    %s
               """.formatted(getId(),getNombre(),getIdentificacion(),getCorreo(),getTelefono());
    }
}
