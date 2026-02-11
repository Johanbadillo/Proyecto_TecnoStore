package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Celulares;
import modelo.TopCelular;
import modelo.marca;
import modelo.sistema_operativo;

public class GestionReportes {

    conexiondb c = new conexiondb();

    public List<TopCelular> obtenerTop3CelularesMasVendidos() {

        List<TopCelular> top3 = new ArrayList<>();

        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("""
        SELECT 
            m.nombre,
            c.modelo,
            c.gama,
            c.precio,
            SUM(dv.cantidad)
        FROM celulares c
        INNER JOIN marca m ON c.id_marca = m.id
        INNER JOIN detalle_ventas dv ON dv.id_celular = c.id
        GROUP BY c.id, m.nombre, c.modelo, c.gama, c.precio
        ORDER BY unidades_vendidas DESC
        LIMIT 3
    """);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                TopCelular celular = new TopCelular(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5)
                );

                top3.add(celular);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return top3;
    }

    public List<Celulares> obtenerCelularesBajoStock() {
        List<Celulares> lista = new ArrayList<>();
        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement("""
        SELECT 
            c.id,
            c.modelo,
            c.precio,
            c.stock,
            c.gama,
            m.id,
            m.nombre,
            so.id,
            so.nombre
        FROM celulares c
        INNER JOIN marca m ON c.id_marca = m.id
        INNER JOIN sistema_operativo so ON c.id_sistema_operativo = so.id
        WHERE c.stock <= 5
        ORDER BY c.stock ASC
    """);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                marca m = new marca();
                m.setId(rs.getInt(6));
                m.setNombre(rs.getString(7));

                sistema_operativo so = new sistema_operativo();
                so.setId(rs.getInt(8));
                so.setNombre(rs.getString(9));

                Celulares cel = new Celulares();
                cel.setId(rs.getInt(1));
                cel.setModelo(rs.getString(2));
                cel.setPrecio(rs.getDouble(3));
                cel.setStock(rs.getInt(4));
                cel.setGama(rs.getString(5));
                cel.setId_marca(m);
                cel.setId_sistema_operativo(so);

                lista.add(cel);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return lista;
    }

}
