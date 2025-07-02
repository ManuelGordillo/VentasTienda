/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.nodos;

import modelos.ProductoModel;

/**
 *
 * @author rarteaga
 */
public class NodoProductoModel {
    private ProductoModel dato;
    private NodoProductoModel sig;
    private NodoProductoModel ant;
    
    public NodoProductoModel() {
    }
    
    public NodoProductoModel(ProductoModel dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
    
    public ProductoModel getDato() {
        return dato;
    }

    public void setDato(ProductoModel dato) {
        this.dato = dato;
    }

    public NodoProductoModel getSig() {
        return sig;
    }

    public void setSig(NodoProductoModel sig) {
        this.sig = sig;
    }

    public NodoProductoModel getAnt() {
        return ant;
    }

    public void setAnt(NodoProductoModel ant) {
        this.ant = ant;
    }       
    
}
