/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Raül
 */
public class ClientVIP extends Client {

    public ClientVIP() {
    }
    
     @Override
    public String toString() {
        return "ClientVIP{" + '}';
    }
    
    @Override
    public void incrementarFactura(){
        this._factura.incrementarVIP();
    }
    
}


