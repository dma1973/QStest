package my.qsystems.TestTask.Service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTaskFillDataTablesTest {
    @Autowired
    private TestTaskFillDataTables instance;
    
    public TestTaskFillDataTablesTest() {}
    
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @BeforeEach
    public void setUp() {}
    
    @AfterEach
    public void tearDown() {}
 
    @Test
    public void testFillTables() throws Exception {
        System.out.println("fillTables");
        String from_date = "05/08/2020";
        String to_date   = "05/09/2020";
        instance.fillTables(from_date, to_date);     
        //fail("The test case is a prototype.");
    }
    
}
