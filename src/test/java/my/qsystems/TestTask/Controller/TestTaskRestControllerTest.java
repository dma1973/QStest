/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.qsystems.TestTask.Controller;

import java.util.List;
import my.qsystems.TestTask.Model.dataCurrencyRates;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TestTaskRestControllerTest {
    @Autowired
    private   TestTaskRestController instance;
 
    public TestTaskRestControllerTest() {}
    
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
   
    @BeforeEach
    public void setUp() {}
    
    @AfterEach
    public void tearDown() {}

    @Test
    public void testGetRateTrend() {
        System.out.println("getRateTrend");
        String id = "R01010";
        String d0 = "2020-08-05";
        String d1 = "2020-09-05";
        ResponseEntity<List<dataCurrencyRates>> result = instance.getRateTrend(id, d0, d1);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetCurrencys() {
        System.out.println("getCurrencys");
        ResponseEntity<List<dataCurrencyRates>> result = instance.getCurrencys();
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRates() {
        System.out.println("getRates");
        String date = "2020-09-05";
        ResponseEntity<List<dataCurrencyRates>> result = instance.getRates(date);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testFillTables() {
        System.out.println("fillTables");
        String d0 = "2020-09-05";
        String d1 = "2020-09-10";
        ResponseEntity<String> result = instance.fillTables(d0, d1);
        assertEquals(result.getStatusCode(), HttpStatus.CREATED);
        System.out.println(result.toString());
         //fail("The test case is a prototype.");
    }
    
}
