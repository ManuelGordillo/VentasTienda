/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.nodos;

import modelos.DetalleVentaModel;

/**
 *
 * @author rarteaga
 */
public class NodoVentaDetalleModel {
    private DetalleVentaModel dato;
    private NodoVentaDetalleModel sig;
    private NodoVentaDetalleModel ant;
    
    public NodoVentaDetalleModel() {
    }
    
    public NodoVentaDetalleModel(DetalleVentaModel dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
    
    public DetalleVentaModel getDato() {
        return dato;
    }

    public void setDato(DetalleVentaModel dato) {
        this.dato = dato;
    }

    public NodoVentaDetalleModel getSig() {
        return sig;
    }

    public void setSig(NodoVentaDetalleModel sig) {
        this.sig = sig;
    }

    public NodoVentaDetalleModel getAnt() {
        return ant;
    }

    public void setAnt(NodoVentaDetalleModel ant) {
        this.ant = ant;
    }    
}
