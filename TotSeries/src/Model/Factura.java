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
public class Factura {
    private float _valor;
    
    public Factura(float valor) {
        this._valor = valor;
    }

    public float getValor() {
        return _valor;
    }
    
    public void setValor(float valor) {
        this._valor = valor;
    }

    public void incrementar(float x) {
        this._valor = _valor + x;
    }
    
    @Override
    public String toString() {
        return "Factura{" + "_valor=" + _valor + '}';
    }
}
