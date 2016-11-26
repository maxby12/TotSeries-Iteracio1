/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.TotSeries;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Albert
 */
public class Menu {
    
    private Scanner sc;
    private TotSeries _ctrl;
    
    
    // METODES PUBLICS
    
    public Menu(TotSeries ctrl) {
        this.sc = new Scanner(System.in);
        this._ctrl = ctrl;
    }
    
    
    
    public void escriu(String s) {
        System.out.println(s);
    }
    
    public void escriu(int i) {
        System.out.println(i);
    }
    
    public void escriu(float f) {
        System.out.println(f);
    }
    
    public int llegeixInt() {
        int i = sc.nextInt();
        return i;
    }
    
    public String llegeixString() {
        String s = sc.next();
        return s;
    }
    
    public Date llegeixDataSistema() {
        Date d = new Date();
        return d;
    }
    
    public Date llegeixDataNaixament() {
        System.out.print("Introdueix el dia: ");
        int dia = sc.nextInt();
        System.out.print("Introdueix el mes: ");
        int mes = sc.nextInt();
        System.out.print("Introdueix l'any: ");
        int any = sc.nextInt();
        Date d = new Date(dia,mes,any);
        return d;
    }
    
    
    /**
     * Execució del menu principal de l'aplicació
     * 
     */
    public void show() {
        
    }
    
    // METODES PRIVATS (DE SUPORT)
    
    private void retornMenuSerie() {
        
    }
    
    private void retornMenuCataleg() {
        
    }
    
}
