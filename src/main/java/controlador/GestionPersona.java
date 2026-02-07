package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.persona;

public class GestionPersona {
    conexiondb c = new conexiondb();
    
    public void agregarPersona(persona p){
        try (Connection cn= c.conectar( )){
            PreparedStatement ps = cn.prepareStatement("insert into persona(nombre,identificacion,correo,telefono) values (?,?,?,?)");
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getIdentificacion());
            ps.setString(3,p.getCorreo());
            ps.setString(4,p.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
