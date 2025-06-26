
package usuarios;

public class Usuario {
    private String nombres;
    private String apellidos;
    private String user;
    private String cargo;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String user, String cargo, String password) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.cargo = cargo;
        this.password = password;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
