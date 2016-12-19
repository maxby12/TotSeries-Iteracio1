/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.TopVistosObserver;

/**
 *
 * @author mat.aules
 */
public interface TopVistosSubjecte {
    void registerTopVistosObserver(TopVistosObserver o);
    void removeTopVistosObserver(TopVistosObserver o);
    void notifyTopVistosObservers();
}
