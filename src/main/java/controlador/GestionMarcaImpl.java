package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.marca;

public class GestionMarcaImpl implements GestionMarca {

    conexiondb c = new conexiondb();

    @Override
    public void agregar_Marca(marca mr) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("insert into marca(nombre) values(?)");
            ps.setString(1, mr.getNombre());
            ps.executeUpdate();
            System.out.println("Resgistrado Con Exito!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar_marca(marca mr, int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("update marca set nombre=? where id=?");
            ps.setString(1, mr.getNombre());
            ps.setInt(2, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la marca?", null, JOptionPane.YES_NO_OPTION);
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
    public void eliminar_marca(int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from marca where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la marca?", null, JOptionPane.YES_NO_OPTION);
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
    public ArrayList<marca> visualizar_marca() {
        ArrayList<marca> marcas = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from marca");
            while (rs.next()) {
                marcas.add(new marca(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return marcas;
    }

    @Override
    public marca buscar(int id) {
        marca mr = null;
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from marca where id=" + id);
            if (rs.next()) {
                mr = new marca();
                mr.setId(rs.getInt(1));
                mr.setNombre(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mr;
    }
}
