/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.TotSeriesDades.View;
import java.util.Date;

/**
 *
 * @author Raül
 */
public class Client {
    private String _nom;
    private String _username;
    private String _password;
    private String _nacionalitat;
    private Date _dataNaixament;
    private View _viewStatus;
    Factura _factura;
    
    
    public Client(String userName, String password, String nom, String nacionalitat, Date dataNaixament) {
        this._nom = nom;
        this._username = userName;
        this._password = password;
        this._nacionalitat = nacionalitat;
        this._dataNaixament = dataNaixament;
        this._viewStatus = View.NOEMISSIO;
        this._factura = new Factura(0.0f);
    }
    
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
        return "Client{" + "_nom=" + _nom + ", _username=" + _username + ", _nacionalitat=" + _nacionalitat + ", _dataNaixament=" + _dataNaixament + ", _viewStatus=" + _viewStatus + ", _factura=" + _factura + '}';
    }
    
    public void incrementarFactura(){
        this._factura.incrementar(1f);
    }
    
    public View getViewStatus() {
        return _viewStatus;
    }

    public void setViewStatus(View _viewStatus) {
        this._viewStatus = _viewStatus;
    }

    public Date getDataNaixament() {
        return _dataNaixament;
    }

    public void setDataNaixament(Date _dataNaixament) {
        this._dataNaixament = _dataNaixament;
    }

    public Factura getFactura() {
        return _factura;
    }

    public void setFactura(Factura _factura) {
        this._factura = _factura;
    }
    
    
    
}
