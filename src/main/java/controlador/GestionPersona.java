package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
    
    public void eliminacionPersona(int id){
        try(Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from persona where id=?");
            ps.setInt(1,id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la persona del registro?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("ELIMINACION EXITOSA!");
            } else {
                System.out.println("Operacion cancelada");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
