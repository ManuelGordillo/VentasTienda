/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import modelos.DetalleVentaModel;
import java.util.List;

/**
 *
 * @author rarteaga
 */
public class VentaModel {

    private int idventa;
    private ClienteModel cliente;
    private String fecha;
    private double total;
    private int idusuario;
    private  List<DetalleVentaModel> detalle;    
    
    /**
     * @return the cliente
     */
    public ClienteModel getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
    
    /**
     * @return the idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * @param idventa the idventa to set
     */
    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    /**
     * @return the detalle
     */
    public List<DetalleVentaModel> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(List<DetalleVentaModel> detalle) {
        this.detalle = detalle;
    }    
}
