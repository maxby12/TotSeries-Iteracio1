/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.ClientObserver;
import Vista.SeriesObserver;
import java.util.ArrayList;

/**
 *
 * @author Albert
 */
public interface TotSeriesModelInterface {
    
    String getClient();
    void registerClientObserver(ClientObserver o);
    void removeClientObserver(ClientObserver o);
    void notifyClientObservers();
    
    ArrayList<String> getSeries();
    void registerSeriesObserver(SeriesObserver o);
    void removeSeriesObserver(SeriesObserver o);
    void notifySeriesObservers();
    
}
