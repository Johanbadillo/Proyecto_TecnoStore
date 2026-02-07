package modelo;

public class empleados extends persona {
    
    private double salario;

    public empleados(double salario,int id, String nombre, String identificacion, String correo, String telefono) {
        super(id, nombre, identificacion, correo, telefono);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    @Override
    public String toString() {
        return """ 
               -----------------------------------------
               Empleados
               -----------------------------------------
               Nombre:      %s
               C.C:         %S
               correo:      %s
               telefono:    %s
               """.formatted(getNombre(),getIdentificacion(),getCorreo(),getTelefono());
    }
}
