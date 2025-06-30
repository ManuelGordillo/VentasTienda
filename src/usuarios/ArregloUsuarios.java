
package usuarios;

public class ArregloUsuarios {
    
    private int user = 0;
    Usuario [] usuarios;
    
    public ArregloUsuarios(int user){
        usuarios = new Usuario[user];
    }
    
    public void agregarUsuario(Usuario usr){
        if (user < usuarios.length) {
            usuarios[user++] = usr;
        }else{
            System.out.println("Capacidad Máxima alcanzada");
        }
//        usuarios [user] = usr;
//        user++;
    }
    
    public void modificarUsuario(Usuario usr){
        for (int i = 0; i < user; i++) {
            if (usuarios[i].getIdUsuario() == usr.getIdUsuario()) {
                usuarios[i] = usr;
                break;
            }
            
        }
//        for (int i = 0; i < user; i++) {
//            if (usuarios[i].getNombres()== usr.getNombres()) {
//                usuarios[i] = usr;
//                break;
//                
//            }
//        }
    }
    
    public void eliminarPorId(int id){
        
        for (int i = 0; i < user; i++) {
            if (usuarios[i].getIdUsuario() == id) {
                for (int j = i; j < user-1; j++) {
                    usuarios[j] = usuarios[j+1];
                }
                usuarios[--user] = null;
                break;
                
            }
            
        }
//        for (int i = 0; i < user; i++) {
//            if (usuarios[i].getNombres()== nombres) {
//                user--;
//                for (int j = 0; j < user; j++) {
//                    usuarios [i] = usuarios[j]; 
//                }
//            }
//            
//        }
    }
    
    public Usuario[] obtenerUsuarios() {
        Usuario[] resultado = new Usuario[user];
        for (int i = 0; i < user; i++) {
            resultado[i] = usuarios[i];
        }
        return resultado;
    }
    
    public Usuario buscarPorCredencial(String usuario, String contrasena){
        for (int i = 0; i < user; i++) {
            if (usuarios[i].getNombreUsuario().equals(usuario)&& usuarios[i].getContrasena().equals(contrasena)) {
               return usuarios[i]; 
            }
            
        }
        return null;
    }
    
    public int obtenerSiguienteId(){
        return user + 1;
    }
    
    public void mostrarUsuarios(){
        
        for (int i = 0; i < user; i++) {
            System.out.println("Posicion: " + i + "\t" + usuarios [i].toString());
        }
    }
    
}
