package Controlador;

import Model.Actor;
import Model.Administrador;
import Model.Artista;
import Model.Capitol;
import Model.Cataleg;
import Model.Client;
import Model.ClientVIP;
import Model.Director;
import Model.Productora;
import Model.Serie;
import Model.Temporada;
import Model.Valoracio;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Date;

/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries 
 * per a manegar l'aplicació de gestió de TotSeries.
 * 
 */
public class TotSeriesDataManager {
    
        private ArrayList<Client> _llistaClients;
        private Cataleg _cataleg;
        private ArrayList<Administrador> _administradors;
        private Productora _prodActual;
        private Artista _artistaActual;
        private Serie _serieActual;
        private Temporada _tempActual;
        private int _codiSerie;
        private int _codiTemporada;
        private int _numCapitol;

    public ArrayList<Client> getLlistaClients() {
        return _llistaClients;
    }

    public Cataleg getCataleg() {
        return _cataleg;
    }

    public ArrayList<Administrador> getAdministradors() {
        return _administradors;
    }

        
        
        
        
	/* -------------------------------------------------------------------
	 * Metodes a implementar per vosaltres. En aquests metodes creareu els
	 * vostres objectes a partir de la informacio obtinguda del fitxer XML
	 * 
	 * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
	 * dades que retorna el metode, es a dir que sou lliures de
	 * modificar-ho al gust, excepte les crides inicials que es fan.
	 * -------------------------------------------------------------------
	 */

	/**
	 * Obté les dades del fitxer XML passat per paràmetre
	 * 
	 * @param nomFitxer ruta del fitxer XML del que obtenir les dades
	 */
	public void obtenirDades(String nomFitxer) {
                this._llistaClients = new ArrayList<Client>();
                this._administradors = new ArrayList<Administrador>();
                this._cataleg = new Cataleg();
                this._codiSerie = -1;
		TotSeriesXMLParser parser = new TotSeriesXMLParser(this);
		parser.parse(nomFitxer);
	}

	/**
	 * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la serie. El podeu utilitzar o no
	 * @param title títol de la serie
         * @param desc descripcio de la serie
	 */
	
	public void crearSerie(String id, String title, String desc) {		
            this._codiSerie++;
            Serie s = new Serie(title, desc, 0, 0, new ArrayList<Temporada>(), null, new ArrayList<Actor>(), null,this._codiSerie);
            this._serieActual = s;
            this._cataleg.addSerie(s);
            
            /*
		System.out.println("\nSerie amb ID: " + id);
		System.out.println("--------------------------------------------------");
		System.out.println("Titol: " + title);
		System.out.println("Descripció: " + desc);
            */
	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param numTemporada numero de la temporada
	 * @param numEpisodis numero d'episodis
         * 
	 */
	
	public void crearTemporada(String numTemporada, String numEpisodis) {		
            int nt = parseInt(numTemporada);
            this._numCapitol = -1;
            this._codiTemporada = nt-1;
            Temporada t = new Temporada(nt, parseInt(numEpisodis));
            this._tempActual = t;
            this._serieActual.addTemporada(t);
            

            /*
		System.out.println("Temporada: " + numTemporada + " Numero Episodis: "+ numEpisodis);
                System.out.println("--------------------------------------------------");
            */
                
	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param title titol de lepisodi
	 * @param duration duració de l'episodi
         * @param idioma idioma de l'episodi V.O.
         * @param description sinopsi de l'episodi
         * @param data data d'estrena de l'episodi
         * 
	 */
	
	public void crearEpisodi(String title, String duration, String idioma, String description, String data) {		
            // TODO HERE, ESTABLIR CODI CCCTTTSSS
            this._numCapitol++;
            String[] parts = data.split("/");
            Date d = new Date(parseInt(parts[0]), parseInt(parts[1]), parseInt(parts[2]));
            Capitol c = new Capitol(title, duration, idioma, description, 0f, d, this._numCapitol, this._codiTemporada, this._codiSerie);
            this._tempActual.addCapitol(c);
            
            /*
		System.out.println("\nTitol: " + title);
                System.out.println("--------------------------------------------------");
                System.out.println("Duració; " + duration);
                System.out.println("Data d'estrena: " + data);
                System.out.println("Idioma: " + idioma);
                System.out.println(description);
            */
                
	}

	/**
	 * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del artista. El podeu utilitzar o no
	 * @param nom nom del artista
	 * @param tipus tipus (director\actor) del artista
	 * @param idSerie serie a la qual treballa. El podeu utilitzar o no
         * @param nacionalitat 
	 */

	public void crearArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {
            
            if (tipus.equals("actor")) {
                Actor a = new Actor(nom, nacionalitat, idSerie);
                this._serieActual.addActor(a);
            }
            else {
                Director d = new Director(nom, nacionalitat, idSerie);
                this._serieActual.setDirector(d);
            }
            /*
		System.out.println("\nArtista amb ID: " + id);
		System.out.println("--------------------------------------");
		System.out.println("Nom: " + nom);
		System.out.println("Tipus: " + tipus);
		System.out.println("Serie ID: " + idSerie);
                System.out.println("Nacionalitat: " + nacionalitat);
            */
	}
	
	
	/**
	 * Crea productora del fitxer XML
	 * 
	 * @param id id de la productora
	 * @param nom nom de la productora
	 * @param idSerie id de la serie que va fer. El podeu utilitzar o no
	 */
	public void crearProductora (String id, String nom, String idSerie) {
            
            Productora p = new Productora(nom, id, "1990", idSerie);
            this._serieActual.setProductora(p);
            
            /*
		System.out.println("\nProductora amb ID: " + id);
		System.out.println("--------------------------------------");
		System.out.println("Nom: " + nom);
		System.out.println("Serie ID: " + idSerie);
            */
	}

	/**
	 * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id de la valoracio. El podeu utilitzar o no
	 * @param client identificador del client. El podeu utilitzar o no
	 * @param episodi identificador de la serie. El podeu utilitzar o no
	 * @param puntuacio puntuacio donada al episodi
	 * @param data data en la que es va fer la puntuacio
	 */
	
	public void crearValoracio(String id, String client, String episodi, String puntuacio, String data) {
            
            String[] parts = data.split("/");
            int n = parseInt(puntuacio);
            Date d = new Date(parseInt(parts[0]), parseInt(parts[1]), parseInt(parts[2]));
            Valoracio v = new Valoracio(n, d);
            
            /*
		System.out.println("\nValoracio amb ID: " + id);
		System.out.println("--------------------------------------");
		System.out.println("Client: " + client);
		System.out.println("Episodi: " + episodi);
		System.out.println("Puntuacio: " + puntuacio);
		System.out.println("Data: " + data);
            */
	}

	/**
	 * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del administrador
	 * @param nom nom del administrador
	 * @param usuari usuari del administrador
	 * @param password password del administrador
	 */
	public void crearAdmin(String id, String nom, String usuari, String password) {


            Administrador c = new Administrador(nom,usuari,password);
            this._administradors.add(c);
            /*
		System.out.println("\nAdmin ID: " + id);
		System.out.println("-----------------");
		System.out.println("Nom: " + nom);
		System.out.println("Usuari: " + usuari);
		System.out.println("Password: " + password);
            */
	}
        
	/**
	 * Crea un nou client a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param id id del client
	 * @param nom nom del client
	 * @param dni dni del client
	 * @param adreca adreça del client
	 * @param usuari usuari al sistema del client
	 * @param password password del client
	 * @param vip true si el client es vip. false si no
	  */

	public void crearClient(String id, String nom, String dni, String adreca, String usuari, String password, String vip) {

            Client c;
            if (vip.equals("false")) {
                c = new Client(usuari, password, nom, "Espanya", new Date(1,2,1990));
            }
            else {
                c = new ClientVIP(usuari, password, nom, "Espanya", new Date(1,2,1990));
            }
            
            this._llistaClients.add(c);
            /*
		System.out.println("\nClient ID: " + id);
		System.out.println("-----------------");
		System.out.println("Nom: " + nom);
		System.out.println("Usuari: " + usuari);
		System.out.println("Dni: " + dni);
		System.out.println("Adreça: " + adreca);
		System.out.println("Password: " + password);
		System.out.println("Es VIP: " + vip);
            */
	}
}
