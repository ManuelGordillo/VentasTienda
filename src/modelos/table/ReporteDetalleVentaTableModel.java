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
public class ReporteDetalleVentaTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Item","Producto","Cantidad","Precio","Total"};
    List<DetalleVentaModel> listadetalle;
    public ReporteDetalleVentaTableModel( List<DetalleVentaModel> listadetalle)
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
    
    
    public double getTotal()
    {
        double nTotal = listadetalle.stream()
                         .mapToDouble(DetalleVentaModel::getTotal) // Mapear las edades
                         .sum(); // Sumar todas las edades
        
        return nTotal;
    }    
    
    public double getNroArticulos()
    {
        double nTotal = listadetalle.size();        
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

}
