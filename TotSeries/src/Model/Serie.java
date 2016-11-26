/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Raül
 */
public class Serie {
    private String _titol;
    private String _despcripcio;
    private int _nTemporades;
    private int _nCapTemporada;
    private float _nota;
    private ArrayList<Temporada> _temporades;
    private Director _director;
    private ArrayList<Actor> _actors;
    private Productora _productora;

    public Serie(String _titol, String _despcripcio, int _nTemporades, int _nCapTemporada, float _nota, ArrayList<Temporada> _temporades, Director _director, ArrayList<Actor> _actors, Productora _productora) {
        this._titol = _titol;
        this._despcripcio = _despcripcio;
        this._nTemporades = _nTemporades;
        this._nCapTemporada = _nCapTemporada;
        this._nota = _nota;
        this._temporades = _temporades;
        this._director = _director;
        this._actors = _actors;
        this._productora = _productora;
    }
    
    
    
    public String getTitol() {
        return _titol;
    }

    public void setTitol(String _titol) {
        this._titol = _titol;
    }

    public String getDespcripcio() {
        return _despcripcio;
    }

    public void setDespcripcio(String _despcripcio) {
        this._despcripcio = _despcripcio;
    }

    public int getnTemporades() {
        return _nTemporades;
    }

    public void setnTemporades(int _nTemporades) {
        this._nTemporades = _nTemporades;
    }

    public int getnCapTemporada() {
        return _nCapTemporada;
    }

    public void setnCapTemporada(int _nCapTemporada) {
        this._nCapTemporada = _nCapTemporada;
    }

    public float getNota() {
        return _nota;
    }

    public void setNota(float _nota) {
        this._nota = _nota;
    }

    public ArrayList<Temporada> getTemporades() {
        return _temporades;
    }

    public void setTemporades(ArrayList<Temporada> _temporades) {
        this._temporades = _temporades;
    }

    public Director getDirector() {
        return _director;
    }

    public void setDirector(Director _director) {
        this._director = _director;
    }

    public ArrayList<Actor> getActors() {
        return _actors;
    }

    public void setActors(ArrayList<Actor> _actors) {
        this._actors = _actors;
    }

    public Productora getProductora() {
        return _productora;
    }

    public void setProductora(Productora _productora) {
        this._productora = _productora;
    }

    public Capitol getCapitol(int numTemp, int numCap){
        return this._temporades.get(numTemp).getCapitol(numCap);
    }
    
    public String mostrarTemporada(int numTemp){
        return this._temporades.get(numTemp).toString();
    }
    
    @Override
    public String toString() {
        return "Serie{" + "_titol=" + _titol + ", _despcripcio=" + _despcripcio + ", _nTemporades=" + _nTemporades + ", _nCapTemporada=" + _nCapTemporada + ", _nota=" + _nota + ", _director=" + _director + ", _productora=" + _productora + '}';
    }

}
