/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Albert
 */
public class Productora {
    
    private String _nom;
    private String _id;
    private int _anyCreacio;
    private String _idSerie;

    public Productora(String _nom, String _id, int _anyCreacio, String _idSerie) {
        this._nom = _nom;
        this._id = _id;
        this._anyCreacio = _anyCreacio;
        this._idSerie = _idSerie;
    }

    public String getNom() {
        return _nom;
    }

    public String getId() {
        return _id;
    }

    public int getAnyCreacio() {
        return _anyCreacio;
    }

    public String getIdSerie() {
        return _idSerie;
    }

    @Override
    public String toString() {
        return "Productora{" + "_nom=" + _nom + ", _id=" + _id + ", _anyCreacio=" + _anyCreacio + ", _idSerie=" + _idSerie + '}';
    }
    
    
    

}
