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
    private String _anyCreacio;

    public Productora(String _nom, String _id, String _anyCreacio) {
        this._nom = _nom;
        this._id = _id;
        this._anyCreacio = _anyCreacio;
    }

    public String getNom() {
        return _nom;
    }

    public String getId() {
        return _id;
    }

    public String getAnyCreacio() {
        return _anyCreacio;
    }
    
    
    
    @Override
    public String toString() {
        return "Productora{" + "_nom=" + _nom + ", _id=" + _id + ", _anyCreacio=" + _anyCreacio + '}';
    }

}
