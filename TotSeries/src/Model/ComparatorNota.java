/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Comparator;

/**
 *
 * @author mat.aules
 */
public class ComparatorNota implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        if (((Capitol)t).getNota() > ((Capitol)t1).getNota()) return -1;
        else if (((Capitol)t).getNota() < ((Capitol)t1).getNota()) return 1;
        else return 0;
    }
    
}
