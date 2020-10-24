package my.qsystems.TestTask.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCY_TYPE")
public class dataCurrencyType {
    @Id
    @Column(name="CURR_ID")
    private String CURR_ID;
    @Column(name="Num_Code")
    private String NumCode;
    @Column(name="Char_Code")
    private String CharCode;
    @Column(name="Nominal")
    private String Nominal;
    @Column(name="Name")
    private String Name;
    @Column(name="CREATED")
    private String Date;

    @Override
    public String toString() {
        return "dataCurrencyType{" + "CURR_ID=" + CURR_ID + ", NumCode=" + NumCode + ", CharCode=" + CharCode + ", Nominal=" + Nominal + ", Name=" + Name + ", Date=" + Date + '}';
    }
  
    public String getCURR_ID() {
        return CURR_ID;
    }

    public void setCURR_ID(String CURR_ID) {
        this.CURR_ID = CURR_ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public void setNumCode(String NumCode) {
        this.NumCode = NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String CharCode) {
        this.CharCode = CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public void setNominal(String Nominal) {
        this.Nominal = Nominal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
}
