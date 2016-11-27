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
    
    public boolean registrarUsuari(String userName, String password, String nom, String nacionalitat, Date dataNaixament){
        if(!this.comprovarClient(userName)){
            Client c = new Client(userName, password, nom, nacionalitat, dataNaixament);
            this._llistaClients.add(c);
            return true;
        }else{
            return false;
        }
        
    }
    
    public String getViewStatus(String userName){
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
        return status.toString();
    }
    
    public String iniciarStreaming(String userName, int numCap){
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
        String cap = this._cataleg.mostrarCapitol(numCap);
        return cap;
        
    }
    
    public void finalitzarStreaming(String userName){
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
    
    public String mostrarCataleg(){
        return this._cataleg.toString();
    }
    
    public String mostrarSerie(int numSerie){
        return this._cataleg.mostrarSerie(numSerie);
    }
    
    public String mostrarTemporada(int numTemp){
        return this._cataleg.mostrarTemporada(numTemp);
    }
    /*
    public String getCapitol(int numCap){
        
    }
    */
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
    
    
    public void valorarCapitol(String userName, int numCap, int nota) {
        Valoracio v = new Valoracio(nota, new Date());
        Client c = null;
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        while (llistaClientsIterator.hasNext() && !found) {
            c = llistaClientsIterator.next();
            found = (c.getUsername()).equals(userName);
        }
        // Afegim valoracio al client que l'ha feta
        c.addValoracio(v);
        // Afegim valoracio al capitol seleccionat i actualitzem la seva nota
        Capitol cap = this._cataleg.getCapitol(numCap);
        cap.addValoracio(v);
        // Actualitzem el ranking de top capitols
        this._cataleg.actualitzarTopCap();
    }
    
}
