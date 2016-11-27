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
        int i = 1;
        for (Serie s : this._series) {
            c = c + i + " : " + s.toString() + "\n";
            i++;
        }
        return c;
    }
    
    public Capitol getCapitol(int numCap){
        
    }
    
    public String mostrarTemporada(int numTemp){
        Serie s = this._series.get(numTemp%1000);
        return s.mostrarTemporada(numTemp/1000);
    }
    
    public String mostrarSerie(int numSerie) {
        Serie s = this._series.get(numSerie);
        String st = s.toString() + "\n0 : Tornar Menu Cataleg\n";
        int i = 1;
        for (Temporada t : s.getTemporades()) {
            st = st + i + " : " + t.toString() + "\n";
            i++;
        }
        return st;
    }
    
    public String mostrarTopCap(){
        return this._topCapitols.toString();
    }
}
