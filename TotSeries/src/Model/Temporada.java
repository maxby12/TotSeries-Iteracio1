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
public class Temporada implements ElementCataleg {
    
    private ArrayList<ElementCataleg> _capitols;
    private int _num;
    private int _numS;
    private int _nCapTemporada;
    private float _nota;
    
    public Temporada(int _num, int _numCap, int _numS) {
        this._capitols = new ArrayList<>();
        this._num = _num;
        this._numS = _numS;
        this._nCapTemporada = _numCap;
        this._nota = 0.0f;
        
    }
    
    public void add(ElementCataleg c) {
        this._capitols.add(c);
    }
    
    public int getnCapTemporada() {
        return _nCapTemporada;
    }

    public void setnCapTemporada(int _nCapTemporada) {
        this._nCapTemporada = _nCapTemporada;
    }

    
    @Override
    public ArrayList<ElementCataleg> getChildren() {
        return _capitols;
    }

    public void setCapitols(ArrayList<ElementCataleg> _capitols) {
        this._capitols = _capitols;
    }
    
    @Override
    public int getCodi() {
        return 1000*_num+_numS;
    }

    public float getNota() {
        return _nota;
    }

    public void setNota(float _nota) {
        this._nota = _nota;
    }
    
    @Override
    public ElementCataleg getChild(int numCap) {
        return _capitols.get(numCap);
    }
    
    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> st = new ArrayList<>();
        for (ElementCataleg c : this._capitols){
            st.add(c.getNom());
        }
        return st;
    }
    
    @Override
    public String getNom() {
        return String.valueOf(_num);
    }

    @Override
    public void remove(ElementCataleg e) {
        this._capitols.remove(e);
    }
    
}
