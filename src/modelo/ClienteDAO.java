
package modelo;




import java.sql.*;
import java.util.*;
import modelo.Cliente;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Pila para guardar clientes eliminados (para deshacer)
    private Stack<Cliente> pilaEliminados = new Stack<>();

    // 1. Listar clientes como cola (FIFO)
    public Queue<Cliente> listarComoCola() {
        Queue<Cliente> colaClientes = new LinkedList<>();
        String sql = "SELECT * FROM cliente";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("idcliente"));
                c.setDni(rs.getString("dni"));
                c.setNombres(rs.getString("nombres"));
                c.setDireccion(rs.getString("direccion"));
                c.setEstado(rs.getString("estado"));
                colaClientes.offer(c); // Agrega al final de la cola
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        return colaClientes;
    }

    // 2. Agregar cliente
    public int agregar(Cliente c) {
        String sql = "INSERT INTO cliente(dni, nombres, direccion, estado) VALUES (?, ?, ?, ?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombres());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
        return 0;
    }

    // 3. Buscar cliente por DNI
    public Cliente buscarPorDni(String dni) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE dni = ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("idcliente"));
                c.setDni(rs.getString("dni"));
                c.setNombres(rs.getString("nombres"));
                c.setDireccion(rs.getString("direccion"));
                c.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por DNI: " + e.getMessage());
        }
        return c;
    }

    // 4. Modificar cliente por DNI
    public int modificar(Cliente c) {
        String sql = "UPDATE cliente SET nombres=?, direccion=?, estado=? WHERE dni=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getEstado());
            ps.setString(4, c.getDni());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
        return 0;
    }

    // 5. Eliminar cliente por DNI y guardar en pila
    public int eliminarPorDni(String dni) {
        String selectSQL = "SELECT * FROM cliente WHERE dni=?";
        String deleteSQL = "DELETE FROM cliente WHERE dni=?";
        try {
            con = cn.conectar();

            // Buscar antes de eliminar para guardar en la pila
            ps = con.prepareStatement(selectSQL);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("idcliente"));
                c.setDni(rs.getString("dni"));
                c.setNombres(rs.getString("nombres"));
                c.setDireccion(rs.getString("direccion"));
                c.setEstado(rs.getString("estado"));
                pilaEliminados.push(c);
            }

            // Eliminar de la base de datos
            ps = con.prepareStatement(deleteSQL);
            ps.setString(1, dni);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
        return 0;
    }

    // 6. Deshacer última eliminación
    public int deshacerEliminacion() {
        if (!pilaEliminados.isEmpty()) {
            Cliente c = pilaEliminados.pop();
            return agregar(c); // Reutiliza método agregar
        } else {
            System.out.println("No hay clientes para restaurar.");
        }
        return 0;
    }
    
    // 7. Muestra la pila de eliminados
    public Stack<Cliente> obtenerEliminados() {
    return (Stack<Cliente>) pilaEliminados.clone(); // Devuelve copia para no modificar la pila original
}
    
    
    
    
}
