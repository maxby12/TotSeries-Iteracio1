/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Albert
 */
public class Cataleg {
    private ArrayList<Serie> _series;
    private RankingCapitols _topCapitols;
    private RankingSeries _topMillorsSeries;
    private RankingSeries _topPitjorsSeries;

    public Cataleg() {
        this._series = new ArrayList<Serie>();
        this._topCapitols = new RankingCapitols();
        this._topMillorsSeries = new RankingSeries();
        this._topPitjorsSeries = new RankingSeries();
    }

    @Override
    public String toString() {
        return "Cataleg{" + "_series=" + _series + '}';
    }

}
