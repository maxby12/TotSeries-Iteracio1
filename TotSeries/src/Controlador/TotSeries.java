/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Client;
import Model.TotSeriesDades;
import java.util.Timer;

/**
 *
 * @author Albert
 */
public class TotSeries {
    
    private TotSeriesDades _data;
    private Timer timer;
    
    
    public TotSeries(TotSeriesDades data, String rutaXML) {
        this.timer = new Timer();
        this._data = data;
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades(rutaXML);
    }
    
    // METODES DE CASSOS D'US
    
    public void mirarCataleg(String userName) {
        
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
    
}
