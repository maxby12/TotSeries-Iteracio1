/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Raül
 */
public class RankingCapitols {
    private ArrayList<Capitol> _capitols;
    private Comparator _cmp;

    public RankingCapitols(Comparator cmp) {
        this._capitols = new ArrayList<Capitol>(10);
        this._cmp =  cmp;

    }
    
    public float getNotaMin() {
        if (this._capitols.size()<10) return 0;
        else return this._capitols.get(this._capitols.size()-1).getNota();
    }
    
    public float getMinVistos() {
        if (this._capitols.size()<10) return 0;
        else return this._capitols.get(this._capitols.size()-1).getVisualitzacions();
    }
    
    public float getNotaMax() {
        if (this._capitols.size()==0) return 0;
        else return this._capitols.get(0).getNota();
    }
    
    public void insertCapitol(Capitol c) {
        if (this._capitols.size() == 10) {
            this._capitols.remove(this._capitols.size()-1);
        }
        this._capitols.add(c);
    }

    public ArrayList<Capitol> getCapitols() {
        return _capitols;
    }
    
    public void sort() {
        Collections.sort(this._capitols, _cmp);
    }
    
    public ArrayList<String> mostrarTop() {
        ArrayList<String> s = new ArrayList<>();
        if (_cmp instanceof ComparatorNota) {
            for (Capitol c : this._capitols) {
                String st = c.getNom() + " - Nota: " + String.format("%.2f", c.getNota());
                s.add(st);
            }
        }
        else {
            for (Capitol c : this._capitols) {
                String st = c.getNom() + " - Visualitzacions: " + String.format("%d", c.getVisualitzacions());
                s.add(st);
            }
        }

        return s;
    }
    
    @Override
    public String toString() {
        String st = "";
        int i = 1;
        for (Capitol c : this._capitols){
            st = st + i + " : " + c.getNom() + ", Nota : " + c.getNota() + "\n";
            i++;
        }
        return st;
    }
    
}
