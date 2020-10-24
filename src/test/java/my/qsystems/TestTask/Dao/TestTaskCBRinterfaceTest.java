package my.qsystems.TestTask.Dao;

import java.util.ArrayList;
import java.util.List;
import my.qsystems.TestTask.Model.dataCurrencyRate;
import my.qsystems.TestTask.Model.dataCurrencyType;
import org.junit.jupiter.api.Test;

public class TestTaskCBRinterfaceTest {
    
    public TestTaskCBRinterfaceTest() {}
    
    
    @Test
    public void testGetCurrencyType() throws Exception {
        System.out.println("getCurrencyType");
        List<dataCurrencyType> data = new ArrayList();
        String to_date = "05/09/2020";
        TestTaskCBRinterface.getCurrencyType(data, to_date);
        for(int i=0;i<data.size();++i){
            System.out.println(data.get(i).toString());
        }        
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrencyRate method, of class TestTaskCBRinterface.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurrencyRate() throws Exception {
        System.out.println("getCurrencyRate");
        List<dataCurrencyRate> data = new ArrayList();
        String id = "R01010";
        String from_date = "05/09/2020";
        String to_date = "55/09/2020";
        TestTaskCBRinterface.getCurrencyRate(data, id, from_date, to_date);
        for(int i=0;i<data.size();++i){
            System.out.println(data.get(i).toString());
        }
        //fail("The test case is a prototype.");
    }
    
}
