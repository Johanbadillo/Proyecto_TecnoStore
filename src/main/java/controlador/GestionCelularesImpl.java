package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Celulares;
import modelo.marca;
import modelo.sistema_operativo;

public class GestionCelularesImpl implements GestionCelulares {

    conexiondb c = new conexiondb();

    @Override
    public void agregar_celulares(Celulares cel) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("insert into celulares(id_marca, modelo, id_sistema_operativo, gama, precio,stock ) values(?,?,?,?,?,?)");
            ps.setString(1, String.valueOf(cel.getId_marca().getId()));
            ps.setString(2, cel.getModelo());
            ps.setString(3, String.valueOf(cel.getId_sistema_operativo().getId()));
            ps.setString(4, cel.getGama());
            ps.setDouble(5, cel.getPrecio());
            ps.setInt(6, cel.getStock());
            ps.executeUpdate();
            System.out.println("Registrado Con Exito!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar_celulares(Celulares cel, int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("update celulares set id_marca=?, modelo=?, id_sistema_operativo=?, gama=?, precio=?,stock=?  where id=?");
            ps.setString(1, String.valueOf(cel.getId_marca().getId()));
            ps.setString(2, cel.getModelo());
            ps.setString(3, String.valueOf(cel.getId_sistema_operativo().getId()));
            ps.setString(4, cel.getGama());
            ps.setDouble(5, cel.getPrecio());
            ps.setDouble(6, cel.getStock());
            ps.setInt(7, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el Celular?", null, JOptionPane.YES_NO_OPTION);
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
    public void eliminar_celulares(int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from celulares where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Celular?", null, JOptionPane.YES_NO_OPTION);
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
    public ArrayList<Celulares> visualizar_celulares() {
        ArrayList<Celulares> Celular = new ArrayList<>();
        GestionMarca gm = new GestionMarcaImpl();
        GestionSistemaOperativos gsio = new GestionSistemaOperativosImpl();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Celulares");
            while (rs.next()) {
                marca mr = gm.buscar(Integer.parseInt(rs.getString(2)));
                sistema_operativo sio = gsio.buscar(Integer.parseInt(rs.getString(4)));
                Celular.add(new Celulares(rs.getInt(1), mr, rs.getString(3), sio, rs.getString(5), rs.getDouble(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Celular;
    }

    @Override
    public Celulares buscar(int id) {
        Celulares cel = null;
        GestionMarca gm = new GestionMarcaImpl();
        GestionSistemaOperativos gsio = new GestionSistemaOperativosImpl();
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from celulares where id=" + id);
            if (rs.next()) {
                cel = new Celulares();
                marca mr = gm.buscar(Integer.parseInt(rs.getString(2)));
                sistema_operativo sio = gsio.buscar(Integer.parseInt(rs.getString(4)));
                cel.setId(rs.getInt(1));
                cel.setId_marca(mr);
                cel.setModelo(rs.getString(3));
                cel.setId_sistema_operativo(sio);
                cel.setGama(rs.getString(5));
                cel.setPrecio(rs.getInt(6));
                cel.setStock(rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cel;
    }
}
