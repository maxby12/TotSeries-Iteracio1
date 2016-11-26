/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Raül
 */
public class ClientVIP extends Client {

    public ClientVIP(String userName, String password, String nom, String nacionalitat, Date dataNaixament) {
        super(userName, password, nom, nacionalitat, dataNaixament);
    }
    
     @Override
    public String toString() {
        return "ClientVIP{" + '}';
    }
    
    @Override
    public void incrementarFactura(){
        this._factura.incrementar(0.9f);
    }
    
}


