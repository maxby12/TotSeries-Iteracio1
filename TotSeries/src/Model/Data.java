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
public class Data {
    private int _dia;
    private int _mes;
    private int _any;

    public int getDia() {
        return _dia;
    }

    public void setDia(int _dia) {
        this._dia = _dia;
    }

    public int getMes() {
        return _mes;
    }

    public void setMes(int _mes) {
        this._mes = _mes;
    }

    public int getAny() {
        return _any;
    }

    public void setAny(int _any) {
        this._any = _any;
    }

    @Override
    public String toString() {
        return "Data{" + "_dia=" + _dia + ", _mes=" + _mes + ", _any=" + _any + '}';
    }
}
