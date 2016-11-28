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
import java.util.Date;
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
    
    public String mirarCataleg() {
        return this._data.mostrarCataleg();
    }
    
    public String visualitzarTopCapitols(String userName) {
        return this._data.mostrarTopCap();
    }
    
    public boolean registrarUsuari(String userName,String password,String nom,String nacionalitat,Date dataNaixament) {
        return this._data.registrarUsuari(userName, password, nom, nacionalitat, dataNaixament); 
    }
    
    public String comprovarStatus(String userName, int numCap) {
        return this._data.getViewStatus(userName);
    }
    
    public void aturaCapitol(String userName) {
        this._data.finalitzarStreaming(userName);
    }
    
    public void valorarCapitol(String userName, int numCap, int nota) {
        this._data.valorarCapitol(userName, numCap, nota);
    }

    public String mostrarTemporada(int numTemp) {
        return this._data.mostrarTemporada(numTemp);
    }

    public String mostrarSerie(int numSerie) {
        return this._data.mostrarSerie(numSerie);
    }
    
    public String reprodueixCapitol(String userName, int numCap) {
        return this._data.iniciarStreaming(userName, numCap);
    }
    
    public int getCodi(int numCap){
        return this._data.getCataleg().getTopCapitols().getCapitols().get(numCap).getCodi()+1000000*numCap;
    }
    
}
