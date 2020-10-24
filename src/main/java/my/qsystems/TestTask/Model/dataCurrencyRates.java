package my.qsystems.TestTask.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class dataCurrencyRates {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="CURR_ID")
    private String CURR_ID;
    @Column(name="coeff")
    private String Normal;
    @Column(name="Char_Code")
    private String CharCode;
    @Column(name="Name")
    private String Name;
    @Column(name="Value")
    private String Value;
    @Column(name="UPDATED")
    private String UPDATED;

    @Override
    public String toString() {
        return "dataCurrencyRates{" + "CURR_ID=" + CURR_ID + ", Normal=" + Normal + ", CharCode=" + CharCode + ", Name=" + Name + ", Value=" + Value + ", UPDATED=" + UPDATED + '}';
    }
    
    public String getNormal() {
        return Normal;
    }

    public String getCharCode() {
        return CharCode;
    }

    public void setCharCode(String CharCode) {
        this.CharCode = CharCode;
    }

    public void setNormal(String Normal) {
        this.Normal = Normal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getCURR_ID() {
        return CURR_ID;
    }

    public void setCURR_ID(String CURR_ID) {
        this.CURR_ID = CURR_ID;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getUPDATED() {
        return UPDATED;
    }

    public void setUPDATED(String UPDATED) {
        this.UPDATED = UPDATED;
    }
    
}