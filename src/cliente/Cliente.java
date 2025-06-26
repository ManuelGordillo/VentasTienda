
package cliente;


public class Cliente {
    private String nombres;
    private String apellidos;
    private String dni;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombres, String apellidos, String dni, String correo, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Cliente{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
    
    
    
}
