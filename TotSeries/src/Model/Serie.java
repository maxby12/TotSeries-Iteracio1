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
public class Serie implements ElementCataleg {
    private String _nom;
    private String _descripcio;
    private int _nTemporades;
    private float _nota;
    private ArrayList<ElementCataleg> _temporades;
    private Director _director;
    private ArrayList<Actor> _actors;
    private Productora _productora;
    private int _num;
    
    public Serie(String _titol, String _despcripcio, int _nTemporades, float _nota, ArrayList<ElementCataleg> _temporades, Director _director, ArrayList<Actor> _actors, Productora _productora, int _codi) {
        this._nom = _titol;
        this._descripcio = _despcripcio;
        this._nota = _nota;
        this._temporades = _temporades;
        this._director = _director;
        this._actors = _actors;
        this._productora = _productora;
        this._num = _codi;
        this._nTemporades = this._temporades.size();
    }
    
    public void add(ElementCataleg t) {
        this._temporades.add(t);
        this._nTemporades++;
    }
    
    public void addActor(Actor a) {
        this._actors.add(a);
    }
    
    @Override
    public String getNom() {
        return _nom;
    }
    
    @Override
    public int getCodi() {
        return _num;
    }
    
    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add(_descripcio);
        info.add(_director.getNom());
        String actors = "";
        for (Actor a : _actors) {
            actors += a.getNom() + "  ";
        }
        info.add(actors);
        info.add(_nom);
        return info;
    }

    public void setNom(String _titol) {
        this._nom = _titol;
    }

    public String getDescripcio() {
        return _descripcio;
    }

    public void setDescripcio(String _descripcio) {
        this._descripcio = _descripcio;
    }

    public int getnTemporades() {
        return _nTemporades;
    }

    public void setnTemporades(int _nTemporades) {
        this._nTemporades = _nTemporades;
    }
    
    public float getNota() {
        return _nota;
    }

    public void setNota(float _nota) {
        this._nota = _nota;
    }
    
    @Override
    public ElementCataleg getChild (int i) {
        return _temporades.get(i);
    }

    @Override
    public ArrayList<ElementCataleg> getChildren() {
        return _temporades;
    }
    
    public void setTemporades(ArrayList<ElementCataleg> _temporades) {
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
/*
    public Capitol getCapitol(int numCap){
       // return this._temporades.get(numTemp).getCapitol(numCap);
    }
    */
    public ArrayList<String> mostrarTemporada(int numTemp){
        return this._temporades.get(numTemp).getInfo();
    }

    @Override
    public void remove(ElementCataleg e) {
        this._temporades.remove(e);
    }
    
}
