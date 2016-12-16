/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.TopValObserver;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Albert
 */
public class Cataleg implements TopValSubjecte {
    private ArrayList<ElementCataleg> _series;
    private RankingCapitols _topCapitols;
    private RankingSeries _topMillorsSeries;
    private RankingSeries _topPitjorsSeries;
    private ArrayList<TopValObserver> _topValObservers = new ArrayList<TopValObserver>();
    
    public Cataleg() {
        this._topCapitols = new RankingCapitols();
        this._topMillorsSeries = new RankingSeries();
        this._topPitjorsSeries = new RankingSeries();
        this._series = new ArrayList<ElementCataleg>();
    }
    
    public void addSerie(Serie s) {
        this._series.add(s);
    }
    
    public RankingCapitols getTopCapitols() {
        return _topCapitols;
    }

    
    public ArrayList<String> mostrarSeries() {
        ArrayList<String> c = new ArrayList<>();
        for (ElementCataleg s : this._series) {
            c.add(s.getNom());
        }
        return c;
    }
    
    public String mostrarCapitol(int numCap){
        ElementCataleg s = _series.get(numCap%1000);
        ElementCataleg t = s.getChild((numCap/1000)%1000);
        ElementCataleg c = t.getChild(numCap/1000000);
        return c.getNom();
    }
    
    public ArrayList<String> mostrarTemporada(int numTemp){
        ElementCataleg s = _series.get(numTemp%1000);
        ElementCataleg t = s.getChild(numTemp/1000);
        return t.getInfo();
    }
    
    public ArrayList<String> mostrarValorats() {
        return this._topCapitols.mostrarTop();
    }
    
    public ArrayList<String> infoSerie(int numS) {
        ElementCataleg s = this._series.get(numS);
        return s.getInfo();
    }
    
    public int getNumTemp (int numS) {
        Serie s = (Serie)this._series.get(numS);
        return s.getnTemporades();
    }
    
    
    public Capitol getCapitol(int numCap) {
        ElementCataleg s = this._series.get(numCap%1000);
        ElementCataleg t = s.getChild((numCap/1000)%1000);
        Capitol c = (Capitol) t.getChild(numCap/1000000);
        return c;
    }
    
    public ArrayList<String> infoCapitol(int numCap) {
        ElementCataleg s = _series.get(numCap%1000);
        ElementCataleg t = s.getChild((numCap/1000)%1000);
        ElementCataleg c = t.getChild(numCap/1000000);
        return c.getInfo();
    }
    
    public void actualitzarTopCap() {
        float notaMin = this._topCapitols.getNotaMin();
        Capitol entraTop = null;
        for (ElementCataleg s : this._series) {
            for (ElementCataleg t : s.getChildren()) {
                for (ElementCataleg c : t.getChildren()) {
                    if (((Capitol)c).getNota() > notaMin) {
                        Iterator<Capitol> llistaCapitolsIterator = this._topCapitols.getCapitols().iterator();
                        boolean found = false;
                        while (llistaCapitolsIterator.hasNext() && !found) {
                            Capitol temp = llistaCapitolsIterator.next();
                            found = (c.getNom().equals(temp.getNom()));
                        }
                        if (!found) entraTop = (Capitol) c;
                    }
                }
            }
        }
        if (entraTop != null) {
            this._topCapitols.insertCapitol(entraTop);
        }
        this._topCapitols.sort();
        this.notifyTopValObservers();
    }
    
    public int getCodi(String nomCap) {
        
        for (ElementCataleg s : this._series) {
            for (ElementCataleg t : s.getChildren()) {
                for (ElementCataleg c : t.getChildren()) {
                    if (c.getNom().equals(nomCap)) return c.getCodi();
                }
            }
        }
        return -1;
    }
    
    
    @Override
    public void registerTopValObserver(TopValObserver o) {
        this._topValObservers.add(o);
    }

    @Override
    public void removeTopValObserver(TopValObserver o) {
        int i = _topValObservers.indexOf(o);
        if (i >= 0) {
                _topValObservers.remove(i);
        }
    }
    
    @Override
    public void notifyTopValObservers() {
            for(int i = 0; i < _topValObservers.size(); i++) {
                    TopValObserver observer = _topValObservers.get(i);
                    observer.updateTopVal();
            }
    }
    
    
}
