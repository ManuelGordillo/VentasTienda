/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author rarteaga
 */
public final class CorrelativoVenta {
    private static final AtomicLong CONTADOR = new AtomicLong();
    private CorrelativoVenta() { }
    
    public static int siguiente(){
        return (int) CONTADOR.incrementAndGet();
    }
}
