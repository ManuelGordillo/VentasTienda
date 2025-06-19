
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {
    Conexion con = new Conexion();

    public EntidadVendedor ValidarVendedor(String dni, String usuario) {
    String sql = "SELECT * FROM vendedor WHERE DNI = ? AND Usuario = ?";
    EntidadVendedor ev = null;

    Connection acceso = con.Conectar(); // intenta conectar

    if (acceso == null) {
        System.out.println("❌ No se pudo establecer la conexión con la base de datos.");
        return null; // evita el NullPointerException
    }

    try (
        PreparedStatement ps = acceso.prepareStatement(sql);
    ) {
        ps.setString(1, dni);
        ps.setString(2, usuario);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                ev = new EntidadVendedor();
                ev.setId(rs.getInt("IdVendedor"));
                ev.setDni(rs.getString("DNI"));
                ev.setNombre(rs.getString("Nombres"));
                ev.setTelefono(rs.getString("Telefono"));
                ev.setEstado(rs.getString("Estado"));
                ev.setUsuario(rs.getString("Usuario"));
            }
        }
    } catch (SQLException e) {
        System.out.println("❌ Error al validar vendedor: " + e.getMessage());
    }

    return ev;
}

}

