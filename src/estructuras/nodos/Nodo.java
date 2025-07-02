package estructuras.nodos;

import modelos.ClienteModel;

public class Nodo {

    private ClienteModel dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo() {
    }

    public Nodo(ClienteModel dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }

    public ClienteModel getDato() {
        return dato;
    }

    public void setDato(ClienteModel dato) {
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

