/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package Model;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Albert
 
public class CapitolTest {
    
    private Capitol c1, c2, c3, c4;
    
    public CapitolTest() {
        this.c1 = new Capitol("exemple1.mkv", "90:00", "ES", "descripcio", 7.8f, new Date(1,1,1), 2, 3, 4);
        this.c2 = new Capitol("exemple2.mkv", "60:00", "EN", "descripcio", 8.2f, new Date(1,1,1), 3, 3, 4);
        this.c3 = new Capitol("exemple3.mkv", "60:00", "EN", "descripcio", 5.3f, new Date(1,1,1), 0, 2, 1);
        this.c4 = new Capitol("exemple4.mkv", "60:00", "EN", "descripcio", 5.3f, new Date(1,1,1), 1, 3, 1);
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("----------- Test de Capitol ----------");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("----------- Fi test Capitol ----------");
    }

    /**
     * Test of getCodi method, of class Capitol.
     
    @Test
    public void testGetCodi() {
        // Estrcutura del codi: CCCTTTSSS on CCC=numero capitol, TTT=numero temporada i SSS=numero serie
        System.out.println("Test de getCodi");
        Capitol instance = this.c1;
        int expResult = 2003004;
        int result = instance.getCodi();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Capitol.
     
    @Test
    public void testCompareTo() {
        // CompareTo implementat per a ordenar llista Capitols descendentment per nota
        System.out.println("Test de compareTo");
        int expResult = 1;
        int result = this.c1.compareTo(c2);
        assertEquals(expResult, result);
        
        expResult = -1;
        result = this.c1.compareTo(c3);
        assertEquals(expResult, result);
        
        expResult = 0;
        result = this.c3.compareTo(c4);
        assertEquals(expResult, result);
    }
    
}
*/