/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import estructuras.nodos.NodoVentaDetalleModel;
import java.util.ArrayList;
import java.util.List;
import modelos.DetalleVentaModel;
import modelos.VentaModel;

/**
 *
 * @author rarteaga
 */
public class LEVentaDetalle {
    private NodoVentaDetalleModel inicio, fin;
        
    public LEVentaDetalle() {
        inicio = fin = null;
    }
    
    public boolean esVacio() {
        return inicio == null;
    }    
    
    public void agregarFin(DetalleVentaModel detalleVenta) {
        NodoVentaDetalleModel nuevo = new NodoVentaDetalleModel(detalleVenta);
        if (esVacio()) {
            inicio = nuevo;
        } else {
            fin.setSig(nuevo);
            nuevo.setAnt(fin);
        }
        fin = nuevo;
        fin.setSig(inicio);
        inicio.setAnt(fin);
    }
    
    public int Tamano() {
        int contador=0;
        if (esVacio()) {
            return 0;
        }

        NodoVentaDetalleModel aux = inicio;
        do {
            contador++;
            aux = aux.getSig();
        } while (aux != inicio);
        
        return contador;
    } 
    
    public NodoVentaDetalleModel buscar(int iddetalle) {
        if (esVacio()) {
            return null;
        }

        NodoVentaDetalleModel aux = inicio;
        do {
            if (aux.getDato().getIddetalle() == iddetalle) {
                return aux;
            }
            aux = aux.getSig();
        } while (aux != inicio);

        return null;
    }

    public List<DetalleVentaModel> recorrerRetornaLista() {
        List<DetalleVentaModel> lista=new ArrayList<>();
        if (esVacio()) {
            return lista;
        }
        
        NodoVentaDetalleModel aux = inicio;
        do {
            DetalleVentaModel prd = aux.getDato();
            lista.add(prd);
            aux = aux.getSig();
        } while (aux != inicio);
        
        return lista;        
    }    
    
    public boolean eliminar(int idventadetalle) {
        if (esVacio()) {
            return false;
        }

        NodoVentaDetalleModel aux = inicio;
        do {
            if (aux.getDato().getIddetalle()== idventadetalle) {
                if (aux == inicio && aux == fin) {
                    // Solo hay un nodo
                    inicio = fin = null;
                } else {
                    if (aux == inicio) {
                        inicio = inicio.getSig();
                    }
                    if (aux == fin) {
                        fin = fin.getAnt();
                    }
                    aux.getAnt().setSig(aux.getSig());
                    aux.getSig().setAnt(aux.getAnt());
                }
                return true;
            }
            aux = aux.getSig();
        } while (aux != inicio);

        return false;
    }
}
