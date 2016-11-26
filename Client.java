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
public class Client {
    private String _nom;
    private String _username;
    private String _password;
    private String _nacionalitat;
    private boolean _viewStatus; 
    private Factura _factura;
    

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getNacionalitat() {
        return _nacionalitat;
    }

    public void setNacionalitat(String _nacionalitat) {
        this._nacionalitat = _nacionalitat;
    }
   
    @Override
    public String toString() {
        return "Client{" + "_nom=" + _nom + ", _username=" + _username + ", _password=" + _password + ", _nacionalitat=" + _nacionalitat + '}';
    }
    
    public void incrementarFactura(){
        this._factura.incrementar();
    }
    
    public boolean getViewStatus() {
        return _viewStatus;
    }

    public void setViewStatus(boolean _viewStatus) {
        this._viewStatus = _viewStatus;
    }
}