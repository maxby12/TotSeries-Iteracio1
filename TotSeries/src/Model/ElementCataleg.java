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
public interface ElementCataleg {
    
    public void add (ElementCataleg e);
    public void remove (ElementCataleg e);
    public ElementCataleg getChild (int i);
    public String getNom();
    public int getCodi();
    public ArrayList<String> getInfo();
    
    
}
