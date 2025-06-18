
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class VendedorDao {
    PreparedStatement ps;
    ResultSet rs;
    
    EntidadVendedor ev = new EntidadVendedor();
    Conexion con = new Conexion();
    Connection acceso;
    
    public EntidadVendedor ValidarVendedor(String dni, String usuario){
        String sql = "select * from vendedor where DNI=? and Usuario=?";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, usuario);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return ev;
    }
    
   
}
