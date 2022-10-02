package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "sap_id")
    private int sapId;

    private String name;

    @Column(name = "roll_no")
    private String rollNo;

    public int getSapId() {
        return sapId;
    }

    public void setSapId(int sapId) {
        this.sapId = sapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
