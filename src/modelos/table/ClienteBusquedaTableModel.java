/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.ClienteModel;

/**
 *
 * @author rarteaga
 */
public class ClienteBusquedaTableModel extends AbstractTableModel {
     private final String[] columnNames = {"ID","DNI","Cliente"};
     List<ClienteModel> listacliente;
    public ClienteBusquedaTableModel( List<ClienteModel> listacliente)
    {
        this.listacliente=listacliente;
    }  
    
   @Override
    public int getRowCount() {
        return listacliente.size();
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
       ClienteModel cliente=listacliente.get(rowIndex);
       String sCliente=cliente.getNombres()+ " " + cliente.getApellidos();
        switch (columnIndex) {
            case 0:
                return cliente.getIdCliente();
            case 1:
                return cliente.getDni();
            case 2:
                return sCliente;             
            default:                
                return null;
        }       
    }    
    
}
