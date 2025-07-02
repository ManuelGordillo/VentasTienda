/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import estructuras.nodos.NodoProductoModel;
import java.util.ArrayList;
import java.util.List;
import modelos.ProductoModel;

/**
 *
 * @author rarteaga
 */
public class LEProducto {
    
    private static LEProducto INTANCE;
    
    private NodoProductoModel inicio, fin;
    
    public static LEProducto getINTANCE()
    {
        if (INTANCE==null)
        {
            INTANCE=new LEProducto();           
        }
        return INTANCE;
    }
    
    public LEProducto() {
        inicio = fin = null;
    }
    
    public boolean esVacio() {
        return inicio == null;
    }    
    
    public void agregarFin(ProductoModel productoModel) {
        NodoProductoModel nuevo = new NodoProductoModel(productoModel);
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
    
    public void recorrerAdelante() {
        if (esVacio()) {
            return;
        }
        
        NodoProductoModel aux = inicio;
        do {
            ProductoModel prd = aux.getDato();
            aux = aux.getSig();
        } while (aux != inicio);
    }
    
    public List<ProductoModel> recorrerRetornaLista() {
        List<ProductoModel> lista=new ArrayList<>();
        if (esVacio()) {
            return lista;
        }
        
        NodoProductoModel aux = inicio;
        do {
            ProductoModel prd = aux.getDato();
            lista.add(prd);
            aux = aux.getSig();
        } while (aux != inicio);
        
        return lista;        
    }

    public List<ProductoModel> recorrerRetornaListaFiltro(String sFiltro) {
        List<ProductoModel> lista=new ArrayList<>();
        if (esVacio()) {
            return lista;
        }
        
        NodoProductoModel aux = inicio;
        do {
            ProductoModel prd = aux.getDato();
            if (sFiltro.trim().length()==0)
            {
                lista.add(prd);
            }else
            {
                //Concatenamos la info de la tabla
                String sProductoLargo=prd.getNombre() + " / " + prd.getMarca() + " / " + prd.getModelo();
                //Si contiene la palabra filtramos
                if (sProductoLargo.toLowerCase().contains(sFiltro.toLowerCase())){
                    lista.add(prd);
                }
            }

            aux = aux.getSig();
        } while (aux != inicio);
        
        return lista;        
    }  
    
    public ProductoModel buscarById(int id) {
        if (esVacio()) {
            return null;
        }

        NodoProductoModel aux = inicio;
        do {
            if (aux.getDato().getIdproducto()== id) {
                return aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != inicio);

        return null;
    }    
    
}
