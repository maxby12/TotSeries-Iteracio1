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
public class Actor extends Artista {

    public Actor(String _nom, String _nacionalitat, String _idSerie) {
        super(_nom, _nacionalitat, _idSerie);
    }

    @Override
    public String toString() {
        return "Actor{ Nom=" + this.getNom() + ", Nacionalitat=" + this.getNacionalitat() + ", IdSerie=" + this.getIdSerie() + '}';
    }

}
