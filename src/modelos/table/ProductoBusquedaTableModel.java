/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.table;

import java.util.List;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;
import modelos.ProductoModel;

/**
 *
 * @author rarteaga
 */
public class ProductoBusquedaTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID","Producto","Categoria","Precio"};
    List<ProductoModel> listaproducto;
    public ProductoBusquedaTableModel( List<ProductoModel> listaproducto)
    {
        this.listaproducto=listaproducto;
    }
             
    @Override
    public int getRowCount() {
        return listaproducto.size();
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
       return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
         return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       ProductoModel producto=listaproducto.get(rowIndex);
       String sProductoLargo=producto.getNombre() + " / " + producto.getMarca() + " / " + producto.getModelo();
        switch (columnIndex) {
            case 0:
                return producto.getIdproducto();
            case 1:
                return sProductoLargo;
            case 2:
                return producto.getCategoria();
            case 3:
                return producto.getPrecio();                
            default:                
                return null;
        }       
    }
    
    public ProductoModel ObtenerByID(int sID)
    {
        Optional<ProductoModel> productoEncontrado = listaproducto.stream()
                .filter(producto -> producto.getIdproducto()==sID)
                .findFirst();

        // Verificar si el objeto fue encontrado
        if (productoEncontrado.isPresent()) {
            return productoEncontrado.get();
        } else {
            return null;
        }
    }         
}
