/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.nodos;

import modelos.VentaModel;

/**
 *
 * @author rarteaga
 */
public class NodoVentaModel {
   private VentaModel dato;
    private NodoVentaModel sig;
    private NodoVentaModel ant;
    
    public NodoVentaModel() {
    }
    
    public NodoVentaModel(VentaModel dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
    
    public VentaModel getDato() {
        return dato;
    }

    public void setDato(VentaModel dato) {
        this.dato = dato;
    }

    public NodoVentaModel getSig() {
        return sig;
    }

    public void setSig(NodoVentaModel sig) {
        this.sig = sig;
    }

    public NodoVentaModel getAnt() {
        return ant;
    }

    public void setAnt(NodoVentaModel ant) {
        this.ant = ant;
    }     
}
