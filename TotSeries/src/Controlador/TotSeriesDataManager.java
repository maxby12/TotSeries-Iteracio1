package Controlador;

import Model.Actor;
import Model.Administrador;
import Model.Artista;
import Model.Cataleg;
import Model.Client;
import Model.ClientVIP;
import Model.Director;
import Model.Productora;
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
        private ArrayList<Productora> _productores;
        private ArrayList<Artista> _artistes;
        
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
                this._productores = new ArrayList<Productora>();
                this._artistes = new ArrayList<Artista>();
                this._cataleg = new Cataleg();
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

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova serie.
		 */

		System.out.println("\nSerie amb ID: " + id);
		System.out.println("--------------------------------------------------");
		System.out.println("Titol: " + title);
		System.out.println("Descripció: " + desc);
	}
        
        /**
	 * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
	 * 
	 * @param numTemporada numero de la temporada
	 * @param numEpisodis numero d'episodis
         * 
	 */
	
	public void crearTemporada(String numTemporada, String numEpisodis) {		

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nova temporada.
		 */

		System.out.println("Temporada: " + numTemporada + " Numero Episodis: "+ numEpisodis);
                System.out.println("--------------------------------------------------");
                
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

		/*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
		 *  d'una nou episodi.
		 */

		System.out.println("\nTitol: " + title);
                System.out.println("--------------------------------------------------");
                System.out.println("Duració; " + duration);
                System.out.println("Data d'estrena: " + data);
                System.out.println("Idioma: " + idioma);
                System.out.println(description);
                
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
            
            Artista a;
            if (tipus.equals("actor")) {
                a = new Actor(nom, nacionalitat, idSerie);
            }
            else {
                a = new Director(nom, nacionalitat, idSerie);
            }
            this._artistes.add(a);
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
            this._productores.add(p);
            
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


            ClientVIP c = new ClientVIP(usuari, password, nom, "Espanya", new Date(1,2,1990));
            this._llistaClients.add(c);
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


            Client c = new Client(usuari, password, nom, "Espanya", new Date(1,2,1990));
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
