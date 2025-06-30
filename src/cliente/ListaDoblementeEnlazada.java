package cliente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaDoblementeEnlazada {

    private Nodo inicio, fin;

    public ListaDoblementeEnlazada() {
        inicio = fin = null;
    }

    public boolean esVacio() {
        return inicio == null;
    }

    public void agregarFin(Cliente cliente) {
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
            Cliente c = aux.getDato();
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

    public boolean actualizar(Cliente clienteActualizado) {
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
}
