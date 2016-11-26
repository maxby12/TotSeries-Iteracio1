/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Albert
 */
public class TotSeriesDades {
    private ArrayList<ClientVIP> _llistaClientsVIP;
    private ArrayList<Client> _llistaClients;
    private Cataleg _cataleg;
    private Administrador _admin;
    private Date _dataPagament;

    public TotSeriesDades(Date _diaCobro) {
        this._llistaClientsVIP = new ArrayList<ClientVIP>() ;
        this._llistaClients = new ArrayList<Client>();
        this._cataleg = new Cataleg();
        this._admin = new Administrador();
        this._dataPagament = _diaCobro;
        //hem de decidir com introduim la data
    }
    
    

    public ArrayList<ClientVIP> getLlistaClientsVIP() {
        return _llistaClientsVIP;
    }

    public void setLlistaClientsVIP(ArrayList<ClientVIP> _llistaClientsVIP) {
        this._llistaClientsVIP = _llistaClientsVIP;
    }

    public ArrayList<Client> getLlistaClients() {
        return _llistaClients;
    }

    public void setLlistaClients(ArrayList<Client> _llistaClients) {
        this._llistaClients = _llistaClients;
    }

    public Cataleg getCataleg() {
        return _cataleg;
    }

    public void setCataleg(Cataleg _cataleg) {
        this._cataleg = _cataleg;
    }

    public Administrador getAdmin() {
        return _admin;
    }

    public void setAdmin(Administrador _admin) {
        this._admin = _admin;
    }

    public Data getDiaCobro() {
        return _diaCobro;
    }

    public void setDiaCobro(Data _diaCobro) {
        this._diaCobro = _diaCobro;
    }
    
    public void addClient(){
        
    }
    
    public boolean getViewStatus(){
        
    }
    
    public boolean comprovarDuplicat(){
        
    }
    
    public void setViewStatus(){
    
    }
    
    public void iniciarStreaming(){
        
    }
    
    public void finalitzarStreaming(){
        
    }
    
    public void incrementarFactura(){
        
    }
    
    public String mostrarCataleg(){
        
    }
    
    public String mostrarSerie(){
        
    }
    
    public String mostrarTemporada(){
        
    }
    
    public boolean comprovarClient(){
        
    }
    
    public Capitol getCapitol(){
        
    }
    
    public String topCap(){
        
    }
    
}
