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
public abstract class Artista {
    
    private String _nom;
    private String _nacionalitat;

    public Artista(String _nom, String _nacionalitat) {
        this._nom = _nom;
        this._nacionalitat = _nacionalitat;
    }
    
    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getNacionalitat() {
        return _nacionalitat;
    }

    public void setNacionalitat(String _nacionalitat) {
        this._nacionalitat = _nacionalitat;
    }
    
    
    
}
