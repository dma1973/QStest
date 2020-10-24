package my.qsystems.TestTask.Dao;

import java.util.List;
import my.qsystems.TestTask.Model.dataCurrencyRates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestTaskCurrensyRatesRepository extends CrudRepository<dataCurrencyRates, Integer>{
    @Query(value = "CALL getRateTrend(?1,?2,?3)", nativeQuery = true)
    List<dataCurrencyRates> getRateTrend(String id,String d0,String d1);   

    @Query(value = "CALL getRATES(?1)", nativeQuery = true)
    List<dataCurrencyRates> getRates(String date);
    
    @Query(value = "CALL getCURRENCIES()", nativeQuery = true)
    List<dataCurrencyRates> getCurrences(); 
   
 }
