/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Albert
 */
public class Valoracio {
    
    private int _valor;
    private Date _dataValorat;

    public Valoracio(int _valor, Date _dataValorat) {
        this._valor = _valor;
        this._dataValorat = _dataValorat;
    }

    public int getValor() {
        return _valor;
    }

    public Date getDataValorat() {
        return _dataValorat;
    }

}
