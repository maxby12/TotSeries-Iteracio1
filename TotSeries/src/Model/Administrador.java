/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Raül
 */
public class Administrador {
    private String _nom;
    private String _userName;
    private String _password;

    public Administrador(String _nom, String _userName, String _password) {
        this._nom = _nom;
        this._userName = _userName;
        this._password = _password;
    }

    @Override
    public String toString() {
        return "Administrador{" + "_nom=" + _nom + ", _userName=" + _userName + '}';
    }

}
