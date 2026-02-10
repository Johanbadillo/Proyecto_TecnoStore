package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Ventas;

public class GestionVentasImpl implements GestionVentas {

    conexiondb c = new conexiondb();
    

    @Override
    public void agregar_detalle_venta(DetalleVenta dv) {
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM Ventas");
            if (rs.next()) {
                int idVenta = rs.getInt(1);
                PreparedStatement ps = cn.prepareStatement("insert into detalle_ventas(id_venta,id_celular,cantidad,subtotal) values (?,?,?,?)");
                ps.setString(1, String.valueOf(idVenta));
                ps.setInt(2, dv.getCelular().getId());
                ps.setInt(3, dv.getCantidad());
                ps.setDouble(4, dv.getSubtotal());
                ps.executeUpdate();
                System.out.println("Registro Existoso");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void agregar_venta(Ventas v) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("insert into ventas(id_cliente, fecha, total) values (?,?,?)");
            ps.setInt(1, v.getCliente().getId());
            ps.setDate(2, new java.sql.Date(v.getFecha().getTime()));
            ps.setDouble(3, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar_venta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar_venta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Ventas> visualizar_venta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ventas buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
