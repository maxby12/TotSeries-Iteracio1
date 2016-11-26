/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Albert
 */
public class TotSeriesDades {
    private ArrayList<Client> _llistaClients;
    private Cataleg _cataleg;
    private ArrayList<Administrador> _administradors;
    private Date _dataPagament;
    
    
    // Definim els possibles estats dels Clients
    protected enum View {
        EMISSIO, NOEMISSIO
    }
    
    
    public TotSeriesDades(Date _diaCobro) {
        this._llistaClients = new ArrayList<Client>();
        this._cataleg = new Cataleg();
        this._administradors = new ArrayList<Administrador>();
        this._dataPagament = _diaCobro;
        //hem de decidir com introduim la data
    }

    public ArrayList<Administrador> getAdministradors() {
        return _administradors;
    }

    public void setAdministradors(ArrayList<Administrador> _administradors) {
        this._administradors = _administradors;
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

    public Date getDataPagament() {
        return _dataPagament;
    }

    public void setDataPagament(Date _diaCobro) {
        this._dataPagament = _diaCobro;
    }
    
    public void addClient(String userName, String password, String nom, String nacionalitat, Date dataNaixament){
        Client c = new Client(userName, password, nom, nacionalitat, dataNaixament);
        this._llistaClients.add(c);
    }
    
    public View getViewStatus(String userName){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        View status = null;
        while (llistaClientsIterator.hasNext() && !found) {
            Client c = llistaClientsIterator.next();
            if (c.getUsername().equals(userName)) {
                status = c.getViewStatus();
                found = true;
            }
        }
        return status;
    }

    public void iniciarStreaming(String userName, int numCap){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        while (llistaClientsIterator.hasNext() && !found) {
            Client c = llistaClientsIterator.next();
            if (c.getUsername().equals(userName)) {
                c.setViewStatus(View.EMISSIO);
                c.incrementarFactura();
            }
        }
        // Inicia el streaming del capitol numero numCap
        
    }
    
    public void finalitzarStreaming(String userName, int numCap){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        while (llistaClientsIterator.hasNext() && !found) {
            Client c = llistaClientsIterator.next();
            if (c.getUsername().equals(userName)) {
                c.setViewStatus(View.NOEMISSIO);
            }
        }
        
        // Finalitza el streaming del capitol numero numCap
    }
    
    public void incrementarFactura(){
        
    }
    
    public String mostrarCataleg(){
        return this._cataleg.toString();
    }
    
    public String mostrarSerie(int numSerie){
        
    }
    
    public String mostrarTemporada(int numTemp){
        
    }
    
    public String getCapitol(int numCap){
        
    }
    
    public boolean comprovarClient(String userName){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        while (llistaClientsIterator.hasNext() && !found) {
            Client c = llistaClientsIterator.next();
            found = (c.getUsername()).equals(userName);
        }
        return found;
    }
    
    public String mostrarTopCap(){
        return this._cataleg.getTopCapitols().toString();
    }
    
}
