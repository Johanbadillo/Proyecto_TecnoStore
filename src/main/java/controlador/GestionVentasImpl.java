package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Celulares;
import modelo.Clientes;
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
                
                double totalCalculado = 0;
                Statement st2 = cn.createStatement();
                ResultSet rs2 = st2.executeQuery(
                        "SELECT SUM(subtotal*1.19) FROM detalle_ventas WHERE id_venta= " + idVenta
                );

                if (rs2.next()) {
                    totalCalculado = rs2.getDouble(1);
                }
                PreparedStatement ps2 = cn.prepareStatement(
                        "UPDATE ventas SET total=? WHERE id=?"
                );
                ps2.setDouble(1, totalCalculado);
                ps2.setInt(2, idVenta);
                ps2.executeUpdate();
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
    public void actualizar_venta(Ventas v, int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("update ventas set id_cliente=?, fecha=?,total=?  where id=?");
            ps.setInt(1, v.getCliente().getId());
            ps.setDate(2, new java.sql.Date(v.getFecha().getTime()));
            ps.setDouble(3, v.getTotal());
            ps.setInt(4, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la Venta?", null, JOptionPane.YES_NO_OPTION);
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
    public void eliminar_venta(int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from ventas where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ELIMINACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar_detalles(int id) {
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("delete from detalle_ventas where id_venta=?");
            ps.setInt(1, id);
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la venta?", null, JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                ps.executeUpdate();
            } else {
                System.out.println("Operacion cancelada");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Ventas> visualizar_venta() {
        ArrayList<Ventas> venta = new ArrayList<>();
        GestionClientes gcl = new GestionClientesImpl();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ventas");
            while (rs.next()) {
                Clientes cl = gcl.buscar(rs.getInt(2));
                venta.add(new Ventas(rs.getInt(1), cl, rs.getDate(3), rs.getDouble(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return venta;
    }

    @Override
    public Ventas buscar(int id) {
        Ventas vn = null;
        GestionClientes gcl = new GestionClientesImpl();
        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from ventas where id=" + id);
            if (rs.next()) {
                vn = new Ventas();
                Clientes cl = gcl.buscar(Integer.parseInt(rs.getString(2)));
                vn.setId(rs.getInt(1));
                vn.setCliente(cl);
                vn.setFecha(rs.getDate(3));
                vn.setTotal(rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vn;
    }

    @Override
    public ArrayList<DetalleVenta> buscar_detalles(int id_venta) {
        ArrayList<DetalleVenta> detalles = new ArrayList<>();
        GestionCelulares gcel = new GestionCelularesImpl();

        try (Connection cn = c.conectar()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from detalle_ventas where id_venta=" + id_venta);
            Ventas vn = buscar(id_venta);
            while (rs.next()) {
                Celulares cel = gcel.buscar(Integer.parseInt(rs.getString(3)));
                detalles.add(new DetalleVenta(rs.getInt(1), vn, cel, rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return detalles;
    }
}
