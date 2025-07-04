/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import estructuras.nodos.NodoVentaModel;
import java.util.ArrayList;
import java.util.List;
import modelos.VentaModel;

/**
 *
 * @author rarteaga
 */
public class LEVentas {
    private NodoVentaModel inicio, fin;
    private static LEVentas INTANCE;
    public LEVentas() {
        inicio = fin = null;
    }
    
    public static LEVentas getINTANCE()
    {
        if (INTANCE==null)
        {
            INTANCE=new LEVentas();           
        }
        return INTANCE;
    }    
    
    public boolean esVacio() {
        return inicio == null;
    }    
    
    public void agregarFin(VentaModel ventaModel) {
        NodoVentaModel nuevo = new NodoVentaModel(ventaModel);
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
    
    public VentaModel buscarById(int id) {
        if (esVacio()) {
            return null;
        }

        NodoVentaModel aux = inicio;
        do {
            if (aux.getDato().getIdventa()== id) {
                return aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != inicio);

        return null;
    }

    public List<VentaModel> recorrerRetornaListaFiltro(int idCliente, String sFechaVenta) {
        List<VentaModel> lista=new ArrayList<>();
        if (esVacio()) {
            return lista;
        }
        
        NodoVentaModel aux = inicio;
        do {
            VentaModel venta = aux.getDato();
            if (idCliente==0 && sFechaVenta.trim().length()==0)
            {
                lista.add(venta);
            }else
            {
                //Concatenamos la info de la tabla
                //Si contiene la palabra filtramos
                if (venta.getCliente().getIdCliente()==idCliente || venta.getFecha().equals(sFechaVenta)){
                    lista.add(venta);
                }
            }

            aux = aux.getSig();
        } while (aux != inicio);
        
        return lista;        
    }    
        
}
