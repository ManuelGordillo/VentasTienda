
package cliente;


public class ListaCliente {
    private NodoCliente inicio , fin;

    public ListaCliente() {
    }

    public ListaCliente(NodoCliente inicio, NodoCliente fin) {
        inicio = fin = null;        
    }
    
    public boolean listaVacia(){
        return (inicio == null);
    }
    
//     public void agregarFin(Libro dato) {
//        System.out.println("Agregar fin:");
//        Nodo nuevo = new Nodo(dato);
//        if (esVacio()) {
//            inicio = nuevo;
//        } else {
//            fin.setSig(nuevo);
//            nuevo.setAnt(fin);
//        }
//        fin = nuevo;
//        fin.setSig(inicio);
//        inicio.setAnt(fin);
//    }
//
//    public void recorrer() {
//
//        if (esVacio()) {
//            System.out.println("La lista esta vacia.");
//            return;
//        }
//        Nodo aux = inicio;
//
//        do {
//            System.out.print(aux.getDato() + "-->");
//            aux = aux.getSig();
//        } while (aux != null);
//        System.out.println("");
//    }
//
//    public void recorrerAAdelante(DefaultTableModel tblModelo) {
//        tblModelo.setNumRows(0);
//
//        if (esVacio()) {
//            JOptionPane.showMessageDialog(null, "No hay elementos");
//
//            return;
//        }
//        Nodo aux = inicio;
//        do {
//            tblModelo.addRow(new Object[]{aux.getDato().getCodigo(), aux.getDato().getTitulo()});
//            aux = aux.getSig();
//        } while (aux != null);
//        System.out.println("");
//
//    }
//
//    public Nodo buscar(int codigo) {
//        Nodo nb = null;
//        if (esVacio()) {
//            JOptionPane.showMessageDialog(null, "No hay elementos");
//            return nb;
//        }
//        Nodo aux = inicio;
//
//        do {
//            if (aux.getDato().getCodigo() == codigo) {
//                return aux;
//            }
//            aux = aux.getSig();
//        } while (aux != null);
//        return nb;
//    }
//
//   
//    
}
