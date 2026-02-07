package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            PreparedStatement ps = con.prepareStatement("update persona set nombre=?, identificacion=? correo=? telefono=? where id=?");
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
    public void eliminar_Clientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Clientes> visualizar_Clientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clientes buscar(int id) {
        Clientes cl = new Clientes();
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from clientes where id=" + id);
            while (rs.next()) {
                cl.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cl;
    }

    public Clientes ver(int id) {
        Clientes cl = new Clientes();
        buscar(id);
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from persona where id=" + id);
            while (rs.next()) {
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
