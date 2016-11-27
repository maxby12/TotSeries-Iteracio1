/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Administrador;
import Model.Cataleg;
import Model.Client;
import Model.TotSeriesDades;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

/**
 *
 * @author Albert
 */
public class TotSeries {
    
    private TotSeriesDades _data;
    
    
    public TotSeries(TotSeriesDades data, String rutaXML) {
        this._data = data;
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades(rutaXML);
        ArrayList<Client> clients = dataManager.getLlistaClients();
        ArrayList<Administrador> admins = dataManager.getAdministradors();
        Cataleg c = dataManager.getCataleg();
        this._data.setCataleg(c);
        this._data.setAdministradors(admins);
        this._data.setLlistaClients(clients);
        
    }
    
    // METODES DE CASSOS D'US
    
    public String mirarCataleg(String userName) {
        return this._data.mostrarCataleg();
    }
    
    public void visualitzarTopCapitols(String userName) {
        
    }
    
    public void registrarUsuari() {
        
    }
    
    public void reproduirCapitol(String userName, int numCap) {
        
    }
    
    public void aturaCapitol(String userName, int numCap) {
        
    }
    
    public void valorarCapitol(String userName, int numCap) {
        
    }

    public String mostrarTemporada(int numTemp) {
        return this._data.mostrarTemporada(numTemp);
    }

    public String mostrarSerie(int numSerie) {
        return this._data.mostrarSerie(numSerie);
    }
    
}
