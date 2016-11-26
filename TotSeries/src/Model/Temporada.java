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
public class Temporada {
    
    private ArrayList<Capitol> _capitols;
    private int _num;
    private float _nota;
    
    public Temporada(int _num) {
        this._capitols = new ArrayList<Capitol>();
        this._num = _num;
        this._nota = 0.0f;
    }
    
    
    public ArrayList<Capitol> getCapitols() {
        return _capitols;
    }

    public void setCapitols(ArrayList<Capitol> _capitols) {
        this._capitols = _capitols;
    }
    
    public int getNum() {
        return _num;
    }

    public float getNota() {
        return _nota;
    }

    public void setNota(float _nota) {
        this._nota = _nota;
    }
    
    public Capitol getCapitol(int numCap) {
        return _capitols.get(numCap);
    }
    
    @Override
    public String toString() {
        return "Temporada{" + "_num=" + _num + ", _nota=" + _nota + '}';
    }
    
}
