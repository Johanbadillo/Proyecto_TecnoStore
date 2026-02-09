package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.sistema_operativo;

public class GestionSistemaOperativosImpl implements GestionSistemaOperativos {

    conexiondb c = new conexiondb();

    @Override
    public void agregar_SistemaOperativo(sistema_operativo sio) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("insert into sistema_operativo(nombre) values(?)");
            ps.setString(1, sio.getNombre());
            ps.executeUpdate();
            System.out.println("Resgistrado Con Exito!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar_SistemaOperativo(sistema_operativo sio, int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("update sistema_operativo set nombre=? where id=?");
            ps.setString(1, sio.getNombre());
            ps.setInt(2, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el sistema operativo?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("Actualizado Con Exito!!");
            } else {
                System.out.println("Operacion cancelada");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar_SistemaOperativo(int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from sistema_operativo where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el sistema operativo?", null, JOptionPane.YES_NO_OPTION);
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

    @Override
    public ArrayList<sistema_operativo> visualizar_SistemaOperativo() {
        ArrayList<sistema_operativo> sistema_operativos = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from sistema_operativo");
            while (rs.next()) {
                sistema_operativos.add(new sistema_operativo(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sistema_operativos;
    }

    @Override
    public sistema_operativo buscar(int id) {
        sistema_operativo sio = null;
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from sistema_operativo where id=" + id);
            if (rs.next()) {
                sio = new sistema_operativo();
                sio.setId(rs.getInt(1));
                sio.setNombre(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sio;
    }

}
