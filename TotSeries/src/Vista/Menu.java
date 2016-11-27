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
    private String _usuari;
    
    
    static private String[] descMenuPrincipal={"Mirar Catàleg",
                                           "Registrar Usuari",
                                           "Mirar Top Capitols",
                                           "Finalitzar aplicació"};
    
    
    // METODES PUBLICS
    
    public Menu(TotSeries ctrl) {
        this._ctrl = ctrl;
        this._usuari = "ajaleo";
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
        int dia = llegeixInt();
        System.out.print("Introdueix el mes: ");
        int mes = llegeixInt();
        System.out.print("Introdueix l'any: ");
        int any = llegeixInt();
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
                    this.menuCataleg();
                    break;

                case 2:
                    this.menuRegistreUsuari();
                    break;

                case 3:
                    this.menuTop(this._usuari);
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
        String us;
        if (this._usuari.equals("")) {
            us = "  No logejat";
        }
        else {
            us = "  Logejat com: " + this._usuari;
        }
        escriu("------------------\n  MENU PRINCIPAL\n"+us+"\n------------------");
        for (String s : descMenuPrincipal) {
            System.out.println(i+": "+s);
            i++;
        }
    }
    
    private void menuCataleg() {
        String llistaSeries = this._ctrl.mirarCataleg();
        int numSeries = llistaSeries.split("\n").length + 1;
        
        // Creem el menú
        int numS = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  MENU CATALEG\n------------------");
            escriu("0 : Tornar Menu Principal");
            escriu(llistaSeries);

            numS = llegeixInt();

            if (numS > 0 && numS < numSeries) {
                menuSerie(numS-1);
            }

        } while(numS!=0);
    }
    
    private void menuSerie(int numSerie) {
        String llistaTemporades = this._ctrl.mostrarSerie(numSerie);
        int numTemporades = llistaTemporades.split("\n").length - 1;
        // Creem el menú principal
        int numTemp = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  MENU SERIE\n------------------");
            escriu(llistaTemporades);

            //Demanem una opcio
            numTemp = llegeixInt();

            // MENU PRINCIPAL
            if (numTemp > 0 && numTemp < numTemporades) {
                menuTemporada(1000*(numTemp-1) + numSerie);
            }
            
        } while(numTemp!=0);
    }
    
    private void menuTemporada(int numTemp) {
        String tempStr = this._ctrl.mostrarTemporada(numTemp);
        int numCapitols = tempStr.split("\n").length + 1;
        // Creem el menú principal
        int numCap = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  MENU TEMPORADA\n------------------");
            escriu("0 : Tornar Menu Serie");
            escriu(tempStr);
            
            //Demanem una opcio
            numCap = llegeixInt();
            
            // MENU PRINCIPAL
            if (numCap > 0 && numCap < numCapitols) {
                // AQUI VA SELECCIONAR CAPITOL I VISUALITZARLO
                if (this._usuari.equals("")) {
                    escriu("Usuari no logejat!");
                }
                else {
                    this.reproduirCapitol(this._usuari, 1000000*(numCap-1)+numTemp);
                }
            }

        } while(numCap!=0);
    }
    
    
    private void menuRegistreUsuari() {
        String userName;
        String password;
        String nom;
        String nacionalitat;
        Date dataNaixament;
        boolean noDuplicat;
        
        // Creem el menú
        
        escriu("------------------\n  Registre d'usuari \n------------------");
        escriu("entra nom d'usuari");
        userName = llegeixString();
        escriu("entra contrasenya");
        password = llegeixString();
        escriu("entra nom");
        nom = llegeixString();
        escriu("entra nacionalitat");
        nacionalitat = llegeixString();
        escriu("data de naixament:");
        dataNaixament = llegeixDataNaixament();
        noDuplicat = this._ctrl.registrarUsuari(userName,password,nom,nacionalitat,dataNaixament); 
        if(noDuplicat){
            escriu("Usuari registrat correctament");
        }else{
            escriu("Nom d'usuari ja registrat, proces cancel·lat");
        }
    }
    
    private void menuTop(String user){
        String topSeries = this._ctrl.visualitzarTopCapitols(user);
        int numCapitols = 10;
        
        
        // Creem el menú principal
        int opcio = 1;
        
        do {
            // Mostrem les opcions del menú
            escriu("------------------\n  TOP SERIES \n------------------");
            escriu("0 : Tornar Menu Principal");
            escriu(topSeries);

            //Demanem una opcio
            opcio = llegeixInt();

            // Seleccionar capitol
            if (opcio > 0 && opcio < numCapitols) {
                //aqui es reprodueix el capitol
            }
            
        } while(opcio!=0);
    }

    private void reproduirCapitol(String userName, int numCap) {
        String status = this._ctrl.reproduirCapitol(userName, numCap);
        if (status.equals("NOEMISSIO")) {
            String s = this._ctrl.reprodueixCapitol(userName, numCap);
            escriu("Visualitzan capítol: "+ s);
            escriu("...");
            // AQUI ES FA STREAMING DEL CAPITOL FINS QUE S'ACABA O FINS QUE CLIENT ATURA
            this._ctrl.aturaCapitol(userName);
            // SUPOSEM QUE CAPITOL FINALITZA AUTOMATICAMENT JA QUE TREBALLEM AMB INTERFICIE VISUAL DE CONSOLA
            boolean finished = true;
            if (finished) {
                escriu("Vols valorar el capítol? (S/N):");
                String resposta = llegeixString();
                if (resposta.equals("S")) {
                    escriu("Introdueix valoracio (0 al 10):");
                    int nota = llegeixInt();
                    this._ctrl.valorarCapitol(userName, numCap, nota);
                }
            }
            else {
                escriu("Emissio aturada");
            }
        }
        else {
            escriu("Client esta visualitzant un altre capítol!");
        }
    }
    
}
