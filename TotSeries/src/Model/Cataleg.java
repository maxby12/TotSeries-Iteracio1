/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Iterator;

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
    
    public ArrayList<String> getSeries() {
        ArrayList<String> c = new ArrayList<>();
        for (Serie s : this._series) {
            c.add(s.getTitol());
        }
        return c;
    }
    
    public String mostrarCapitol(int numCap){
        Serie s = this._series.get(numCap%1000);
        Temporada t = s.getTemporades().get((numCap/1000)%1000);
        Capitol c = t.getCapitol(numCap/1000000);
        return c.getNom();
    }
    
    public String mostrarTemporada(int numTemp){
        Serie s = this._series.get(numTemp%1000);
        return s.mostrarTemporada(numTemp/1000);
    }
    
    public String mostrarSerie(int numS) {
        Serie s = this._series.get(numS);
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
    
    public Capitol getCapitol(int numCap) {
        Serie s = this._series.get(numCap%1000);
        Temporada t = s.getTemporades().get((numCap/1000)%1000);
        Capitol c = t.getCapitol(numCap/1000000);
        return c;
    }
    
    public void actualitzarTopCap() {
        float notaMin = this._topCapitols.getNotaMin();
        Capitol entraTop = null;
        for (Serie s : this._series) {
            for (Temporada t : s.getTemporades()) {
                for (Capitol c : t.getCapitols()) {
                    if (c.getNota() > notaMin) {
                        Iterator<Capitol> llistaCapitolsIterator = this._topCapitols.getCapitols().iterator();
                        boolean found = false;
                        while (llistaCapitolsIterator.hasNext() && !found) {
                            entraTop = llistaCapitolsIterator.next();
                            found = (c.getNom().equals(entraTop.getNom()));
                        }
                        if (!found) entraTop = c;
                        else entraTop = null;
                    }
                }
            }
        }
        if (entraTop != null) {
            this._topCapitols.insertCapitol(entraTop);
        }
        this._topCapitols.sort();
    }
    
}
