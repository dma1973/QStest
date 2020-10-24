package my.qsystems.TestTask.Service;

import java.util.List;
import my.qsystems.TestTask.Model.dataCurrencyRates;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTaskCurrencyRatesServiceTest {
    @Autowired
    private TestTaskCurrencyRatesService instance;
    
    public TestTaskCurrencyRatesServiceTest() {}
    
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @BeforeEach
    public void setUp() {}
    
    @AfterEach
    public void tearDown() {}
 
    @Test
    public void testGetRates() {
        System.out.println("======================== getRates ========================");
        String date = "2020-08-11";
        List<dataCurrencyRates> result = instance.getRates(date);
        System.out.println("Found records: "+result.size());
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i).toString());
        }
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRateTrend() {
        System.out.println("(======================== getRateTrend ========================");
        String id = "R01010";
        String d0 = "2020-08-05";
        String d1 = "2020-08-11";
         List<dataCurrencyRates> result = instance.getRateTrend(id, d0, d1);
        System.out.println("Found records: "+result.size());
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i).toString());
        }
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetCurrences() {
        System.out.println("======================== getCurrences ========================");
        List<dataCurrencyRates> result = instance.getCurrences();
        System.out.println("Found records: "+result.size());
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i).toString());
        }
        // fail("The test case is a prototype.");
    }
    
}
