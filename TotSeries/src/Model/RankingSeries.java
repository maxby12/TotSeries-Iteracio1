/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Raül
 */
public class RankingSeries {
    private ArrayList<Serie> _series;

    public RankingSeries() {
        this._series = new ArrayList<Serie>(10);
    }

    @Override
    public String toString() {
        return "RankingSeries{" + "_series=" + _series + '}';
    }
}
