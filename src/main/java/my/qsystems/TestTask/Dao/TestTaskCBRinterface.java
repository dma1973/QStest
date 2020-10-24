package my.qsystems.TestTask.Dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import my.qsystems.TestTask.Model.dataCurrencyRate;
import my.qsystems.TestTask.Model.dataCurrencyType;
import my.qsystems.TestTask.Service.TestTaskFillDataTables;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

 public class TestTaskCBRinterface {
    
    static private Document getCBRdata(String addr)throws IOException{
         URL url;
         Document document;
         try {
             url = new URL(addr);
         } catch (MalformedURLException ex) {
              throw new IOException("Error getting CBR data: url = new URL(addr)");
         }        
         URLConnection urlConn;
         try {
             urlConn = url.openConnection();
         } catch (IOException ex) {
             throw new IOException("Error getting CBR data: urlConn = url.openConnection()");
         }
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder;
         try {
             builder = factory.newDocumentBuilder();
         } catch (ParserConfigurationException ex) {
             throw new IOException("Error getting CBR data: builder = factory.newDocumentBuilder()");
         }
         try {
             try {
                 document = builder.parse(urlConn.getInputStream());
             } catch (SAXException ex) {
                 throw new IOException("Error getting CBR data: document = builder.parse(urlConn.getInputStream())");
             }
         } catch (IOException ex) {
             throw new IOException("Error getting CBR data: document = builder.parse(urlConn.getInputStream())");
         }
         document.getDocumentElement().normalize(); 
         return document;
    }
    
    static public void getCurrencyType(java.util.List<dataCurrencyType> data,String to_date) throws IOException{
        Document doc;
        try {
            doc = getCBRdata("http://www.cbr.ru/scripts/XML_daily.asp?date_req="+to_date);
        } catch (IOException ex) {
            Logger.getLogger(TestTaskFillDataTables.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("getCurrencyType Error getting CBR document");
        }
         
         NodeList nList = doc.getElementsByTagName("Valute");
         
         for (int i = 0; i < nList.getLength(); i++){
            Element eElement = (Element) nList.item(i);
            dataCurrencyType d= new dataCurrencyType();
            d.setCURR_ID(eElement.getAttribute("ID"));
            d.setCharCode(eElement.getElementsByTagName("CharCode").item(0).getTextContent());
            d.setNumCode(eElement.getElementsByTagName("NumCode").item(0).getTextContent());
            d.setNominal(eElement.getElementsByTagName("Nominal").item(0).getTextContent());
            d.setName(eElement.getElementsByTagName("Name").item(0).getTextContent());
            d.setDate(doc.getElementsByTagName("ValCurs").item(0).getAttributes().getNamedItem("Date").getTextContent());
            data.add(d);
         }
         
     } 
     static public void getCurrencyRate(java.util.List<dataCurrencyRate> data,String id,String from_date,String to_date) throws IOException{
        Document doc;
        
        try {
            doc = getCBRdata("http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1="+from_date+"&date_req2="+to_date+"&VAL_NM_RQ="+id);
        } catch (IOException ex) {
            Logger.getLogger(TestTaskFillDataTables.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("getCurrencyRate Error getting CBR document");
        }
         
         NodeList nList = doc.getElementsByTagName("Record");
 
         DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
         SimpleDateFormat fDestination = new SimpleDateFormat("yyyy-MM-dd");

         for (int i = 0; i < nList.getLength(); i++){
                 Element eElement = (Element) nList.item(i);
                 dataCurrencyRate d= new dataCurrencyRate();
                 d.setCURR_ID(id);
                 d.setValue(eElement.getElementsByTagName("Value").item(0).getTextContent().replace(',','.'));                 
                 try {
                   d.setUPDATED(fDestination.format(formatter.parse(eElement.getAttribute("Date"))));
                   data.add(d);
                 } catch (java.text.ParseException e){}               
         }      
     }
          
}
