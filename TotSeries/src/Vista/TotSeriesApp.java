/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.TotSeries;
import Model.TotSeriesDades;
import java.util.Date;

/**
 *
 * @author Albert
 */
public class TotSeriesApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creem data actual i calculem el mes següent, serà la data de pagament
        Date dataPagament = new Date();
        dataPagament.setMonth(dataPagament.getMonth()+1);
        
        // Creem el Model amb la data de pagament
        TotSeriesDades data = new TotSeriesDades(dataPagament);
        // Creem el Controlador amb el Model
        TotSeries ctrl = new TotSeries(data);
        // Creem la Vista amb el Controlador
        Menu vista = new Menu(ctrl);
        
        // EXECUTEM APLICACIÓ PRINCIPAL (MAIN MENU)
        vista.show();
    }
    
}
