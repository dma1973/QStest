package my.qsystems.TestTask.Service;

import java.util.List;
import my.qsystems.TestTask.Dao.TestTaskCurrensyRatesRepository;
import my.qsystems.TestTask.Model.dataCurrencyRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestTaskCurrencyRatesService {
        @Autowired
        private TestTaskCurrensyRatesRepository repository;
        
        public List<dataCurrencyRates> getRates(String date) {
		return repository.getRates(date);
	}  
        public List<dataCurrencyRates> getRateTrend(String id,String d0,String d1) {
		return repository.getRateTrend(id,d0,d1);
	}  
        public List<dataCurrencyRates> getCurrences() {
		return repository.getCurrences();
	}  
}
