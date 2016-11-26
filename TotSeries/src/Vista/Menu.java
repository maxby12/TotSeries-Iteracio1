/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlTotSeries;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Albert
 */
public class Menu {
    
    /** Utilitat per llegir línies senceres de la pantalla */
    private static final Scanner sc = new Scanner(System.in);
    private CtrlTotSeries _ctrl;
    
    
    static private String[] descMenuPrincipal={"Mirar Catàleg",
                                           "Registrar Usuari",
                                           "Mirar Top Capitols",
                                           "Finalitzar aplicació"};
    
    
    // METODES PUBLICS
    
    public Menu(CtrlTotSeries ctrl) {
        this._ctrl = ctrl;
    }
    
    /**
     * Mostra un text per pantalla (sense salt de línia al final).
     *
     * @param s text a mostrar.
     */
    public static void escriu(String s) {
        System.out.print(s);
    }

    /**
     * Mostra un enter per pantalla.
     *
     * @param i enter a mostrar.
     */
    public static void escriu(int i) {
        System.out.print(i);
    }

    /**
     * Mostra un nombre flotant per pantalla.
     *
     * @param f nombre flotant a mostrar.
     */
    public static void escriu(float f) {
        System.out.print(f);
    }

    /**
     * Llegeix un enter per teclat.
     * <p>
     * Aquesta funció no retorna fins que l'usuari ha introduït un enter. En
     * cas que l'usuari introdueixi una cadena, la funció torna a demanar un
     * enter fins que la dada introduïda sigui vàlida.
     * </p>
     *
     * @return enter introduit per l'usuari
     */
    public static int llegeixInt() {
        while (true) {
            // Llegim una cadena, per així consumir salts de línia també
            String buffer = llegeixString();
            try {
                return Integer.valueOf(buffer);
            }
            // Rebem aquesta excepció si les dades no són correctes
            catch (NumberFormatException ex) {
                escriu("Entrada incorrecta. Sisplau poseu un enter: ");
            }
        }
    }

    /**
     * Llegeix una cadena per teclat.
     * <p>
     * Es considera una cadena qualsevol entrada fins a un salt de línia. El
     * salt de línia no s'inclou a la cadena retornada.
     * </p>
     *
     * @return cadena introduida per l'usuari
     */
    public static String llegeixString() {
        return sc.nextLine();
    }

    /**
     * Obtenir la data actual segons el sistema.
     *
     * @return data actual
     */
    public static Date llegeixDataSistema() {
        return new Date();
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
        
        // Creem el menú principal
        int opcio = 1;
        
        do {
            // Mostrem les opcions del menú
            mostrarMenuP();
            
            try {
                //Demanem una opcio
                opcio = sc.nextInt();

                // MENU PRINCIPAL
                switch(opcio) {
                    case 1:
                        
                        break;

                    case 2:
                        
                        break;

                    case 3:
                        
                        break;
                        
                    case 4:
                        System.out.println("Fin de sessión");
                        break;
                } // FI MENU PRINCIPAL
            }
            catch(InputMismatchException exc) {
                System.out.println("Valor introducido erronio!");
                sc.next(); // Això passa la excepció
            }
        } while(opcio!=4);
        
    }
    
    
    // METODES PRIVATS (DE SUPORT)


    private void mostrarMenuP() {
        int i = 1;
        System.out.println("------------------\n  MENU PRINCIPAL\n------------------");
        for (String s : descMenuPrincipal) {
            System.out.println(i+": "+s);
            i++;
        }
    }
    
    private void retornMenuSerie() {
        
    }
    
    private void retornMenuCataleg() {
        
    }
    
}
