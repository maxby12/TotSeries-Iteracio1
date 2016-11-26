/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Albert
 */
public class Cataleg {
    private ArrayList<Serie> _series;
    private RankingCapitols _topCapitols;
    private RankingSeries _topMillorsSeries;
    private RankingSeries _topPitjorsSeries;

    public Cataleg() {
        this._topCapitols = new RankingCapitols();
        this._topMillorsSeries = new RankingSeries();
        this._topPitjorsSeries = new RankingSeries();
        this._series = new ArrayList<Serie>();
    }
    
    public void addSerie(Serie s) {
        this._series.add(s);
    }
    
    public RankingCapitols getTopCapitols() {
        return _topCapitols;
    }
    
    @Override
    public String toString() {
        String c = "";
        for (Serie s : this._series) {
            c = c + s.toString() + "\n";
        }
        return c;
    }
/*
    public Capitol getCapitol(int numCap){
        
    }
    
    public String mostrarSerie(int numS){
        
    }
    
    public String mostrarTemporada(int numTemp){
        
    }
    */
    public String mostrarTopCap(){
        return this._topCapitols.toString();
    }
}
