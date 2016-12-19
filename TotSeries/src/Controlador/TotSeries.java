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
import Vista.MenuInicial;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Albert
 */
public class TotSeries {
    
    private static TotSeries _ctrl;
    private TotSeriesDades _data;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        final TotSeries controlador = TotSeries.getInstance();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuInicial main = new MenuInicial(controlador, controlador._data);
                main.setVisible(true);
            }
        });
    }
    
    private TotSeries() {
        // Creem data actual i calculem el mes següent, serà la data de pagament
        Date dataPagament = new Date();
        dataPagament.setMonth(dataPagament.getMonth()+1);
        // Creem el Model amb la data de pagament
        this._data = new TotSeriesDades(dataPagament);
        
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        ArrayList<Client> clients = dataManager.getLlistaClients();
        ArrayList<Administrador> admins = dataManager.getAdministradors();
        Cataleg c = dataManager.getCataleg();
        this._data.setCataleg(c);
        this._data.setAdministradors(admins);
        this._data.setLlistaClients(clients);
    }
    
    public static TotSeries getInstance() {
        if (_ctrl == null)
            synchronized(TotSeries.class) {
                if (_ctrl== null)
                    _ctrl = new TotSeries();
            }
        return _ctrl; 
    }
    
    // METODES DE CASSOS D'US
    
    public void logIn(String userName, String password){
        this._data.logIn(userName, password);
    }
    
    public void logOut() {
        this._data.logOut();
    }
    
    public void registrarUsuari(String userName,String password,String nom,String nacionalitat,String dia, String mes, String any) {
        this._data.registrarUsuari(userName, password, nom, nacionalitat, new Date(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(any))); 
    }
    
    public boolean comprovarStatus(String userName) {
        return this._data.getViewStatus(userName);
    }
    
    public void aturaCapitol(String userName) {
        this._data.finalitzarStreaming(userName);
    }
    
    public void valorarCapitol(String userName, int numCap, int nota) {
        this._data.valorarCapitol(userName, numCap, nota);
    }
    
    public void afegirVisualitzacio(int numCap) {
        this._data.afegirVisualitzacio(numCap);
    }
    
    public void reprodueixCapitol(String userName) {
        this._data.iniciarStreaming(userName);
    }
    
    public int getCodi(int numCap){
        return this._data.getCataleg().getTopCapitols().getCapitols().get(numCap).getCodi();
    }
    
    public int getCodi(String nomCap) {
        return this._data.getCataleg().getCodi(nomCap);
    }
    
    public boolean isAdmin(String userName) {
        return _data.isAdmin(userName);
    }
    
}
