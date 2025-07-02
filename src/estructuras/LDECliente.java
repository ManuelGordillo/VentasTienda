package estructuras;

import modelos.ClienteModel;
import estructuras.nodos.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LDECliente {

    private Nodo inicio, fin;
    private static LDECliente INTANCE;    

    public static LDECliente getINTANCE()
    {
        if (INTANCE==null)
        {
            INTANCE=new LDECliente();           
        }
        return INTANCE;
    }    
    
    public LDECliente() {
        inicio = fin = null;
    }

    public boolean esVacio() {
        return inicio == null;
    }

    public void agregarFin(ClienteModel cliente) {
        Nodo nuevo = new Nodo(cliente);
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

    public void recorrerAdelante(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar tabla

        if (esVacio()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }

        Nodo aux = inicio;
        do {
            ClienteModel c = aux.getDato();
            modelo.addRow(new Object[]{
                c.getIdCliente(),
                c.getNombres(),
                c.getApellidos(),
                c.getDni(),
                c.getCorreo(),
                c.getTelefono()
            });
            aux = aux.getSig();
        } while (aux != inicio);
    }
    
    public int obtenerUltimoId() {
    if (esVacio()) return 0;
    return fin.getDato().getIdCliente();
}

    public Nodo buscar(int idCliente) {
        if (esVacio()) {
            return null;
        }

        Nodo aux = inicio;
        do {
            if (aux.getDato().getIdCliente() == idCliente) {
                return aux;
            }
            aux = aux.getSig();
        } while (aux != inicio);

        return null;
    }

    public boolean actualizar(ClienteModel clienteActualizado) {
        Nodo nodoEncontrado = buscar(clienteActualizado.getIdCliente());
        if (nodoEncontrado != null) {
            nodoEncontrado.setDato(clienteActualizado);
            return true;
        }
        return false;
    }

    public boolean eliminar(int idCliente) {
        if (esVacio()) {
            return false;
        }

        Nodo aux = inicio;
        do {
            if (aux.getDato().getIdCliente() == idCliente) {
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
    
    
    public List<ClienteModel> recorrerRetornaListaFiltro(String sFiltro) {
        List<ClienteModel> lista=new ArrayList<>();
        if (esVacio()) {
            return lista;
        }
        
        Nodo aux = inicio;
        do {
            ClienteModel cli = aux.getDato();
            if (sFiltro.trim().length()==0)
            {
                lista.add(cli);
            }else
            {
                //Concatenamos la info de la tabla
                String sCliente=cli.getNombres() + " " + cli.getApellidos();
                //Si contiene la palabra filtramos
                if (sCliente.toLowerCase().contains(sFiltro.toLowerCase())){
                    lista.add(cli);
                }
            }

            aux = aux.getSig();
        } while (aux != inicio);
        
        return lista;        
    } 

    public ClienteModel buscarById(int id) {
        if (esVacio()) {
            return null;
        }

        Nodo aux = inicio;
        do {
            if (aux.getDato().getIdCliente()== id) {
                return aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != inicio);

        return null;
    } 
    
}
