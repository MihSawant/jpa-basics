package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Column(name = "sap_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sapId;   // instead of primitive types better to use wrapper types as we can have null

    private String name;

    @Column(name = "roll_no")
    private String rollNo;

    public Integer getSapId() {
        return sapId;
    }

    public void setSapId(Integer sapId) {
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

    @Override
    public String toString() {
        return "Student{" +
                "sapId=" + sapId +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                '}';
    }
}
