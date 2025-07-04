
import estructuras.LDECliente;
import estructuras.LEProducto;
import estructuras.LEVentas;
import formularios.FrmRegistroVenta;
import formularios.Login;
import formularios.Principal;
import modelos.ClienteModel;
import modelos.DetalleVentaModel;
import modelos.ProductoModel;
import modelos.VentaModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rarteaga
 */
public class ApplicationIni {
    public static void main(String[] args)
    {
        //Cargamos Data Prueba
        LEProducto leproducto=LEProducto.getINTANCE();        
        leproducto.agregarFin(new ProductoModel(1, "MONITOR 26 PULG", "MONITOR", "LG", "LG A", 50, 100));
        leproducto.agregarFin(new ProductoModel(2, "MOUSE INALAMBRICO", "MOUSES", "GENIUS", "205", 30, 100));
        leproducto.agregarFin(new ProductoModel(3, "CASE GAMMER", "CASES", "GENIUS", "CA", 20, 100));
        leproducto.agregarFin(new ProductoModel(4, "CABLE USB TIPO C", "CABLES", "SEGATE", "A25", 20, 100));
        leproducto.agregarFin(new ProductoModel(5, "MEMORIA EXTERNA 4GB", "MEMORIAS", "KINGSTON", "286A", 20, 100));
        
        //Carga Data Prueba
        LDECliente lecliente=LDECliente.getINTANCE();
        lecliente.agregarFin(new ClienteModel(1, "JUAN", "PEREZ PEREZ", "11111111", "micorreo1@demo.pe", "956856523"));
        lecliente.agregarFin(new ClienteModel(2, "PEDRO", "BACA TOLEDO", "22222222", "micorreo2@demo.pe", "987456321"));
        lecliente.agregarFin(new ClienteModel(3, "LUIS ALBERTO", "TRUMP TASAYCO", "33333333", "micorreo3@demo.pe", "963258741"));
        
        //Carga de Data de Prueba
        /*
        LEVentas leventas=LEVentas.getINTANCE();
        VentaModel v1=new VentaModel();        
        DetalleVentaModel item1=new DetalleVentaModel();
        item1.setCantidad(1);
        item1.setPrecio(50);
        item1.setTotal(50);
        item1.setProducto(new ProductoModel(1, "MONITOR 26 PULG", "MONITOR", "LG", "LG A", 50, 100));        
        
        v1.setCliente(new ClienteModel(1, "JUAN", "PEREZ PEREZ", "11111111", "micorreo1@demo.pe", "956856523"));
        v1.setFecha("2025-07-03");
        v1.setTotal(50);
        */

        
        
        
                
        
        
        
        //FrmRegistroVenta frmVenta=new FrmRegistroVenta();
        //frmVenta.setVisible(true);
        
        //Login frm=new Login();
        //frm.setVisible(true);
        
        // frm=new FrmBusquedaProductos();
        //frm.setVisible(true);
        
        Principal ventana = new Principal(); 
        ventana.setVisible(true);        
        
    }
}
