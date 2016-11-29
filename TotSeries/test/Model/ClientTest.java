/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Albert
 */
public class ClientTest {
    
    private ArrayList<Client> clients;
    
    public ClientTest() {
        this.clients = new ArrayList<Client>();
        this.clients.add(new Client("edu", "edu123", "Eduard", "Espanya", new Date(1,1,1990)));
        this.clients.add(new ClientVIP("mrc", "mrc123", "Marc", "Espanya", new Date(1,1,1990)));
        this.clients.add(new Client("grd", "grd123", "Gerard", "Espanya", new Date(1,1,1990)));
        this.clients.add(new ClientVIP("jrd", "jjj123", "Jordi", "Espanya", new Date(1,1,1990)));
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----------- Test de Client ----------");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----------- Fi Test Capitol ----------");
    }
    /**
     * Test of incrementarFactura method, of class Client.
     */
    @Test
    public void testIncrementarFactura() {
        System.out.println("Test de incrementarFactura");
        Iterator<Client> it = this.clients.iterator();
        Client c;
        float expResult;
        float result;
        while(it.hasNext()) {
            c = it.next();
            c.incrementarFactura();
        }
        while(it.hasNext()) {
            c = it.next();
            result = c.getFactura().getValor();
            if (c instanceof Client) {
                expResult = 1f;
                assertEquals(expResult,result);
            }
            else if (c instanceof ClientVIP) {
                expResult = 0.9f;
                assertEquals(expResult,result);
            }
            
        }
    }
    
    /**
     * Test of addValoracio method, of class Client.
     */
    @Test
    public void testAddValoracio() {
        System.out.println("Test de addValoracio");
        Valoracio v = new Valoracio(9, new Date());
        this.clients.get(0).addValoracio(v);
        assertEquals(v, this.clients.get(0).getValoracions().get(this.clients.get(0).getValoracions().size()-1));
        
    }
    
}
