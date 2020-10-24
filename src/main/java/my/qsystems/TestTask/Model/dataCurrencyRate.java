package my.qsystems.TestTask.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCY_RATE")
public class dataCurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="CURR_ID")
    private String CURR_ID;
    @Column(name="Value")
    private String Value;
    @Column(name="UPDATED")
    private String UPDATED;

    @Override
    public String toString() {
        return "dataCurrencyRate{" + "id=" + id + ", CURR_ID=" + CURR_ID + ", Value=" + Value + ", UPDATED=" + UPDATED + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
