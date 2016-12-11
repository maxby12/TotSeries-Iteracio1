/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.ClientObserver;

/**
 *
 * @author Albert
 */
public interface TotSeriesModelInterface {
    
    String getClient();
    void registerObserver(ClientObserver o);
    void removeObserver(ClientObserver o);
    
}
