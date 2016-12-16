/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.TopValObserver;

/**
 *
 * @author Albert
 */
interface TopValSubjecte {
    
    void registerTopValObserver(TopValObserver o);
    void removeTopValObserver(TopValObserver o);
    void notifyTopValObservers();
    
}
