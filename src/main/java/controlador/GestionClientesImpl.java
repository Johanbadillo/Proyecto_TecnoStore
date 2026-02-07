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
    public void actualizar_Clientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
