package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.persona;

public class GestionClientesImpl implements GestionClientes {

    conexiondb c = new conexiondb();
    GestionPersona gp = new GestionPersona();

    @Override
    public void agregar_Clientes(persona p) {
        gp.agregarPersona(p);
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM persona");
            if (rs.next()) {
                int idCliente = rs.getInt(1);
                p.setId(idCliente);

                PreparedStatement ps = cn.prepareStatement("insert into clientes(id) values (?)");
                ps.setInt(1, p.getId());
                ps.executeUpdate();
                System.out.println("Registro Existoso");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar_Clientes(Clientes cl, int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update persona set nombre=?, identificacion=?, correo=?, telefono=? where id=?");
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getIdentificacion());
            ps.setString(3, cl.getCorreo());
            ps.setString(4, cl.getTelefono());
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.println("ACTUALIZACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar_Clientes(int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from clientes where id=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el empleado?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
                System.out.println("ELIMINACION EXITOSA!");
                gp.eliminacionPersona(id);
            } else {
                System.out.println("Operacion cancelada");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Clientes> visualizar_Clientes() {
        ArrayList<Clientes> clientes = new ArrayList<>();
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select p.id, p.nombre,p.identificacion,p.correo,p.telefono from clientes c left join persona p on p.id=c.id");
            while (rs.next()) {
                clientes.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public Clientes buscar(int id) {
        Clientes cl = null;
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select p.id, p.nombre,p.identificacion,p.correo,p.telefono from clientes c left join persona p on p.id=c.id where c.id=" + id);
            if (rs.next()) {
                cl = new Clientes();
                cl.setId(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setIdentificacion(rs.getString(3));
                cl.setCorreo(rs.getString(4));
                cl.setTelefono(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cl;
    }

}
