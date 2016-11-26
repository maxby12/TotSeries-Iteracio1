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
public class Capitol {
    
    private String _nom;
    private String _duracio;
    private String _idioma;
    private String _descripcio;
    private float _nota;

    public Capitol(String _nom, String _duracio, String _idioma, String _descripcio, float _nota) {
        this._nom = _nom;
        this._duracio = _duracio;
        this._idioma = _idioma;
        this._descripcio = _descripcio;
        this._nota = _nota;
    }

    @Override
    public String toString() {
        return "Capitol{" + "_nom=" + _nom + ", _duracio=" + _duracio + ", _idioma=" + _idioma + ", _descripcio=" + _descripcio + ", _nota=" + _nota + '}';
    }
    
}
