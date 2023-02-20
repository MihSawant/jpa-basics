package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sap_id")
    private int sapId;


    private String name;

    @Column(name = "roll_no")
    private String rollNo;

    public Student(){};

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

    @Override
    public String toString() {
        return "Student{" +
                "sapId=" + sapId +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                '}';
    }
}
