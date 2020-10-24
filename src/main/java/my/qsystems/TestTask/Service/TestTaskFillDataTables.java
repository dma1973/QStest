package my.qsystems.TestTask.Service;

import java.io.IOException;
import java.util.ArrayList;
import my.qsystems.TestTask.Dao.TestTaskCBRinterface;
import my.qsystems.TestTask.Dao.TestTaskCurrencyRateRepository;
import my.qsystems.TestTask.Dao.TestTaskCurrencyTypeRepository;
import my.qsystems.TestTask.Model.dataCurrencyRate;
import my.qsystems.TestTask.Model.dataCurrencyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTaskFillDataTables {
    @Autowired
    private TestTaskCurrencyTypeRepository repoType;
    @Autowired
    private TestTaskCurrencyRateRepository repoRate;
       
 
     public void fillTables(String from_date,String to_date) throws IOException{
         java.util.List<dataCurrencyType> dt= new ArrayList();
         java.util.List<dataCurrencyRate> dr= new ArrayList();
         
         TestTaskCBRinterface.getCurrencyType(dt,to_date);
       
         for(int i=0;i<dt.size();++i){
            TestTaskCBRinterface.getCurrencyRate(dr,dt.get(i).getCURR_ID(),from_date,to_date);
         }

         repoRate.deleteAll();
         repoType.deleteAll();
         repoType.saveAll(dt);
         repoRate.saveAll(dr);
     }
}
