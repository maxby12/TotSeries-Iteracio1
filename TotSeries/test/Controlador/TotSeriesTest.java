/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Administrador;
import Model.Cataleg;
import Model.Client;
import Model.TotSeriesDades;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Albert
 */
public class TotSeriesTest {
    
    private TotSeriesDades _data;
    private enum View {
        EMISSIO, NOEMISSIO
    }

    public TotSeriesTest() {
        TotSeriesDades data = new TotSeriesDades(new Date(1,1,1));
        this._data = data;
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        ArrayList<Client> clients = dataManager.getLlistaClients();
        ArrayList<Administrador> admins = dataManager.getAdministradors();
        Cataleg c = dataManager.getCataleg();
        this._data.setCataleg(c);
        this._data.setAdministradors(admins);
        this._data.setLlistaClients(clients);
        
        this._data.valorarCapitol("ajaleo", 1000000, 10);
        this._data.valorarCapitol("ajaleo", 1000001, 6);
        // Seguent capitol serà utilitzat a testGetCodi()
        this._data.valorarCapitol("ajaleo", 1000002, 5);
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----------- Test del controlador ----------");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----------- Fi test controlador -----------");
    }
    
    /**
     * Test of valorarCapitol method, of class TotSeries
     */
    @Test
    public void testValorarCapitol() {
        System.out.println("Test de valorar Capitol");
        String userName = "ajaleo";
        int numCap = 1003002;
        // Valorem capitol 2 de la temporada 4 de la serie numero 3 amb un 5
        
        this._data.valorarCapitol(userName, numCap, 5);
        float expResult = 5f;
        float result = this._data.getCataleg().getCapitol(numCap).getNota();
        assertEquals(expResult, result,0);
        
        // Valorem el mateix capitol amb un 9
        this._data.valorarCapitol(userName, numCap, 9);
        expResult = (5+9)/2;
        result = this._data.getCataleg().getCapitol(numCap).getNota();
        assertEquals(expResult, result,0);
        
        // Valorem el mateix capitol amb un 0
        this._data.valorarCapitol(userName, numCap, 0);
        expResult = (5+9+0)/3f;
        result = this._data.getCataleg().getCapitol(numCap).getNota();
        assertEquals(expResult, result,0);
        
    }
    
    
    /**
     * Test of registrarUsuari method, of class TotSeries.
     */
    @Test
    public void testRegistrarUsuari() {
        // Usuari ja registrat
        System.out.println("Test de registrarUsuari");
        String userName = "ajaleo";
        String password = "a";
        String nom = "a";
        String nacionalitat = "a";
        Date dataNaixament = new Date(1,2,1990);
        boolean expResult = false;
        boolean result = this._data.registrarUsuari(userName, password, nom, nacionalitat, dataNaixament);
        assertEquals(expResult, result);
        
        // Usuari no registrat
        userName = "test";
        password = "b";
        nom = "b";
        nacionalitat = "b";
        dataNaixament = new Date(1,2,1990);
        expResult = true;
        result = this._data.registrarUsuari(userName, password, nom, nacionalitat, dataNaixament);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of comprovarStatus method, of class TotSeries.
     */
    @Test
    public void testComprovarStatus() {
        // Usuari no esta veient cap capitol
        System.out.println("Test de comprovarStatus");
        String userName = "ajaleo";
        boolean expResult = true;
        boolean result = this._data.getViewStatus(userName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCodi method, of class TotSeries.
     */
    @Test
    public void testGetCodi() {
        // Obtenció del codi del capitol numero 3 del topCapitols
        System.out.println("Test de getCodi");
        // Agafem el capitol numero 3 de la llista de top capitols (que hem inicialitzat)
        int numCap = 2;
        int expResult = 1000002;
        int result = this._data.getCataleg().getTopCapitols().getCapitols().get(numCap).getCodi();
        assertEquals(expResult, result);

    }
    
}
