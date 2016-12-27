/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.ClientObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import Vista.SeriesObserver;
import Vista.TopValObserver;
import Vista.TopVistosObserver;

/**
 *
 * @author Albert
 */
public class TotSeriesDades implements TotSeriesModelInterface {
    private ArrayList<Client> _llistaClients;
    private Cataleg _cataleg;
    private ArrayList<Administrador> _administradors;
    private Date _dataPagament;
    private String _client;
    private ArrayList<ClientObserver> _clientObservers = new ArrayList<ClientObserver>();
    private ArrayList<SeriesObserver> _seriesObservers = new ArrayList<SeriesObserver>();

    

    // Definim els possibles estats dels Clients
    protected enum View {
        EMISSIO, NOEMISSIO
    }
    
    
    public TotSeriesDades(Date _diaCobro) {
        this._dataPagament = _diaCobro;
        this._client = "";
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
    
    public void afegirVisualitzacio(int codi){
        this._cataleg.afegirVisualitzacio(codi);
        this._cataleg.actualitzarTopVistos();
    }
    
    public void registrarUsuari(String userName, String password, String nom, String nacionalitat, Date dataNaixament){
        if(!this.comprovarClient(userName)){
            Client c = new Client(userName, password, nom, nacionalitat, dataNaixament);
            this._llistaClients.add(c);
            JOptionPane.showMessageDialog(null,
            "Usuari registrat correctament.");
        }else{
            JOptionPane.showMessageDialog(null,
            "Nom d'usuari ja registrat.\nProcés cancel·lat.",
            "Procés cancel·lat",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void logIn(String userName, String password){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        Client c = null;
        Administrador a = null;
        boolean foundC = false;
        boolean foundA = false;
        while (llistaClientsIterator.hasNext() && !foundC) {
            c = llistaClientsIterator.next();
            foundC = (c.getUsername()).equals(userName) ;
        }
        if (!foundC) {
            Iterator<Administrador> llistaAdminsIterator = _administradors.iterator();
            while (llistaAdminsIterator.hasNext() && !foundA) {
                a = llistaAdminsIterator.next();
                foundA = (a.getUserName()).equals(userName);
            }
        }
        
        if (foundC) {
            if (c.checkPassword(password)) {
                this._client = userName;
                this.notifyClientObservers();
            }
            else {
                JOptionPane.showMessageDialog(null,
                "Contrasenya erronea",
                "Procés Cancel·lat",
                JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            if (foundA) {
                if (a.checkPassword(password)) {
                    this._client = userName;
                    this.notifyClientObservers();
                }
                else {
                    JOptionPane.showMessageDialog(null,
                    "Contrasenya erronea",
                    "Procés Cancel·lat",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                "Nom d'usuari no registrat",
                "Procés Cancel·lat",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void logOut() {
        this._client = "";
    }
    
    public boolean getViewStatus(String userName){
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
        return status.equals(View.NOEMISSIO);
    }
    
    public void iniciarStreaming(String userName){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        while (llistaClientsIterator.hasNext() && !found) {
            Client c = llistaClientsIterator.next();
            if (c.getUsername().equals(userName)) {
                c.setViewStatus(View.EMISSIO);
                c.incrementarFactura();
            }
        }
        
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
    
    @Override
    public boolean isAdmin(String userName) {
        Iterator<Administrador> llistaAdmins = _administradors.iterator();
        boolean found = false;
        while (llistaAdmins.hasNext() && !found) {
            Administrador a = llistaAdmins.next();
            found = a.getUserName().equals(userName);
        }
        return found;
    }
    
    @Override
    public ArrayList<String> infoSerie(int numS){
        return this._cataleg.infoSerie(numS);
    }
    
    @Override
    public ArrayList<String> infoCapitol(int numC) {
        return this._cataleg.infoCapitol(numC);
    }
    
    @Override
    public ArrayList<String> mostrarTemporada(int numTemp){
        return this._cataleg.mostrarTemporada(numTemp);
    }
    
    @Override
    public ArrayList<String> mostrarValorats(){
        return this._cataleg.mostrarValorats();
    }
    
    @Override
    public ArrayList<String> mostrarVistos() {
        return this._cataleg.mostrarVistos();
    }
    /*
    public String getCapitol(int numCap){
        
    }
    */
    private boolean comprovarClient(String userName){
        Iterator<Client> llistaClientsIterator = _llistaClients.iterator();
        boolean found = false;
        while (llistaClientsIterator.hasNext() && !found) {
            Client c = llistaClientsIterator.next();
            found = (c.getUsername()).equals(userName);
        }
        return found;
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
    
    @Override
    public int getNumTemp(int numS) {
        return this._cataleg.getNumTemp(numS);
    }
    
    @Override
    public ArrayList<String> mostrarSeries() {
        return this._cataleg.mostrarSeries();
    }
    
    @Override
    public String getClient() {
        return this._client;
    }
    
    @Override
    public void registerClientObserver(ClientObserver o) {
        this._clientObservers.add(o);
    }

    @Override
    public void removeClientObserver(ClientObserver o) {
        int i = _clientObservers.indexOf(o);
        if (i >= 0) {
                _clientObservers.remove(i);
        }
    }
    
    @Override
    public void notifyClientObservers() {
            for(int i = 0; i < _clientObservers.size(); i++) {
                    ClientObserver observer = _clientObservers.get(i);
                    observer.updateClient();
            }
    }
    
    @Override
    public void registerSeriesObserver(SeriesObserver o) {
        this._seriesObservers.add(o);
    }

    @Override
    public void removeSeriesObserver(SeriesObserver o) {
        int i = _seriesObservers.indexOf(o);
        if (i >= 0) {
                _seriesObservers.remove(i);
        }
    }
    
    @Override
    public void notifySeriesObservers() {
            for(int i = 0; i < _seriesObservers.size(); i++) {
                    SeriesObserver observer = _seriesObservers.get(i);
                    observer.updateSeries();
            }
    }
    
    @Override
    public void registerTopValObserver(TopValObserver o) {
        this._cataleg.registerTopValObserver(o);
    }
    
    
    @Override
    public void removeTopValObserver(TopValObserver o) {
        this._cataleg.removeTopValObserver(o);
        
    }
    
     @Override
    public void registerTopVistosObserver(TopVistosObserver o) {
         this._cataleg.registerTopVistosObserver(o);
    }

    @Override
    public void removeTopVistosObserver(TopVistosObserver o) {
        this._cataleg.removeTopVistosObserver(o);
    }
    
}
