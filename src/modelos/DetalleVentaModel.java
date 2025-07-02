/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author rarteaga
 */
public class DetalleVentaModel {

    private int iddetalle;
    private int item;
    private ProductoModel producto;
    private double cantidad;
    private double precio;    
    private double total;  
    
    /**
     * @return the producto
     */
    public ProductoModel getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }     
    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    } 
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * @return the iddetalle
     */
    public int getIddetalle() {
        return iddetalle;
    }

    /**
     * @param iddetalle the iddetalle to set
     */
    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }
    
    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return cantidad * precio;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
