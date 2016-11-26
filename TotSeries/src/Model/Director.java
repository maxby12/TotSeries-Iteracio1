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
public class Director extends Artista {

    public Director(String nom, String nacionalitat, String _idSerie) {
        super(nom, nacionalitat, _idSerie);
    }

    @Override
    public String toString() {
        return "Director{ Nom=" + this.getNom() + ", Nacionalitat=" + this.getNacionalitat() + ", IdSerie=" + this.getIdSerie() + '}';
    }
    
}
