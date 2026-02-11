package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionReportes {

    conexiondb c = new conexiondb();
    
    public List<Map<String, Object>> obtenerTop3CelularesMasVendidos() {
        List<Map<String, Object>> top3 = new ArrayList<>();

        String sql = """
        SELECT 
            m.nombre AS marca,
            c.modelo,
            c.gama,
            c.precio,
            SUM(dv.cantidad) AS unidades_vendidas,
            ROUND(SUM(dv.subtotal)) AS total_ventas
        FROM celulares c
        INNER JOIN marca m ON c.id_marca = m.id
        INNER JOIN detalle_ventas dv ON dv.id_celular = c.id
        GROUP BY c.id, m.nombre, c.modelo, c.gama, c.precio
        ORDER BY unidades_vendidas DESC
        LIMIT 3
    """;

        try (Connection cn = c.conectar()) {
            PreparedStatement ps = cn.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> item = new HashMap<>();
                item.put("marca", rs.getString("marca"));
                item.put("modelo", rs.getString("modelo"));
                item.put("gama", rs.getString("gama"));
                item.put("precio", rs.getDouble("precio"));
                item.put("unidades", rs.getInt("unidades_vendidas"));
                item.put("totalVentas", rs.getLong("total_ventas"));
                top3.add(item);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return top3;
    } 
}
