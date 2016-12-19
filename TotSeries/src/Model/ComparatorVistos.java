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
public class ComparatorVistos implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        if (((Capitol)t).getVisualitzacions() > ((Capitol)t1).getVisualitzacions()) return -1;
        else if (((Capitol)t).getVisualitzacions() < ((Capitol)t1).getVisualitzacions()) return 1;
        else return 0;
    }
    
}
