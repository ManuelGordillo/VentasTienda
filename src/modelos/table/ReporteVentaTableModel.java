/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.VentaModel;

/**
 *
 * @author rarteaga
 */
public class ReporteVentaTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID","DNI","Cliente","Fecha_Venta","Total"};
     List<VentaModel> listaventa;
    public ReporteVentaTableModel( List<VentaModel> listaventa)
    {
        this.listaventa=listaventa;
    } 
    
   @Override
    public int getRowCount() {
        return listaventa.size();
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
    
    public void Limpiar()
    {
        listaventa=new ArrayList<>();
        fireTableRowsUpdated(0, listaventa.size());
    }    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       VentaModel itemVenta=listaventa.get(rowIndex);
       String sCliente=itemVenta.getCliente().getNombres()+ " " + itemVenta.getCliente().getApellidos();
        switch (columnIndex) {
            case 0:
                return itemVenta.getIdventa();
            case 1:
                return itemVenta.getCliente().getDni();
            case 2:
                return sCliente;     
            case 3:
                return itemVenta.getFecha();                  
            case 4:
                return itemVenta.getTotal();             
            default:                
                return null;
        }       
    }  
}
