package cliente;

//import javax.swing.JOptionPane;

public class Cliente {

    private int idCliente;
    private String nombres;
    private String apellidos;
    private String dni;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombres, String apellidos, String dni, String correo, String telefono) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*// Métodos para mostrar acciones
    public void registrarCliente() {
        JOptionPane.showMessageDialog(null, "Cliente registrado:\n" + this);
    }

    public void actualizarCliente() {
        JOptionPane.showMessageDialog(null, "Datos del cliente actualizados:\n" + this);
    }

    public void eliminarCliente() {
        JOptionPane.showMessageDialog(null, "Cliente eliminado:\n" + this);
    }

    public void mostrarCliente() {
        JOptionPane.showMessageDialog(null, this.toString());
    }*/

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

