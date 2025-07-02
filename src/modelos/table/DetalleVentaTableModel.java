/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.table;

import modelos.DetalleVentaModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rarteaga
 */
public class DetalleVentaTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Item","Producto","Cantidad","Precio","Total"};
    List<DetalleVentaModel> listadetalle;
    public DetalleVentaTableModel( List<DetalleVentaModel> listadetalle)
    {
        this.listadetalle=listadetalle;
    }
    
    @Override
    public int getRowCount() {
        return listadetalle.size();
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
        return super.isCellEditable(rowIndex, columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    public void addItem(DetalleVentaModel item)
    {
        listadetalle.add(item);
        fireTableRowsInserted(listadetalle.size() - 1, listadetalle.size() - 1);
    }
    
    public void removeItem(int rowIndex)
    {
        listadetalle.remove(rowIndex);        
        fireTableRowsDeleted(rowIndex, rowIndex);
    }  

    public void Limpiar()
    {
        listadetalle=new ArrayList<>();
        fireTableRowsUpdated(0, listadetalle.size());
    }
    
    public List<DetalleVentaModel> Lista()
    {
        return listadetalle;
    }    
    
    public void actualizarNroItems()
    {
        for (int i = 0; i < listadetalle.size(); i++) {
            listadetalle.get(i).setItem(i+1);
        }
         fireTableRowsUpdated(0, listadetalle.size()-1);
    }
    
    
    
    public double getTotal()
    {
        double nTotal = listadetalle.stream()
                         .mapToDouble(DetalleVentaModel::getTotal) // Mapear las edades
                         .sum(); // Sumar todas las edades
        
        return nTotal;
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleVentaModel detalle=listadetalle.get(rowIndex);
        String sProducto=detalle.getProducto().getNombre() + " / " + 
                        detalle.getProducto().getMarca() + " / " +
                        detalle.getProducto().getModelo();
        switch(columnIndex)
        {
            case 0:
                return detalle.getItem();
            case 1:
                return sProducto;
            case 2:
                return detalle.getCantidad();
            case 3:
                return detalle.getPrecio();
            case 4:
                return detalle.getTotal();
            default:
               return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


    
}
