/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Albert
 */
public class Capitol implements Comparable<Capitol>, ElementCataleg {
    
    private String _nom;
    private String _duracio;
    private String _idioma;
    private String _descripcio;
    private ArrayList<Valoracio> _llistaValoracions;
    private float _nota;
    private Date _estrena;
    private int _num; //numCap
    private int _numTemp;
    private int _numS;
    

    public Capitol(String _nom, String _duracio, String _idioma, String _descripcio, float _nota, Date _estrena, int _num, int _numT, int _numS) {
        this._nom = _nom;
        this._duracio = _duracio;
        this._idioma = _idioma;
        this._descripcio = _descripcio;
        this._llistaValoracions = new ArrayList<Valoracio>();
        this._nota = _nota;
        this._estrena = _estrena;
        this._num = _num;
        this._numTemp = _numT;
        this._numS = _numS;
    }

    @Override
    public int getCodi(){
        return  1000000*this._num+(1000*(this._numTemp) + this._numS);
    }
    
    public void addValoracio(Valoracio valoracio){
        // Actualitzem nota mitjana
        float m = this._nota;
        m = m * this._llistaValoracions.size();
        m = m + valoracio.getValor();
        m = m/(this._llistaValoracions.size()+1);
        this._nota = m;
        
        this._llistaValoracions.add(valoracio);

    }

    public String getDuracio() {
        return _duracio;
    }

    public String getIdioma() {
        return _idioma;
    }

    public String getDescripcio() {
        return _descripcio;
    }

    public float getNota() {
        return _nota;
    }
  
    @Override
    public String getNom() {
        return _nom;
    }
    
    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add(Float.toString(_nota));
        info.add(_nom);
        info.add(_duracio);
        info.add(_idioma);
        info.add(_descripcio);
        return info;
    }

    @Override
    public int compareTo(Capitol t) {
        float nota = t.getNota();
        if (this._nota > nota) return -1;
        else if (this._nota < nota) return 1;
        else return 0;
    }

    @Override
    public ElementCataleg getChild(int i) {
        return null;
    }

    @Override
    public void add(ElementCataleg e) {
        
    }

    @Override
    public void remove(ElementCataleg e) {
        
    }
}
