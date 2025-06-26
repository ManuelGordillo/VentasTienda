
package cliente;


public class NodoCliente {
    private Cliente datos;
    private NodoCliente sgt;
    private NodoCliente ant;
    
    public NodoCliente(String datosNuevos){}

    public NodoCliente(Cliente datos, NodoCliente sgt, NodoCliente ant) {
        this.datos = datos;
        this.sgt = null;
        this.ant = null;
    }

    public Cliente getDatos() {
        return datos;
    }

    public void setDatos(Cliente datos) {
        this.datos = datos;
    }

    public NodoCliente getSgt() {
        return sgt;
    }

    public void setSgt(NodoCliente sgt) {
        this.sgt = sgt;
    }

    public NodoCliente getAnt() {
        return ant;
    }

    public void setAnt(NodoCliente ant) {
        this.ant = ant;
    }
    
    
    
    
}
