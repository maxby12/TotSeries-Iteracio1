/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.TotSeries;
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
    private TotSeries _ctrl;
    
    
    static private String[] descMenuPrincipal={"Mirar Catàleg",
                                           "Registrar Usuari",
                                           "Mirar Top Capitols",
                                           "Finalitzar aplicació"};
    
    
    // METODES PUBLICS
    
    public Menu(TotSeries ctrl) {
        this._ctrl = ctrl;
    }
    
    /**
     * Mostra un text per pantalla (sense salt de línia al final).
     *
     * @param s text a mostrar.
     */
    public static void escriu(String s) {
        System.out.println(s);
    }

    /**
     * Mostra un enter per pantalla.
     *
     * @param i enter a mostrar.
     */
    public static void escriu(int i) {
        System.out.println(i);
    }

    /**
     * Mostra un nombre flotant per pantalla.
     *
     * @param f nombre flotant a mostrar.
     */
    public static void escriu(float f) {
        System.out.println(f);
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
            
            //Demanem una opcio
            opcio = llegeixInt();

            // MENU PRINCIPAL
            switch(opcio) {
                case 1:
                    this.menuCataleg("");
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    escriu("Fi de sessió");
                    break;
            } // FI MENU PRINCIPAL

        } while(opcio!=4);
        
    }
    
    
    // METODES PRIVATS (DE SUPORT)


    private void mostrarMenuP() {
        int i = 1;
        escriu("------------------\n  MENU PRINCIPAL\n------------------");
        for (String s : descMenuPrincipal) {
            System.out.println(i+": "+s);
            i++;
        }
    }
    
    private void menuCataleg(String userName) {
        String llistaSeries = this._ctrl.mirarCataleg(userName);
        int numSeries = llistaSeries.split("\n").length + 1;
        
        // Creem el menú
        int opcio = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  MENU CATALEG\n------------------");
            escriu("0 : Tornar Menu Principal");
            escriu(llistaSeries);

            opcio = llegeixInt();

            if (opcio > 0 && opcio < numSeries) {
                menuSerie(opcio-1);
            }

        } while(opcio!=0);
    }
    
    private void menuSerie(int numSerie) {
        String llistaTemporades = this._ctrl.mostrarSerie(numSerie);
        int numTemp = llistaTemporades.split("\n").length - 1;
        // Creem el menú principal
        int opcio = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  MENU SERIE\n------------------");
            escriu(llistaTemporades);

            //Demanem una opcio
            opcio = llegeixInt();

            // MENU PRINCIPAL
            if (opcio > 0 && opcio < numTemp) {
                menuTemporada(1000*(opcio-1) + numSerie);
            }
            
        } while(opcio!=0);
    }
    
    private void menuTemporada(int numTemp) {
        String llistaCapitols = this._ctrl.mostrarTemporada(numTemp);
        int numCapitols = llistaCapitols.split("\n").length + 1;
        // Creem el menú principal
        int opcio = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  MENU TEMPORADA\n------------------");
            escriu("0 : Tornar Menu Serie");
            escriu(llistaCapitols);

            //Demanem una opcio
            opcio = llegeixInt();
            
            // MENU PRINCIPAL
            if (opcio > 0 && opcio < numCapitols) {
                // AQUI VA SELECCIONAR CAPITOL I VISUALITZARLO
            }

        } while(opcio!=0);
    }
    
}
