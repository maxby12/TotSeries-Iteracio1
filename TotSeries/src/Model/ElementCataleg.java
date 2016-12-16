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
    
    // Metodes d'afegir/eliminar objectes PART concrets
    public void add (ElementCataleg e);
    public void remove (ElementCataleg e);
    
    // Metodes de navegació cap a objectes PART del TOT
    public ElementCataleg getChild (int i);
    public ArrayList<ElementCataleg> getChildren();
    
    // Metodes que Vista crida per obtenir dades (de manera directa Model-Vista)
    public String getNom();
    public int getCodi();
    public ArrayList<String> getInfo();
    
    
}
