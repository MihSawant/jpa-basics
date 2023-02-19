package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
@SecondaryTable(name = "address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customer"))
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @Column(table = "address", name = "line_1")
    private String firstLine;

    @Column(table = "address", name = "pin_code")
    private String pinCode;

    public Customer(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getPinCode() {
        return pinCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
