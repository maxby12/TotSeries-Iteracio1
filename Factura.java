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
    private double _valor;

    public double getValor() {
        return _valor;
    }

    public void incrementar() {
        this._valor = _valor + 1;
    }

    @Override
    public String toString() {
        return "Factura{" + "_valor=" + _valor + '}';
    }
}
