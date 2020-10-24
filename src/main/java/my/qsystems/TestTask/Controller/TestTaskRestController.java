package my.qsystems.TestTask.Controller;

import java.io.IOException;
import java.util.List;
import my.qsystems.TestTask.Model.dataCurrencyRates;
import my.qsystems.TestTask.Service.TestTaskCurrencyRatesService;
import my.qsystems.TestTask.Service.TestTaskFillDataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/exchangerate")
public class TestTaskRestController {
     @Autowired
     private TestTaskFillDataTables tables; 
     @Autowired
     private TestTaskCurrencyRatesService CurrencyRates;
     
     @RequestMapping(value = "/trend/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  
     public ResponseEntity<List<dataCurrencyRates>> getRateTrend(@RequestParam("id") String id,@RequestParam("from_date") String d0,@RequestParam("to_date") String d1){
         return new ResponseEntity(CurrencyRates.getRateTrend(id,d0,d1), HttpStatus.OK);
     }
     @RequestMapping(value = "/currencys/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  
     public ResponseEntity<List<dataCurrencyRates>> getCurrencys(){
         return new ResponseEntity(CurrencyRates.getCurrences(), HttpStatus.OK);
     }
     
     @RequestMapping(value = "/rates/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  
     public ResponseEntity<List<dataCurrencyRates>> getRates(@RequestParam("date") String date){
         return new ResponseEntity(CurrencyRates.getRates(date), HttpStatus.OK);
     }
     
  
     @RequestMapping(value = "/filltables/", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)  
     public ResponseEntity<String> fillTables(@RequestParam("date_from") String d0,@RequestParam("date_to") String d1){       
         try {
             tables.fillTables(d0, d1);
         } catch (IOException ex) {
             return new ResponseEntity("Error during filling tables", HttpStatus.NOT_IMPLEMENTED);
         }   
         return new ResponseEntity("Tables filled sucsassfully", HttpStatus.CREATED);
      }
     
}