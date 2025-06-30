package cliente;

public class Nodo {

    private Cliente dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo() {
    }

    public Nodo(Cliente dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
}

